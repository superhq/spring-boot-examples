# 需求熟悉的概念
1. Subject:指用户，为了避免与其他系统命名冲突，这里叫做Subject
1. Session:会话。每个用户都带会话，不管服务器是不是运行在web容器中
1. Principal:用户名
1. Credential:密码
1. Realm：定义安全认证的方式
1. SecurityManager:是shiro框架的核心
1. SecurityUtils: 通过SecurityUtils获取当前用户和进行认证授权工作

# Realm、SecurityManager、SecurityUtils三者的关系

Realm --> SecurityManager --> SecurityUtils

熟悉下面代码：
```java
IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
SecurityManager securityManager = new DefaultSecurityManager(iniRealm);
 
SecurityUtils.setSecurityManager(securityManager);
Subject currentUser = SecurityUtils.getSubject();
```

# Realm的实现
doGetAuthenticationInfo的执行时机：
```java
Subject currentUser = SecurityUtils.getSubject();
currentUser.login(token);
```

doGetAuthorizationInfo的执行时机：

1. subject.hasRole(“admin”) 或 subject.isPermitted(“admin”)：自己去调用这个是否有什么角色或者是否有什么权限的时候；
1. @RequiresRoles("admin") ：在方法上加注解的时候；
1. [@shiro.hasPermission name = "admin"][/@shiro.hasPermission]：在页面上加shiro标签的时候，即进这个页面的时候扫描到有这个标签的时候。


![](https://shiro.apache.org/assets/images/ShiroAuthenticationSequence.png)