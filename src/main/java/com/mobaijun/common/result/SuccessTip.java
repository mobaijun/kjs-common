package com.mobaijun.common.result;

import com.mobaijun.common.result.enums.HttpStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: SuccessTip
 * 类描述： 成功提示
 *
 * @author MoBaiJun 2022/4/22 17:25
 */
@Getter
@Setter
public class SuccessTip<T> extends AbstractTip<T> implements Serializable {

    /**
     * 返回数据
     */
    private T data;

    /**
     * 返回信息
     *
     * @param data 返回对象
     */
    public SuccessTip(T data) {
        this.data = data;
        super.code = HttpStatus.OK.getCode();
        super.message = HttpStatus.OK.getMessage();
    }
}
