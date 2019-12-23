package com.lqing.orm.internal.entity.adapter;


import com.lqing.orm.internal.entity.IEntity;

/**
 * <p>
 *     实体类适配器,用于将某些数据转换为实体类<br>
 *     或是将自身转换为其他数据.
 * </p>
 *
 */
public interface IEntityAdapter {
    /**
     * <p>
     *     将 {@link IEntity} 转换为{@link Object}.
     * </p>
     *
     * @param entity 实例接口 {@link IEntity}
     * @return 返回转换后的对象 {@link Object},可以将自身转换为许多对象
     * <br>比如：
     * <ul>
     *     <li>{@link java.sql.ResultSet}</li>
     *     <li>...</li>
     * </ul>
     * @throws Exception
     * <p>
     *     实例之间的转换是通过反射调用set/get方法进行赋值的，当
     *     当 {@link Object} 中的属性名与 {@link Object} 的set/get
     *     方法对不上，如果是 {@link java.sql.ResultSet} 则有可能发生.
     *     <ul>
     *         <li>{@link NoSuchMethodException}</li>
     *         <li>{@link java.sql.SQLException}</li>
     *         <li>...</li>
     *     </ul>
     * </p>
     */
    public Object transform(IEntity entity)
            throws Exception;

    /**
     * <p>
     *     将 {@link Object} 转换为自身数据 {@link Object}
     * </p>
     *
     * @param o 需要转换的对象,这些对象可以是各种各样的数据结构
     * <br>比如：
     * <ul>
     *     <li>{@link java.sql.ResultSet}</li>
     *     <li>...</li>
     * </ul>
     * @param instance 转换后的实例对象 {@link Object}
     * @return 返回 {@link Object} 实例
     * @throws Exception
     * <p>
     *     实例之间的转换是通过反射调用set/get方法进行赋值的，当
     *     当 {@link Object} 中的属性名与 {@link Object} 的set/get
     *     方法对不上，如果是 {@link java.sql.ResultSet} 则有可能发生.
     *     <ul>
     *         <li>{@link NoSuchMethodException}</li>
     *         <li>{@link java.sql.SQLException}</li>
     *         <li>...</li>
     *     </ul>
     * </p>
     */
    public Object reduction(Object o, Object instance)
        throws Exception;


}
