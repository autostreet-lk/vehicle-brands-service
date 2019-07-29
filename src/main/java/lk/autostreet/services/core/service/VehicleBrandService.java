package lk.autostreet.services.core.service;

import lk.autostreet.services.core.exception.*;
import lk.autostreet.services.core.model.VehicleBrand;

import java.util.List;

public interface VehicleBrandService extends BaseCrudService<VehicleBrand, Long> {

    List<VehicleBrand> getAllBrands() throws NotFoundException;

    VehicleBrand getBrandById(Long id) throws NotFoundException;

    VehicleBrand update(VehicleBrand vehicleBrand) throws NotUpdatedException;
}
