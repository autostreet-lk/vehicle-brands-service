package lk.autostreet.services.core.model.dto.response.models;

import lk.autostreet.services.core.model.dto.response.ResponseBody;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddVehicleModelResponse extends ResponseBody {

    private Long id;
    private String name;
}
