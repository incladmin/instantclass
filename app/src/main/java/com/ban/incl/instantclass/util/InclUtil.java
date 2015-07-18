package com.ban.incl.instantclass.util;

import android.util.Log;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InclUtil {

    public static Map<String, String> ConvertObjtoMap(Object obj) {
        Map<String, String> map = new HashMap();
        // Object의 변수
        Field[] fields = obj.getClass().getDeclaredFields();

        for(int i = 0 ; i < fields.length ; i++ ) {
            // private 변수에 접근 허용
            fields[i].setAccessible(true);
            try {
                Log.d("INCL_DEBUG", fields[i].getName() + " : " + fields[i].get(obj).toString());
                // 변수 명을 key로 value 저장.
                map.put(fields[i].getName(), fields[i].get(obj).toString());
            } catch (IllegalArgumentException e) {
                Log.d("INCL_DEBUG", "ConvertObjtoMap IllegalArgumentException");
            } catch (IllegalAccessException e) {
                Log.d("INCL_DEBUG", "ConvertObjtoMap IllegalAccessException");
            } catch (Exception e) {
                Log.d("INCL_DEBUG", "ConvertObjtoMap Exception");
            }
        }

        return map;
    }


}
