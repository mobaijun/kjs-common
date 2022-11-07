package com.mobaijun.common.util.tree;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: TreeNodeConverter
 * description: 树节点转换器
 *
 * @author MoBaiJun 2022/11/6 0:21
 */
public interface TreeNodeConvert<T, TreeNodeMap> {

    /**
     * 转换器
     *
     * @param data     数据
     * @param treeNode 节点
     */
    void treeNodeConvert(T data, TreeNodeMap treeNode);
}
