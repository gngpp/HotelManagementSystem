package com.lqing.orm.utils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

public class ReflectUtil {

    public static Method[] getClassMethods(Class clazz){
        return clazz.getMethods();
    }

    public static Method getClassMethod(Class clazz,String name){
        try {
            return clazz.getMethod(name);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method getClassMethod(Method[] methods ,String name){
        for(Method method : methods){
            if(method.getName().equals(name)){
                return method;
            }
        }
        return null;
    }

    public static Method findGetMethod(Method[] methods ,String methodSuffix){
        return getClassMethod(methods,
                ConstantStringPool.GET_METHOD_KEY_PREFIX + methodSuffix);
    }

    public static Method findSetMethod(Method[] methods ,String methodSuffix){
        return getClassMethod(methods,
                ConstantStringPool.SET_METHOD_KEY_PREFIX + methodSuffix);
    }

    public static Object invokeGetMethod(Method[] methods, String methodSuffix,
                                         Object entity,Object ...args)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = findGetMethod(methods,methodSuffix );
        if(method != null){
            return method.invoke(entity,args);
        }
        throw new NoSuchMethodException("do not find method " +
                "["+ConstantStringPool.GET_METHOD_KEY_PREFIX  + methodSuffix+"]");
    }

    public static Object invokeSetMethod(Method[] methods, String methodSuffix,
                                         Object entity,Object ...args)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = findSetMethod(methods,methodSuffix );
        if(method != null){
            return method.invoke(entity,args);
        }
        throw new NoSuchMethodException("do not find method " +
                "["+ConstantStringPool.SET_METHOD_KEY_PREFIX  + methodSuffix+"]");
    }

    public static Object parseObject(String objectType,Object o) {
        if("String".equals(objectType)){
            return o;
        }
        if("Boolean".equals(objectType)){
            return Boolean.parseBoolean(o.toString());
        }
        if("Integer".equals(objectType) || "int".equals(objectType)){
            return Integer.parseInt(o.toString());
        }
        if("Date".equals(objectType)){
            return Date.parse(o.toString());
        }
        return null;
    }

    public static Class<?> genericParamClass(Class<?> clazz){
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            return (Class<?>) p[0];
        }
        return null;
    }
}
