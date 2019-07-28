package lk.autostreet.services.core.repository;

import lk.autostreet.services.core.model.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long> {

    @Query("SELECT vm FROM VehicleBrand vm WHERE vm.name = :name")
    Optional<VehicleBrand> findByName(@Param("name") String name);
}
