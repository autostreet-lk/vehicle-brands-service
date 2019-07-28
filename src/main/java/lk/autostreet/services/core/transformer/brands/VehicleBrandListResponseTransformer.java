package lk.autostreet.services.core.transformer.brands;

import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.dto.response.VehicleBrandDetails;
import lk.autostreet.services.core.model.dto.response.VehicleBrandsListResponse;
import lk.autostreet.services.core.transformer.ResponseTransformer;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleBrandListResponseTransformer implements ResponseTransformer<VehicleBrand, VehicleBrandsListResponse> {

    @Override
    public VehicleBrandsListResponse createFrom(List<VehicleBrand> manufacturers) {

        List<VehicleBrandDetails> brandDetailsList = manufacturers.stream()
                .map(manufacturer -> VehicleBrandDetails
                        .builder()
                        .id(manufacturer.getId())
                        .name(manufacturer.getName())
                        .build())
                .collect(Collectors.toList());

        return VehicleBrandsListResponse.builder().brandDetailsList(brandDetailsList).build();
    }
}
