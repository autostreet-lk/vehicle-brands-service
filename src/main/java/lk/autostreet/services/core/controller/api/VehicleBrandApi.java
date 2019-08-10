package lk.autostreet.services.core.controller.api;

import lk.autostreet.services.core.exception.*;
import lk.autostreet.services.core.model.dto.request.brands.AddNewVehicleBrandRequest;
import lk.autostreet.services.core.model.dto.request.brands.VehicleBrandUpdateRequest;
import lk.autostreet.services.core.model.dto.response.brands.AddNewVehicleBrandResponse;
import lk.autostreet.services.core.model.dto.response.brands.VehicleBrandsListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

import static lk.autostreet.services.core.config.AppConfig.VERSION;
import static lk.autostreet.services.core.config.AccessRole.ROLE_ADMIN;


public interface VehicleBrandApi {

    @GetMapping(value = "/brands", headers = "X-Api-Version=" + VERSION)
    VehicleBrandsListResponse getAllVehicleBrands() throws AppGenericException;

    @PostMapping(value = "/brands", headers = "X-Api-Version=" + VERSION)
    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({ROLE_ADMIN})
    AddNewVehicleBrandResponse addVehicleBrand(@Validated @RequestBody AddNewVehicleBrandRequest requestBody,
                                               BindingResult bindingResult) throws AppGenericException;

    @PutMapping(value = "/brands/{brand-id}", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    void updateVehicleBrand(@PathVariable("brand-id") Long brandId,
                            @Validated @RequestBody VehicleBrandUpdateRequest requestBody,
                            BindingResult bindingResult) throws AppGenericException;

    @DeleteMapping(value = "/brands/{brand-id}", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    void removeVehicleBrand(@PathVariable("brand-id") Long brandId);
}
