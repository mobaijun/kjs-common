package com.mobaijun.common.util.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: TreeNode
 * description: 树节点
 *
 * @author MoBaiJun 2022/11/5 23:05
 */
@Getter
@Setter
@ToString
public class TreeNode {

    /**
     * 树节点ID
     */
    private String id;

    /**
     * 树节点名称
     */
    private String name;

    /**
     * 树节点编码
     */
    private String code;

    /**
     * 树节点链接
     */
    private String linkUrl;

    /**
     * 树节点图标
     */
    private String icon;

    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * 子节点
     */
    private List<TreeNode> children;
}
