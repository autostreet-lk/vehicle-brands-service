package lk.autostreet.services.core.controller;

import lk.autostreet.services.core.controller.api.VehicleModelApi;
import lk.autostreet.services.core.exception.BadRequestException;
import lk.autostreet.services.core.exception.AppGenericException;
import lk.autostreet.services.core.model.VehicleModel;
import lk.autostreet.services.core.model.dto.request.models.AddVehicleModelRequest;
import lk.autostreet.services.core.model.dto.response.models.AddVehicleModelResponse;
import lk.autostreet.services.core.model.dto.response.models.VehicleModelListResponse;
import lk.autostreet.services.core.service.VehicleModelService;
import lk.autostreet.services.core.transformer.models.AddNewVehicleModelTransformer;
import lk.autostreet.services.core.transformer.models.VehicleModelListResponseTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lk.autostreet.services.core.config.AccessRole.ROLE_ADMIN;
import static lk.autostreet.services.core.config.AppConfig.VERSION;

@Slf4j
@RestController
public class VehicleModelController implements VehicleModelApi {

    private VehicleModelService vehicleModelService;

    @Autowired
    public VehicleModelController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping(value = "/brands/{brand-id}/models", headers = "X-Api-Version=" + VERSION)
    public VehicleModelListResponse getModelsByBrand(@PathVariable("brand-id") Long brandId) throws AppGenericException {

        List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModelsByBrand(brandId);
        return new VehicleModelListResponseTransformer().createFrom(vehicleModels);
    }


    @PostMapping(value = "/brands/{brand-id}/models", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    public AddVehicleModelResponse addNewVehicleModel(@PathVariable("brand-id") Long brandId,
                                                      @Validated @RequestBody AddVehicleModelRequest requestBody,
                                                      BindingResult bindingResult) throws AppGenericException {

        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            log.error("request body validation failed for creating new vehicle model [{}]", message);
            throw new BadRequestException(message);
        }

        Map<String, Long> params = new HashMap<>();
        params.put("brand_id", brandId);

        AddNewVehicleModelTransformer transformer = new AddNewVehicleModelTransformer(params);
        VehicleModel vehicleModel = transformer.createFrom(requestBody);

        VehicleModel modelCreated = vehicleModelService.create(vehicleModel);
        return transformer.createFrom(modelCreated);
    }


    @DeleteMapping(value = "/models/{model-id}", headers = "X-Api-Version=" + VERSION)
    @RolesAllowed({ROLE_ADMIN})
    public void deleteVehicleModel(@PathVariable("model-id") Long modelId) {
        this.vehicleModelService.delete(modelId);
    }
}
