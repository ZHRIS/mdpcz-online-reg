package co.zw.mdpcz.online.reg.service;

import java.util.List;
import java.util.Optional;

/**
 * Created by kmadondo on 5/19/17.
 */
public interface IService<T> {

    T save(T t);

    Optional<T> findOne(Long id);

    Optional<List<T>> findAll();

    void delete(Long id);

}
