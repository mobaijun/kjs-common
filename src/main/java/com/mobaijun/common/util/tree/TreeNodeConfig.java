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

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: TreeNodeConfig<br>
 * description: 树节点配置类<br>
 *
 * @author MoBaiJun 2022/11/5 23:47
 */
public class TreeNodeConfig {

    /**
     * 默认属性的单例对象
     */
    private static final TreeNodeConfig INSTANCE = new TreeNodeConfig();

    /**
     * 属性
     */
    private String idKey;

    /**
     *
     */
    private String codeKey;

    /**
     *
     */
    private String nameKey;

    /**
     *
     */
    private String childrenKey;

    /**
     *
     */
    private String parentIdKey;

    /**
     * get id
     *
     * @return id
     */
    public String getIdKey() {
        return getOrDefault(idKey, TreeConstant.TREE_ID);
    }

    /**
     * set id
     *
     * @param idKey id
     */
    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    /**
     * get code
     *
     * @return code
     */
    public String getCodeKey() {
        return getOrDefault(codeKey, TreeConstant.TREE_CODE);
    }

    /**
     * set code
     *
     * @param codeKey code
     */
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    /**
     * get name
     *
     * @return name
     */
    public String getNameKey() {
        return getOrDefault(nameKey, TreeConstant.TREE_NAME);
    }

    /**
     * set name
     *
     * @param nameKey name
     */
    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    /**
     * get children
     *
     * @return children
     */
    public String getChildrenKey() {
        return getOrDefault(childrenKey, TreeConstant.TREE_CHILDREN);
    }

    /**
     * set children
     *
     * @param childrenKey children
     */
    public void setChildrenKey(String childrenKey) {
        this.childrenKey = childrenKey;
    }

    /**
     * get parentId
     *
     * @return parentId
     */
    public String getParentIdKey() {
        return getOrDefault(parentIdKey, TreeConstant.TREE_PARENT_ID);
    }

    /**
     * set parentId
     *
     * @param parentIdKey parentId
     */
    public void setParentIdKey(String parentIdKey) {
        this.parentIdKey = parentIdKey;
    }

    /**
     * get default config
     *
     * @param key        key
     * @param defaultKey defaultKey
     * @return key
     */
    public String getOrDefault(String key, String defaultKey) {
        if (key == null) {
            return defaultKey;
        }
        return key;
    }

    /**
     * default config
     *
     * @return TreeNodeConfig
     */
    public static TreeNodeConfig getDefaultConfig() {
        return INSTANCE;
    }
}