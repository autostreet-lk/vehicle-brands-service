package lk.autostreet.services.core.service;

import lk.autostreet.services.core.exception.NotFoundException;
import lk.autostreet.services.core.model.VehicleModel;

import java.util.List;

public interface VehicleModelService extends BaseCrudService<VehicleModel, Long> {

    List<VehicleModel> getVehicleModelsByBrand(Long manufacturerId) throws NotFoundException;

    VehicleModel getVehicleModelById(Long id) throws NotFoundException;

}
