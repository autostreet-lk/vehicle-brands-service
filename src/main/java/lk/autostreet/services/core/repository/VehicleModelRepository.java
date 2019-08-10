package lk.autostreet.services.core.repository;

import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {

    List<VehicleModel> findByBrand(VehicleBrand brand);

    @Query("SELECT vm FROM VehicleModel vm WHERE vm.name = :name AND vm.brand = :brand")
    Optional<VehicleModel> findModelForManufacturer(@Param("name") String name, @Param("brand") VehicleBrand brand);
}
