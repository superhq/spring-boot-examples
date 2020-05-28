例子来源于：https://shiro.apache.org/10-minute-tutorial.html

里面涉及的概念：
1. Subject:指用户，为了避免与其他系统命名冲突，这里叫做Subject
1. Session:会话。每个用户都带会话，不管服务器是不是运行在web容器中
1. Principal:用户名
1. Credential:密码
1. Realm：得到登录数据，并做安全检查 