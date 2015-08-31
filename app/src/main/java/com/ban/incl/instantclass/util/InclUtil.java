package com.ban.incl.instantclass.util;

import android.util.Log;

import com.ban.incl.instantclass.vo.ClassVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static List<ClassVO> ConvertStrToList(String str) {
        List<ClassVO> list = new ArrayList<>();
        try{
            JSONObject root = new JSONObject(str);
            JSONArray ja = root.getJSONArray("results");

            for(int i=0; i<ja.length(); i++){
                JSONObject jo = ja.getJSONObject(i);

                ClassVO vo = new ClassVO();
                vo.setClass_id(jo.getString("class_id"));
                vo.setTitle(jo.getString("title"));
                vo.setAddr(jo.getString("addr"));
                vo.setPlace(jo.getString("place"));
                vo.setPrice(jo.getString("price"));
                vo.setContent(jo.getString("content"));
                vo.setLesson_date(jo.getString("lesson_date"));
                vo.setStart_time(jo.getString("start_time"));
                vo.setEnd_time(jo.getString("end_time"));
                vo.setMin_person(jo.getString("min_person"));
                vo.setMax_person(jo.getString("max_person"));
                vo.setItems(jo.getString("items"));
                vo.setBank(jo.getString("bank"));
                vo.setAccount(jo.getString("account"));

                list.add(vo);
            }
        }catch(Exception e){
            Log.d("INCL_DEBUG", "ConvertStrToList Exception");
            e.printStackTrace();
        }

        return list;
    }
}
