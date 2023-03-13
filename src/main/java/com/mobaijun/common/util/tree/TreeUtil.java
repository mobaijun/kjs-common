/*
 * Copyright (C) 2022 [www.mobaijun.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.util.tree;

import com.mobaijun.common.collection.CollectionUtil;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: TreeUtils<br>
 * description: 树工具类<br>
 *
 * @author MoBaiJun 2022/11/6 0:23
 */
public class TreeUtil {

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