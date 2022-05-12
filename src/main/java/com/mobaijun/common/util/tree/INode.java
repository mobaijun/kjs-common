package com.mobaijun.common.util.tree;

import java.io.Serializable;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: INode
 * interface description：
 * 接口描述：
 *
 * @author MoBaiJun 2022/5/12 9:58
 */
public interface INode extends Serializable {

    /**
     * 获取节点id
     *
     * @return Long
     */
    Long getId();

    /**
     * 获取父id
     *
     * @return Long
     */
    Long getParentId();

    /**
     * 获取节点集合
     *
     * @return List
     */
    List<INode> getChildren();

    /**
     * 判断是否有相同节点
     *
     * @return Boolean
     */
    default Boolean getHasChildren() {
        return false;
    }
}
