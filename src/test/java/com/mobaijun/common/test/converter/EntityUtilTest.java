package com.mobaijun.common.test.converter;

import com.mobaijun.common.test.converter.model.User;
import com.mobaijun.common.test.converter.model.UserVO;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.converter.EntityUtil;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: EntityUtilTest
 * class description: 对象转换器测试
 *
 * @author MoBaiJun 2022/12/10 18:39
 */
public class EntityUtilTest {
    public static void main(String[] args) {
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
