package lk.autostreet.services.core.service;

import lk.autostreet.services.core.exception.AlreadyRegisteredException;
import lk.autostreet.services.core.exception.NotCreatedException;

import java.util.List;
import java.util.Optional;

public interface BaseCrudService<T, PK> {

    <E1 extends NotCreatedException, E2 extends AlreadyRegisteredException> T create(T t) throws E1, E2;

    Optional<T> findById(PK id);

    List<T> findAll();

    void delete(PK id);
}
