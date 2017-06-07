package co.zw.mdpcz.online.reg.service;

/**
 * Created by kmadondo on 5/19/17.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

}
