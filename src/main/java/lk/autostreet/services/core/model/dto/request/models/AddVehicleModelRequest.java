package lk.autostreet.services.core.model.dto.request.models;

import lk.autostreet.services.core.model.dto.request.RequestBody;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddVehicleModelRequest extends RequestBody {

    @NotEmpty(message = "model name is required")
    private String name;
}
