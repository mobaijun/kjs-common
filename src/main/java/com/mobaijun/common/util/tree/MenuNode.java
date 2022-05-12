package com.mobaijun.common.util.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: MenuNode
 * class description：菜单的节点
 *
 * @author MoBaiJun 2022/5/12 9:50
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class MenuNode implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long pid;
    private String name;
}
