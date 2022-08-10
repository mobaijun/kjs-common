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