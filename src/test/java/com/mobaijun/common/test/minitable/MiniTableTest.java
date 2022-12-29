package com.mobaijun.common.test.minitable;

import com.mobaijun.common.minitable.MiniTable;
import com.mobaijun.common.util.PrintUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: MiniTableTest<br>
 * class description: <a href="https://github.com/blinkfox/mini-table">...</a><br>
 *
 * @author MoBaiJun 2022/12/29 9:33
 */
public class MiniTableTest {

    private static final String TABLE = ""
            + "+-------------------------------------------------------------+\n"
            + "|                          The Title                          |\n"
            + "+-----------+--------+-----+--------------------+-------------+\n"
            + "|   Name    |  Sex   | Age |       Email        |    Phone    |\n"
            + "+-----------+--------+-----+--------------------+-------------+\n"
            + "|   LiLei   |  male  | 25  |  lilei@gmail.com   | 13809345219 |\n"
            + "| hanMeiMei | female | 23  |    hmm@163.com     | 13515343853 |\n"
            + "+-----------+--------+-----+--------------------+-------------+\n"
            + "|   Name    |  Sex   | Age |       Email        |    Phone    |\n"
            + "+-----------+--------+-----+--------------------+-------------+\n"
            + "| ZhangSan  | female | 32  | zhangsan@gmail.com | 13920199836 |\n"
            + "|   Lisi    |  male  | 28  |    lisi@qq.com     | 13635781534 |\n"
            + "|  WangWu   |  male  | 48  |   wangwu@163.com   | 15809876236 |\n"
            + "+-----------+--------+-----+--------------------+-------------+\n";

    /**
     * 测试正常渲染的情况.
     */
    @Test
    public void render() {
        // 构造一行List集合类型的普通数据，用于测试List集合数据的添加.
        List<Object> rowDatas = new ArrayList<>();
        rowDatas.add("WangWu");
        rowDatas.add("male");
        rowDatas.add(48);
        rowDatas.add("wangwu@163.com");
        rowDatas.add("15809876236");

        String table = new MiniTable("The Title")
                .addHeaders("Name", "Sex", "Age", "Email", "Phone")
                .addData("LiLei", "male", 25, "lilei@gmail.com", "13809345219")
                .addData("hanMeiMei", "female", 23, "hmm@163.com", "13515343853")
                .addHeaders("Name", "Sex", "Age", "Email", "Phone")
                .addData("ZhangSan", "female", 32, "zhangsan@gmail.com", "13920199836")
                .addData("Lisi", "male", 28, "lisi@qq.com", "13635781534")
                .addData(rowDatas)
                .render();
        PrintUtil.println(table);
        Assertions.assertEquals(TABLE, table);
    }

    /**
     * 测试参数不对时的情况.
     */
    @Test
    public void renderWithException() {
        new MiniTable().addHeaders("col11", "col12")
                .addData("col21")
                .render();
    }

    /**
     * 测试参数不对时的情况.
     */
    @Test
    public void renderWithLongTitle() {
        List<Object> headers = new ArrayList<>();
        headers.add(12345);
        headers.add("abcde");

        String table = new MiniTable("This is a too long title.")
                .addHeaders(headers)
                .render();
        Assertions.assertEquals(""
                + "+---------------+\n"
                + "| This is a too |\n"
                + "+-------+-------+\n"
                + "| 12345 | abcde |\n"
                + "+-------+-------+\n", table);
    }
}
