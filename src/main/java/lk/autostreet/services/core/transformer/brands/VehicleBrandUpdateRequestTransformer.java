package lk.autostreet.services.core.transformer.brands;

import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.dto.request.VehicleBrandUpdateRequest;
import lk.autostreet.services.core.transformer.RequestTransformer;

public class VehicleBrandUpdateRequestTransformer implements RequestTransformer<VehicleBrand, VehicleBrandUpdateRequest> {

    @Override
    public VehicleBrand createFrom(VehicleBrandUpdateRequest dto) {

        VehicleBrand manufacturer = new VehicleBrand();
        manufacturer.setName(dto.getName());
        return manufacturer;
    }
}
