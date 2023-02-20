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
package com.mobaijun.common.test.converter;

import com.mobaijun.common.test.converter.model.User;
import com.mobaijun.common.test.converter.model.UserVO;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.converter.EntityUtil;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: EntityUtilTest
 * class description: 对象转换器测试
 *
 * @author MoBaiJun 2022/12/10 18:39
 */
public class EntityUtilTest {

    @Test
    public void entityUtilTest() {
        User user = new User();
        user.setName("mobaijun");
        user.setAddress("广州");
        user.setAge(18);
        user.setDeleted('1');
        String name = EntityUtil.toObj(user, User::getName);
        PrintUtil.println(name);

        UserVO userVO = EntityUtil.toObj(user, UserVO::new);
    }
}
