package com.example.tjun.clean.network.encrypt;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/2 0002 16:09.
 *  E-mail:          prohankj@outlook.com
 *  Desc:           加密工具类
 * </pre>            
 ****/
public class EncryptionAnnoUtil {
    public static Map getEncry(Object object) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.clear();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            String valus = null;
            String type = field.getGenericType().toString();
            if (type.equals("class java.lang.String")) {
                try {
                    valus = (String) field.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (valus != null) {
                    /**
                     * 加密
                     */
                    if (field.isAnnotationPresent(EncyptAnno.class)) {
                        //valus = RSACoder.encryptByPubkey(Configure.pubkey, valus);
                        //valus = valus + "加密";
                        // FIXME: 2017/8/3 0003 valus = "加密valus"
                    }
                    stringMap.put(name, valus);
                }
            }
        }
        return stringMap;
    }

}
