package lk.autostreet.services.core.transformer.models;

import lk.autostreet.services.core.model.VehicleModel;
import lk.autostreet.services.core.model.dto.response.models.VehicleModelDetails;
import lk.autostreet.services.core.model.dto.response.models.VehicleModelListResponse;
import lk.autostreet.services.core.transformer.ResponseListTransformer;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleModelListResponseTransformer implements ResponseListTransformer<VehicleModel, VehicleModelListResponse> {

    @Override
    public VehicleModelListResponse createFrom(List<VehicleModel> vehicleModels){

        List<VehicleModelDetails> modelDetails = vehicleModels.stream()
                .map(model -> VehicleModelDetails
                        .builder()
                        .id(model.getId())
                        .name(model.getName())
                        .build())
                .collect(Collectors.toList());

        return VehicleModelListResponse.builder().vehicleModelDetails(modelDetails).build();
    }
}
