package lk.autostreet.services.core.model.dto.request.models;

import lk.autostreet.services.core.model.dto.request.RequestBody;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateVehicleModelRequest extends RequestBody {

    @NotEmpty(message = "name is required")
    private String name;
}
