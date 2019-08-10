package lk.autostreet.services.core.model.dto.request.brands;

import lk.autostreet.services.core.model.dto.request.RequestBody;
import lombok.Data;

@Data
public class VehicleBrandUpdateRequest extends RequestBody {

    private String name;
}
