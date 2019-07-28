package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.exception.TransformException;
import lk.autostreet.services.core.model.dto.response.ResponseBody;

import java.util.List;

public interface ResponseTransformer<E, D extends ResponseBody> {

    default D createFrom(E e) throws TransformException {
        throw new TransformException("Transform strategy is not implemented");
    }

    default D createFrom(List<E> es) throws TransformException {
        throw new TransformException("Transform strategy is not implemented");
    }
}