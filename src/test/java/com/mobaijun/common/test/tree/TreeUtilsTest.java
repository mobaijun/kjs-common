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
package com.mobaijun.common.test.tree;

import com.mobaijun.common.result.R;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.tree.TreeNodeMap;
import com.mobaijun.common.util.tree.TreeUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: TreeUtilsTest
 * class description: 树工具类测试
 *
 * @author MoBaiJun 2022/11/22 15:20
 */
public class TreeUtilsTest {

    @Test
    public void treeUtilsTest() {
        List<Mode> list = new LinkedList<>();
        list.add(new Mode(1, "Node 1", 0));
        list.add(new Mode(2, "Node 2", 0));
        list.add(new Mode(3, "Node 1.1", 1));
        list.add(new Mode(4, "Node 1.2", 1));
        list.add(new Mode(5, "Node 1.3", 1));
        list.add(new Mode(6, "Node 2.1", 2));
        list.add(new Mode(7, "Node 2.2", 2));
        list.add(new Mode(8, "Node 2.2.1", 7));
        List<TreeNodeMap> build = TreeUtil.build(list, "0", (data, treeNode) -> {
            treeNode.setId(String.valueOf(data.getId()));
            treeNode.setParentId(String.valueOf(data.parentId));
            treeNode.setName(data.getName());
        });
        PrintUtil.println(R.ok(build));
    }

    /**
     * 测试类
     */
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    static class Mode {

        /**
         * id
         */
        private Integer id;

        /**
         * 名称
         */
        private String name;

        /**
         * 父id
         */
        private Integer parentId;
    }
}
