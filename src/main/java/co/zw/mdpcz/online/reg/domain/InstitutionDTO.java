package co.zw.mdpcz.online.reg.domain;

import java.io.Serializable;

/**
 * Created by kmadondo on 5/23/17.
 */
public class InstitutionDTO implements Serializable {

    private String name;
    private User user;
    private String practitionerInCharge;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPractitionerInCharge() {
        return practitionerInCharge;
    }

    public void setPractitionerInCharge(String practitionerInCharge) {
        this.practitionerInCharge = practitionerInCharge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }*/
}
