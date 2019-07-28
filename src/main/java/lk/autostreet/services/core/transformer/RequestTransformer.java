package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.model.dto.request.RequestBody;

public interface RequestTransformer<E, D extends RequestBody> {

    E createFrom(D dto);
}