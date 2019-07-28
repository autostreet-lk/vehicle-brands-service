package lk.autostreet.services.core.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Data
@Entity
@Table(name = "vehicle_models")
@EntityListeners(AuditingEntityListener.class)
public class VehicleModel extends Auditable<String> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id",nullable = false)
    private VehicleBrand brand;
}
