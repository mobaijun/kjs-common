/*
 * Copyright (C) 2022 www.mobaijun.com
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

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: TreeNodeMap<br>
 * description: 树节点包装<br>
 *
 * @author MoBaiJun 2022/11/6 0:19
 */
public class TreeNodeMap extends LinkedHashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 8376668307601977428L;

    /**
     * 默认配置
     */
    private final TreeNodeConfig treeNodeConfig;

    /**
     * 构造器
     */
    public TreeNodeMap() {
        this.treeNodeConfig = TreeNodeConfig.getDefaultConfig();
    }

    public TreeNodeMap(TreeNodeConfig treeNodeConfig) {
        this.treeNodeConfig = treeNodeConfig;
    }

    @SuppressWarnings("unchecked")
    public <T> T getId() {
        return (T) super.get(treeNodeConfig.getIdKey());
    }

    public void setId(String id) {
        super.put(treeNodeConfig.getIdKey(), id);
    }

    @SuppressWarnings("unchecked")
    public <T> T getParentId() {
        return (T) super.get(treeNodeConfig.getParentIdKey());
    }

    public void setParentId(String parentId) {
        super.put(treeNodeConfig.getParentIdKey(), parentId);
    }

    @SuppressWarnings("unchecked")
    public <T> T getName() {
        return (T) super.get(treeNodeConfig.getNameKey());
    }

    public void setName(String name) {
        super.put(treeNodeConfig.getNameKey(), name);
    }

    @SuppressWarnings("unchecked")
    public <T> T getCode() {
        return (T) super.get(treeNodeConfig.getCodeKey());
    }

    public TreeNodeMap setCode(String code) {
        super.put(treeNodeConfig.getCodeKey(), code);
        return this;
    }

    @SuppressWarnings("unchecked")
    public List<TreeNodeMap> getChildren() {
        return (List<TreeNodeMap>) super.get(treeNodeConfig.getChildrenKey());
    }

    public void setChildren(List<TreeNodeMap> children) {
        super.put(treeNodeConfig.getChildrenKey(), children);
    }

    public void extra(String key, Object value) {
        super.put(key, value);
    }
}