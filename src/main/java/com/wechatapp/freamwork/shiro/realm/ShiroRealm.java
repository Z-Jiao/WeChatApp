package com.wechatapp.freamwork.shiro.realm;

import com.wechatapp.project.system.user.domain.User;
import com.wechatapp.project.system.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 在Shiro中，最终是通过Realm来获取应用程序中的用户、角色及权限信息的
 * 在Realm中会直接从我们的数据源中获取Shiro需要的验证信息。可以说，Realm是专用于安全框架的DAO.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    private SimpleAuthenticationInfo info = null;

    /**
     * 验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        //从数据库查询用户信息
        User user = userService.findUserById(token.getUsername());
        //用户是否存在
        if (user == null) {
            throw new UnknownAccountException("该用户名不存在！");
        }
        //是否锁定
        if (user != null && user.getStatus() == 1) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        //若存在，将此用户存放到登录认证info中，无需自己做密码对比Shiro会为我们进行密码对比校验
        if (user != null && user.getStatus() == 0) {
            //这里盐值可以自定义
            // 如果查询到了，封装查询结果，返回给我们的调用
            Object principal = user.getUser_id();
            Object credentials = user.getPassword();
            String realmName = this.getName();
            ByteSource salt = ByteSource.Util.bytes(principal);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user, //user
                    credentials, //密码
                    salt,//salt=userid
                    realmName //realm name
            );
            System.out.println(authenticationInfo+"================");
            return authenticationInfo;
        } else {
            // 如果没有查询到，抛出一个异常
            throw new AuthenticationException();
        }

    }

    /**
     * 授权用户权限
     * 授权的方法是在碰到<shiro:hasPermission name=''></shiro:hasPermission>标签的时候调用的
     * 它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示
     * 如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     * <p>
     * shiro的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     * <p>
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo 进行角色的添加和权限的添加。
     * authorizationInfo.addRole(role.getRole()); authorizationInfo.addStringPermission(p.getPermission());
     * <p>
     * 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * authorizationInfo.setRoles(roles); authorizationInfo.setStringPermissions(stringPermissions);
     * <p>
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "perms[权限添加]");
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问
     * <p>
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "roles[100002]，perms[权限添加]");
     * 就说明访问/add这个链接必须要有 "权限添加" 这个权限和具有 "100002" 这个角色才可以访问
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
//        info.addStringPermission("user:add");
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return info;
       /* //获取用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //获取用户角色
        Set<Role> roles =this.roleMapper.findRolesByUserId(user.getUid());
        //添加角色
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        for (Role role : roles) {
            authorizationInfo.addRole(role.getRole());
        }

        //获取用户权限
        Set<Permission> permissions = this.permissionMapper.findPermissionsByRoleId(roles);
        //添加权限
        for (Permission permission:permissions) {
            authorizationInfo.addStringPermission(permission.getPermission());
        }

        return authorizationInfo;
    }
*/
    }
}
