package lk.autostreet.services.core.model.dto.response.brands;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class VehicleBrandDetails implements Serializable {

    private Long id;
    private String name;
}
