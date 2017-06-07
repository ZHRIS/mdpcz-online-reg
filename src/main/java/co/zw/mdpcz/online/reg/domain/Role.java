package co.zw.mdpcz.online.reg.domain;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by kmadondo on 5/20/17.
 */
@Entity
public class Role {

    private Long id;
    private String name;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Transient
    public boolean isNew() {
        return (getId() == null);
    }
}
