package lk.autostreet.services.core.controller;

import lk.autostreet.services.core.exception.*;
import lk.autostreet.services.core.model.VehicleBrand;
import lk.autostreet.services.core.model.dto.request.AddNewVehicleBrandRequest;
import lk.autostreet.services.core.model.dto.request.VehicleBrandUpdateRequest;
import lk.autostreet.services.core.model.dto.response.AddNewVehicleBrandResponse;
import lk.autostreet.services.core.model.dto.response.VehicleBrandsListResponse;
import lk.autostreet.services.core.service.VehicleBrandService;
import lk.autostreet.services.core.transformer.brands.AddNewBrandTransformer;
import lk.autostreet.services.core.transformer.brands.VehicleBrandListResponseTransformer;
import lk.autostreet.services.core.transformer.brands.VehicleBrandUpdateRequestTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

import java.util.List;

import static lk.autostreet.services.core.config.AppConfig.VERSION;
import static lk.autostreet.services.core.config.AccessRole.ROLE_ADMIN;

@Slf4j
@RestController
public class VehicleBrandController implements VehicleBrandApi {

    private VehicleBrandService brandService;

    @Autowired
    public VehicleBrandController(VehicleBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(value = "/brands", headers = "X-Api-Version=" + VERSION)
    public VehicleBrandsListResponse getAllVehicleBrands() throws VehicleBrandNotFoundException {
        log.info("request to get all vehicle brands");
        List<VehicleBrand> vehicleManufacturers = brandService.getAllBrands();

        log.debug("[{}] of vehicle brands found", vehicleManufacturers.size());
        return new VehicleBrandListResponseTransformer().createFrom(vehicleManufacturers);
    }


    @PostMapping(value = "/brands", headers = "X-Api-Version=" + VERSION)
    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({ROLE_ADMIN})
    public AddNewVehicleBrandResponse addVehicleBrand(@Validated @RequestBody AddNewVehicleBrandRequest requestBody,
                                                      BindingResult bindingResult)
            throws NotCreatedException, AlreadyExistsException, VehicleBrandGenericException {

        log.debug("request to create new vehicle brand [{}] ", requestBody.toString());

        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            log.error("request body validation failed for creating new vehicle brand [{}]", message);
            throw new VehicleBrandNotCreatedException(message);
        }

        AddNewBrandTransformer transformer = new AddNewBrandTransformer();
        VehicleBrand brand = transformer.createFrom(requestBody);
        VehicleBrand vehicleBrandCreated = brandService.create(brand);

        log.debug("successfully created the vehicle brand with id [{}] ", vehicleBrandCreated.getId());
        return transformer.createFrom(vehicleBrandCreated);
    }


    @PutMapping(value = "/brands/{brand-id}", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    public void updateVehicleBrand(@PathVariable("brand-id") Long brandId,
                                   @Validated @RequestBody VehicleBrandUpdateRequest requestBody, BindingResult bindingResult)
            throws VehicleBrandNotUpdatedException, VehicleBrandNotFoundException {

        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            log.error("request body validation failed for updating vehicle brand with id [{}] ; error [{}]", brandId, message);
            throw new VehicleBrandNotUpdatedException(message);
        }

        VehicleBrandUpdateRequestTransformer transformer = new VehicleBrandUpdateRequestTransformer();
        VehicleBrand vehicleBrand = transformer.createFrom(requestBody);
        vehicleBrand.setId(brandId);

        brandService.update(vehicleBrand);
    }


    @DeleteMapping(value = "/brands/{brand-id}", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    public void removeVehicleBrand(@PathVariable("brand-id") Long brandId) {
        brandService.delete(brandId);
    }
}
