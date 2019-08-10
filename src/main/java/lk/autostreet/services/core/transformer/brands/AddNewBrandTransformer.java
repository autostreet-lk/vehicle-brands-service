package lk.autostreet.services.core.transformer.brands;

import lk.autostreet.services.core.exception.TransformException;
import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.dto.request.brands.AddNewVehicleBrandRequest;
import lk.autostreet.services.core.model.dto.response.brands.AddNewVehicleBrandResponse;
import lk.autostreet.services.core.transformer.Transformer;

public class AddNewBrandTransformer implements Transformer<VehicleBrand, AddNewVehicleBrandRequest, AddNewVehicleBrandResponse> {

    @Override
    public VehicleBrand createFrom(AddNewVehicleBrandRequest dto) {
        VehicleBrand vehicleManufacturer = new VehicleBrand();
        vehicleManufacturer.setName(dto.getName());
        return vehicleManufacturer;
    }


    public AddNewVehicleBrandResponse createFrom(VehicleBrand vehicleManufacturer) throws TransformException {

        if (vehicleManufacturer == null) {
            throw new TransformException("VehicleBrand is not found");
        }

        return AddNewVehicleBrandResponse.builder()
                .id(vehicleManufacturer.getId())
                .name(vehicleManufacturer.getName())
                .build();
    }
}
