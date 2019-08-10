package lk.autostreet.services.core.model.dto.response.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleModelDetails {

    private Long id;
    private String name;
}
