package com.hjb.jpa.tools;

import java.util.List;

/**
 * bean 帮助类
 */
public class BeanHelperUtils {

    /**
     * 判断对象为空
     * @param obj list对象
     * @return boolean
     */
    public static boolean isNullOrEmpty(List<?> obj) {
        return obj == null || obj.size() <= 0;
    }

    /**
     * 判断对象为空
     * @param obj 对象
     * @return 结果
     */
    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || "".equals(obj);
    }

    /**
     * 判断前面<后面
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean isSmall(Object obj1, Object obj2) {
        if (obj1 instanceof Integer && obj2 instanceof Integer) {
            Integer v1 = (Integer) obj1;
            Integer v2 = (Integer) obj2;
            return v1 <= v2;
        }
        if (obj1 instanceof String && obj2 instanceof String) {
            String v1 = (String) obj1;
            String v2 = (String) obj2;
            return v1.compareTo(v2) <= 0;
        }
        return false;
    }
}
