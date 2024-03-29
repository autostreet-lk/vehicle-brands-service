package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.exception.TransformException;
import lk.autostreet.services.core.model.dto.response.ResponseBody;

public interface ResponseTransformer<E, D extends ResponseBody> {
    D createFrom(E e) throws TransformException;
}