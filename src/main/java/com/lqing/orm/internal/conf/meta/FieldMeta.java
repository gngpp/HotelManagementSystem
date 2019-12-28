package com.lqing.orm.internal.conf.meta;

import java.lang.reflect.Method;

/**
 * <p>
 *     实体类成员信息:<br>
 *     <ul>
 *         <li>{@link #FIELD_NAME} 成员名</li>
 *         <li>{@link #TYPE_NAME} 成员类型名 (JAVA 数据类型 驼峰命名)</li>
 *         <li>{@link #SET_METHOD} 成员的 getter 方法</li>
 *         <li>{@link #GET_METHOD} 成员的 setter 方法</li>
 *     </ul>
 * </p>
 */
public final class FieldMeta {
    public String FIELD_NAME;
    public String TYPE_NAME;
    public Method SET_METHOD;
    public Method GET_METHOD;

    @Override
    public String toString() {
        return "FieldEntity{" +
                "FIELD_NAME='" + FIELD_NAME + '\'' +
                ", TYPE_NAME='" + TYPE_NAME + '\'' +
                ", SET_METHOD=" + SET_METHOD +
                ", GET_METHOD=" + GET_METHOD +
                '}';
    }
}
