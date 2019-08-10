package lk.autostreet.services.core.service.impl;

import lk.autostreet.services.core.exception.AlreadyRegisteredException;
import lk.autostreet.services.core.exception.NotCreatedException;
import lk.autostreet.services.core.exception.NotFoundException;
import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.VehicleModel;
import lk.autostreet.services.core.repository.VehicleModelRepository;
import lk.autostreet.services.core.service.VehicleBrandService;
import lk.autostreet.services.core.service.VehicleModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    private VehicleModelRepository vehicleModelRepository;
    private VehicleBrandService brandService;

    @Autowired
    public VehicleModelServiceImpl(VehicleModelRepository vehicleModelRepository,VehicleBrandService brandService) {
        this.brandService = brandService;
        this.vehicleModelRepository = vehicleModelRepository;
    }

    @Override
    public VehicleModel create(VehicleModel vehicleModel)
            throws NotCreatedException, AlreadyRegisteredException {

        if (vehicleModel == null || vehicleModel.getBrand() == null) {
            log.error("vehicle model details are not set");
            throw new NotCreatedException("vehicle model details are not set");
        }

        VehicleBrand brand = vehicleModel.getBrand();

        Optional<VehicleModel> vehicleModelOptional = vehicleModelRepository.findModelForManufacturer(vehicleModel.getName().trim(), brand);
        if (vehicleModelOptional.isPresent()) {
            log.error("vehicle model [{}] is already registered for brand [{}] ", vehicleModel.getName(), brand.getName());
            throw new AlreadyRegisteredException("vehicle model [" + vehicleModel.getName() + "] is already registered for brand [" + brand.getName() + "] ");
        }
        return vehicleModelRepository.save(vehicleModel);
    }


    @Override
    public Optional<VehicleModel> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return vehicleModelRepository.findById(id);
    }

    @Override
    public List<VehicleModel> findAll() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public List<VehicleModel> getVehicleModelsByBrand(Long brandId) throws NotFoundException {

        if (brandId == null || brandId.equals(0L)) {
            throw new NotFoundException("Manufacturer id [" + brandId + "] is invalid");
        }
        VehicleBrand brand = brandService.getBrandById(brandId);
        return vehicleModelRepository.findByBrand(brand);
    }

    @Override
    public VehicleModel getVehicleModelById(Long id) throws NotFoundException {
        Optional<VehicleModel> vehicleModelOptional = findById(id);
        return vehicleModelOptional.orElseThrow(() -> new NotFoundException("No vehicle model found with id [" + id + "]"));
    }

    @Override
    public void delete(Long id) {
        Optional<VehicleModel> vehicleModelOptional = vehicleModelRepository.findById(id);
        vehicleModelOptional.ifPresent(vehicleModelRepository::delete);
    }
}
