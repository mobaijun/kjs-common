package com.mobaijun.common.shiro;

import com.mobaijun.common.util.tree.MenuNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ShiroPortal
 * class description：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 *
 * @author MoBaiJun 2022/5/12 9:48
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShiroPortal extends ShiroAbstract {

    /**
     * 主键ID
     */
    public Long id;

    /**
     * 账号
     */
    public String account;

    /**
     * 姓名
     */
    public String name;

    /**
     * 角色集
     */
    public List<PortalRole> roleList;

    /**
     * 菜单集
     */
    public List<MenuNode> menuList;

    /**
     * 按钮集
     */
    public List<MenuNode> buttonList;
}
