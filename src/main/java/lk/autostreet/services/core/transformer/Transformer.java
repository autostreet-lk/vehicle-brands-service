package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.model.dto.request.RequestBody;
import lk.autostreet.services.core.model.dto.response.ResponseBody;

public interface Transformer<E, R1 extends RequestBody, R2 extends ResponseBody> extends RequestTransformer<E, R1>, ResponseTransformer<E, R2> {

}