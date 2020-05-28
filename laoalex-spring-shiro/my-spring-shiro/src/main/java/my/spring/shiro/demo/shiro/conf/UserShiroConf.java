package my.spring.shiro.demo.shiro.conf;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class UserShiroConf {


    //处理认证过程
    @Bean("userRealm")
    public UserRealm getUserRealm() {
        return new UserRealm();
    }


    //在安全管理器中设置Realm
    @Bean("securityManager")
    public SecurityManager getSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager)
    {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =  new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    @Bean
    //@DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator()
    {
        return new DefaultAdvisorAutoProxyCreator();
    }


    //配置过滤器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filter = new LinkedHashMap<String, String>();
        //认证过滤器
        filter.put("/user/index", "anon");
        filter.put("/user/login", "anon");
        filter.put("/user/add", "authc");
        filter.put("/user/del", "authc");
        //权限过滤器
        //filter.put("/user/del", "perms[user:del]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filter);
        //默认的处理过程
        shiroFilterFactoryBean.setLoginUrl("login");
        shiroFilterFactoryBean.setUnauthorizedUrl("401");
        return shiroFilterFactoryBean;
    }

}
