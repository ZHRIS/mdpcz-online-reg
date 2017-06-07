package co.zw.mdpcz.online.reg.service;

import co.zw.mdpcz.online.reg.domain.User;

import java.util.Optional;

/**
 * Created by kmadondo on 5/19/17.
 */
public interface UserService{

    //User save(User user);

    User save(User t);

    void createNew(User user);

    Optional<User> findOne(Long id);

    User findByUsername(String username);

    //User getCurrentUser();
}
