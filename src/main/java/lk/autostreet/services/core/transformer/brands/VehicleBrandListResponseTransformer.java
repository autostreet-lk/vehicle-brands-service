package lk.autostreet.services.core.transformer.brands;

import lk.autostreet.services.core.exception.TransformException;
import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.dto.response.VehicleBrandDetails;
import lk.autostreet.services.core.model.dto.response.VehicleBrandsListResponse;
import lk.autostreet.services.core.transformer.ResponseListTransformer;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleBrandListResponseTransformer implements ResponseListTransformer<VehicleBrand, VehicleBrandsListResponse> {

    @Override
    public VehicleBrandsListResponse createFrom(List<VehicleBrand> brands) throws TransformException {

        if (brands == null) {
            throw new TransformException("vehicle brands required");
        }
        List<VehicleBrandDetails> brandDetailsList = brands.stream()
                .map(brand -> VehicleBrandDetails.builder()
                        .id(brand.getId())
                        .name(brand.getName())
                        .build())
                .collect(Collectors.toList());

        return VehicleBrandsListResponse.builder().brandDetailsList(brandDetailsList).build();
    }
}
