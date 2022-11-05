package com.mobaijun.common.util.tree;

import cn.hutool.core.collection.CollectionUtil;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: TreeUtils
 * description: 树工具类
 *
 * @author MoBaiJun 2022/11/6 0:23
 */
public class TreeUtils {

    /**
     * 使用默认参数
     *
     * @param list     要构建的数据列表
     * @param parentId 父id
     * @param convert  转换器
     * @param <T>      object
     * @return 树形结构
     */
    public static <T> List<TreeNodeMap> build(List<T> list, Object parentId, TreeNodeConvert<T, TreeNodeMap> convert) {
        return build(list, parentId, TreeNodeConfig.getDefaultConfig(), convert);
    }

    /**
     * 树构建
     *
     * @param list           要构建的数据列表
     * @param parentId       父id
     * @param treeNodeConfig 树节点配置
     * @param convert        转换器
     * @param <T>            object
     * @return 树形结构
     */
    public static <T> List<TreeNodeMap> build(List<T> list, Object parentId, TreeNodeConfig treeNodeConfig, TreeNodeConvert<T, TreeNodeMap> convert) {
        List<TreeNodeMap> treeNodes = CollectionUtil.newArrayList();
        // 初始化
        list.forEach(item -> {
            TreeNodeMap treeNode = new TreeNodeMap(treeNodeConfig);
            convert.treeNodeConvert(item, treeNode);
            treeNodes.add(treeNode);
        });
        List<TreeNodeMap> finalTreeNodes = CollectionUtil.newArrayList();
        treeNodes.stream()
                .filter(item -> parentId.equals(item.getParentId()))
                .forEach(item -> {
                    finalTreeNodes.add(item);
                    innerBuild(treeNodes, item);
                });
        return finalTreeNodes;
    }

    /**
     * 递归构建树
     *
     * @param treeNodes  树节点集合
     * @param parentNode 父节点集合
     */
    private static void innerBuild(List<TreeNodeMap> treeNodes, TreeNodeMap parentNode) {
        for (TreeNodeMap childNode : treeNodes) {
            if (parentNode.getId().equals(childNode.getParentId())) {
                List<TreeNodeMap> children = parentNode.getChildren();
                if (children == null) {
                    children = CollectionUtil.newArrayList();
                    parentNode.setChildren(children);
                }
                children.add(childNode);
                childNode.setParentId(parentNode.getId());
                innerBuild(treeNodes, childNode);
            }
        }
    }
}
