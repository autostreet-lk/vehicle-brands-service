package lk.autostreet.services.core.controller.api;

import lk.autostreet.services.core.exception.AppGenericException;
import lk.autostreet.services.core.model.dto.request.models.AddVehicleModelRequest;
import lk.autostreet.services.core.model.dto.response.models.AddVehicleModelResponse;
import lk.autostreet.services.core.model.dto.response.models.VehicleModelListResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

import static lk.autostreet.services.core.config.AccessRole.ROLE_ADMIN;
import static lk.autostreet.services.core.config.AppConfig.VERSION;

public interface VehicleModelApi {

    @GetMapping(value = "/brands/{brand-id}/models", headers = "X-Api-Version=" + VERSION)
    VehicleModelListResponse getModelsByBrand(@PathVariable("brand-id") Long brandId) throws AppGenericException;


    @PostMapping(value = "/brands/{brand-id}/models", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    AddVehicleModelResponse addNewVehicleModel(@PathVariable("brand-id") Long brandId,
                                               @Validated @RequestBody AddVehicleModelRequest requestBody,
                                               BindingResult bindingResult) throws AppGenericException;


    @DeleteMapping(value = "/models/{model-id}", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    void deleteVehicleModel(@PathVariable("model-id") Long modelId);
}
