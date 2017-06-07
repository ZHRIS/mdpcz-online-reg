package co.zw.mdpcz.online.reg.repo;

import co.zw.mdpcz.online.reg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by kmadondo on 5/19/17.
 */
@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    @Query("select u from User u where u.userName = :userName")
    User findByUserName(@Param("userName") String userName);
}
