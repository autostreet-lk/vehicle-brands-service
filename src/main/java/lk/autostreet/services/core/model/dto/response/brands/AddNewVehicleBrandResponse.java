package lk.autostreet.services.core.model.dto.response.brands;

import lk.autostreet.services.core.model.dto.response.ResponseBody;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddNewVehicleBrandResponse extends ResponseBody {

    private Long id;
    private String name;
}
