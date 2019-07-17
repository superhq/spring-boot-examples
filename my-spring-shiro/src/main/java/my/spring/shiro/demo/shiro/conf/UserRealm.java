package my.spring.shiro.demo.shiro.conf;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collections;

public class UserRealm extends AuthorizingRealm {
    //授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermission("user:del");
        return authorizationInfo;
    }

    //认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String user = "hq";
        String password = "123456";
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        if(!token.getUsername().equals("hq")){
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("",password,"");


        return simpleAuthenticationInfo;
    }

}
