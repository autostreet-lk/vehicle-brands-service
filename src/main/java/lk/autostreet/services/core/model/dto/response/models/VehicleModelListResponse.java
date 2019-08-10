package lk.autostreet.services.core.model.dto.response.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.autostreet.services.core.model.dto.response.ResponseBody;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VehicleModelListResponse extends ResponseBody {

    @JsonProperty("models")
    private List<VehicleModelDetails> vehicleModelDetails;
}
