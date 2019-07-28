package lk.autostreet.services.core.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddNewVehicleBrandRequest extends RequestBody {

    @NotEmpty(message = "brand name is required")
    private String name;
}
