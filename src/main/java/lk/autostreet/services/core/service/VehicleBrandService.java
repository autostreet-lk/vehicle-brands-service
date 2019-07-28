package lk.autostreet.services.core.service;

import lk.autostreet.services.core.exception.*;
import lk.autostreet.services.core.model.VehicleBrand;

import java.util.List;

public interface VehicleBrandService extends BaseCrudService<VehicleBrand, Long> {

//    VehicleBrand create(VehicleBrand vehicleBrand) throws VehicleBrandAlreadyExistsException, VehicleBrandNotCreatedException;

    List<VehicleBrand> getAllBrands() throws VehicleBrandNotFoundException;

    VehicleBrand getBrandById(Long id) throws VehicleBrandNotFoundException;

    VehicleBrand update(VehicleBrand vehicleBrand)
            throws VehicleBrandNotFoundException, VehicleBrandNotUpdatedException;
}
