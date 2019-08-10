package lk.autostreet.services.core.service.impl;

import lk.autostreet.services.core.exception.*;
import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.repository.VehicleBrandRepository;
import lk.autostreet.services.core.service.VehicleBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class VehicleBrandServiceImpl implements VehicleBrandService {

    private VehicleBrandRepository vehicleBrandRepository;

    @Autowired
    public VehicleBrandServiceImpl(VehicleBrandRepository vehicleManufacturerRepository) {
        this.vehicleBrandRepository = vehicleManufacturerRepository;
    }

    @Override
    public VehicleBrand create(VehicleBrand vehicleManufacturer) throws NotCreatedException,AlreadyRegisteredException {
        if (vehicleManufacturer == null || vehicleManufacturer.getName() == null) {
            log.error("vehicle brand details are not set");
            throw new NotCreatedException("vehicle brand details are not set");
        }
        Optional<VehicleBrand> vehicleBrandOptional = vehicleBrandRepository.findByName(vehicleManufacturer.getName().trim());
        if (vehicleBrandOptional.isPresent()) {
            log.error("vehicle brand [{}] is already registered", vehicleManufacturer.getName());
            throw new AlreadyRegisteredException("vehicle brand [" + vehicleManufacturer.getName() + "] is already registered");
        }

//        try {
            return vehicleBrandRepository.save(vehicleManufacturer);
//        } catch (Exception ex) {
//            log.error(" error occurred while creating the vehicle brand [{}] ", ex.getMessage());
//            throw new NotCreatedException(ex.getMessage());
//        }
    }

    @Override
    public Optional<VehicleBrand> findById(Long id) {
        if (id == null) {
            log.debug("brand id is not found");
            return Optional.empty();
        }
        return vehicleBrandRepository.findById(id);
    }

    @Override
    public List<VehicleBrand> findAll() {
        return vehicleBrandRepository.findAll();
    }

    @Override
    public List<VehicleBrand> getAllBrands() throws NotFoundException {

        List<VehicleBrand> vehicleManufacturers = vehicleBrandRepository.findAll();

        if (vehicleManufacturers.isEmpty()) {
            log.error("No vehicle brand found ");
            throw new NotFoundException("No vehicle brands found");
        }
        return vehicleManufacturers;
    }

    @Override
    public VehicleBrand getBrandById(Long id) throws NotFoundException {
        Optional<VehicleBrand> vehicleManufacturerOptional = this.findById(id);
        return vehicleManufacturerOptional.orElseThrow(() -> new NotFoundException("No vehicle brand found with id [" + id + "] "));
    }

    @Override
    public void delete(Long id) {
        Optional<VehicleBrand> vehicleManufacturerOptional = vehicleBrandRepository.findById(id);
        vehicleManufacturerOptional.ifPresent(vehicleBrandRepository::delete);
    }

    @Override
    public VehicleBrand update(VehicleBrand vehicleManufacturer) throws NotUpdatedException {

        if (vehicleManufacturer == null || vehicleManufacturer.getId() == null) {
            log.error("no vehicle brand details found");
            throw new NotUpdatedException("No vehicle brand details found");
        }

        Optional<VehicleBrand> vehicleManufacturerOptional = findById(vehicleManufacturer.getId());

        if (vehicleManufacturerOptional.isEmpty()) {
            log.error("No vehicle brand found with id [{}]", vehicleManufacturer.getId());
            throw new NotUpdatedException("No vehicle brand found with id [" + vehicleManufacturer.getId() + "] ");
        }
        VehicleBrand manufacturer = vehicleManufacturerOptional.get();

        //check whether the given vehicle brand is already registered
        Optional<VehicleBrand> vehicleManufacturerOptional2 = vehicleBrandRepository.findByName(vehicleManufacturer.getName().trim());

        if (vehicleManufacturerOptional2.isPresent() && Objects.nonNull(vehicleManufacturerOptional2.get().getId())
                && !vehicleManufacturerOptional2.get().getId().equals(vehicleManufacturer.getId())) {
            throw new NotUpdatedException("name [" + vehicleManufacturer.getName() + "] already registered for another vehicle brand");
        }

        manufacturer.setName(vehicleManufacturer.getName());

//        try {
        return vehicleBrandRepository.save(manufacturer);
//        } catch (Exception ex) {
//            log.error("error occurred while updating the vehicle brand [{}] details [{}]", vehicleManufacturer.getId(), ex.getMessage());
//            throw new VehicleBrandNotUpdatedException(ex.getMessage());
//        }
    }
}
