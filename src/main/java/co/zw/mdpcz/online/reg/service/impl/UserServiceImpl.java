package co.zw.mdpcz.online.reg.service.impl;

import co.zw.mdpcz.online.reg.domain.Role;
import co.zw.mdpcz.online.reg.domain.User;
import co.zw.mdpcz.online.reg.repo.RoleRepo;
import co.zw.mdpcz.online.reg.repo.UserRepo;
import co.zw.mdpcz.online.reg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

/**
 * Created by kmadondo on 5/19/17.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void createNew(User user) {
        System.out.println("user password" + user.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>((Collection<? extends Role>) roleRepo.findAll()));
        userRepo.save(user);
    }

    @Override
    public User save(User t) {
        return userRepo.save(t);
    }

    @Override
    public Optional<User> findOne(Long id) {
        return Optional.ofNullable(userRepo.findOne(id));
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUserName(username);
    }

   /* @Override
    public User getCurrentUser() {
        String username = getCurrentUsername();
        if(username == null){
            return null;
        }
        User user = findByUserName(username);
        if (user == null) {
            return null;
        }
        return null;
    }*/
}
