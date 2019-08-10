package lk.autostreet.services.core.model.dto.response.brands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.autostreet.services.core.model.dto.response.ResponseBody;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VehicleBrandsListResponse extends ResponseBody {

    @JsonProperty("brands")
    private List<VehicleBrandDetails> brandDetailsList;
}
