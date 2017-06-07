package co.zw.mdpcz.online.reg.service.impl;

import co.zw.mdpcz.online.reg.domain.Role;
import co.zw.mdpcz.online.reg.repo.RoleRepo;
import co.zw.mdpcz.online.reg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by kmadondo on 5/22/17.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role save(Role role){
        return roleRepo.save(role);
    }

    @Override
    public Optional<Role> findOne(Long id) {
        return Optional.ofNullable(roleRepo.findOne(id));
    }

    @Override
    public Optional<List<Role>> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
