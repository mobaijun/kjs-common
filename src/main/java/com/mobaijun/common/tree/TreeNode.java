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
package com.mobaijun.common.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: TreeNode<br>
 * description: 树节点<br>
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