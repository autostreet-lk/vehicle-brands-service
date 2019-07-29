package lk.autostreet.services.core.transformer;

import lk.autostreet.services.core.exception.TransformException;
import lk.autostreet.services.core.model.dto.response.ResponseBody;

import java.util.List;

public interface ResponseListTransformer<E, D extends ResponseBody> {

    D createFrom(List<E> es) throws TransformException;
}