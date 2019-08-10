package lk.autostreet.services.core.transformer.models;

import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.VehicleModel;
import lk.autostreet.services.core.model.dto.request.models.AddVehicleModelRequest;
import lk.autostreet.services.core.model.dto.response.models.AddVehicleModelResponse;
import lk.autostreet.services.core.transformer.Transformer;

import java.util.Map;

public class AddNewVehicleModelTransformer implements Transformer<VehicleModel, AddVehicleModelRequest, AddVehicleModelResponse> {

    private Map<String, Long> params;

    public AddNewVehicleModelTransformer(Map<String, Long> params) {
        this.params = params;
    }

    @Override
    public VehicleModel createFrom(AddVehicleModelRequest dto) {

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setName(dto.getName());

        VehicleBrand brand = new VehicleBrand();
        brand.setId(params.get("brand_id"));
        vehicleModel.setBrand(brand);
        return vehicleModel;
    }

    @Override
    public AddVehicleModelResponse createFrom(VehicleModel vehicleModel) {
        return AddVehicleModelResponse.builder()
                .id(vehicleModel.getId())
                .name(vehicleModel.getName())
                .build();
    }
}
