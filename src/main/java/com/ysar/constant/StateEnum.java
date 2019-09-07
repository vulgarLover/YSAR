package com.ysar.constant;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @Description
 * @Author shenwei
 * @Date 2019-09-05 16:49
 */
public enum StateEnum implements IEnum {
    /**
     * 启用状态
     */
    ENABLE(1),


    /**
     * 禁用状态
     */
    DISABLE(0);


    private Integer value;
    public static final String INFO = "可选值:ENABLE_1:启用，DISABLE_2:禁用";

    StateEnum(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement e : stackTrace) {
            if (e.getClassName().startsWith("springfox")) {
                return "可选值:NONE_0:未处理，YES_1:已处理";
            }
        }
        return super.toString();
    }
}
