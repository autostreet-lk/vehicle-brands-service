package lk.autostreet.services.core.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "vehicle_brands")
@EntityListeners(AuditingEntityListener.class)
public class VehicleBrand extends Auditable<String> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private List<VehicleModel> vehicleModels = new ArrayList<>();
}
