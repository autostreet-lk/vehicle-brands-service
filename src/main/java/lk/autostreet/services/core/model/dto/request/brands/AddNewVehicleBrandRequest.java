package lk.autostreet.services.core.model.dto.request.brands;

import lk.autostreet.services.core.model.dto.request.RequestBody;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddNewVehicleBrandRequest extends RequestBody {

    @NotEmpty(message = "brand name is required")
    private String name;
}
