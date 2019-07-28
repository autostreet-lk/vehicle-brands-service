package lk.autostreet.services.core.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddNewVehicleBrandResponse extends ResponseBody {

    private Long id;
    private String name;
}
