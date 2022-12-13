package com.mobaijun.common.test.stream;


import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.collection.CollectionUtil;
import com.mobaijun.common.util.stream.StreamUtil;

import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: StreamUtilTest<br>
 * class description: <br>
 *
 * @author MoBaiJun 2022/12/13 10:18
 */
public class StreamUtilTest {
    public static void main(String[] args) {
        Map<String, String> map = CollectionUtil.newHashMap();
        map.put("mobaijun", "123");
        Map<String, String> maps = CollectionUtil.newHashMap();
        maps.put("s", "ss");
        // 两个Map进行合并
        StreamUtil.addAll(map, maps);
        PrintUtil.println(map);

        // 生成list
        List<String> list = StreamUtil.toList("2", "2", "3", "4");
        PrintUtil.println(list);
    }
}
