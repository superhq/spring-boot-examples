package my.spring.shiro.demo.shiro.conf;

import my.spring.shiro.demo.mapper.UserMapper;
import my.spring.shiro.demo.model.Perm;
import my.spring.shiro.demo.model.Role;
import my.spring.shiro.demo.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    //授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            authorizationInfo.addRole(role.getName());
            List<Perm> perms = role.getPerms();
            for (Perm perm : perms) {
                authorizationInfo.addStringPermission(perm.getperm());
            }
        }
        return authorizationInfo;
    }

    //认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.getUserByName(token.getUsername());
        if (user != null) {

            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, token.getCredentials(), "");


            return simpleAuthenticationInfo;
        }
        return null;
    }

}
