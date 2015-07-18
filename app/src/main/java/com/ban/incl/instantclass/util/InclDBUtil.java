package com.ban.incl.instantclass.util;

import android.util.Log;

import com.ban.incl.instantclass.vo.ClassVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InclDBUtil {

    public static List<ClassVO> selectAllList() {
        List<ClassVO> list = new ArrayList<ClassVO>();
        try {
            String s = new InclDbConnection("SELECT").execute(new HashMap()).get();
            list = ConvertStrToList(s);
        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectListAll Exception");
            e.printStackTrace();
        }

        return list;
    }

    public static List<ClassVO> ConvertStrToList(String str) {
        List<ClassVO> list = new ArrayList<ClassVO>();
        try{
            JSONObject root = new JSONObject(str);
            JSONArray ja = root.getJSONArray("results");

            for(int i=0; i<ja.length(); i++){
                JSONObject jo = ja.getJSONObject(i);

                ClassVO vo = new ClassVO();
                vo.setClassId(jo.getString("class_id"));
                vo.setTitle(jo.getString("title"));
                vo.setContent(jo.getString("content"));
                vo.setStartTime(jo.getString("start_time"));
                vo.setEndTime(jo.getString("end_time"));
                vo.setAddr(jo.getString("addr"));
                vo.setPrice(jo.getString("price"));

                list.add(vo);
            }
        }catch(Exception e){
            Log.d("INCL_DEBUG", "ConvertStrToList Exception");
            e.printStackTrace();
        }

        return list;
    }

    public static void insertClass(Map map) {
        try {
            new InclDbConnection("INSERT").execute(map).get();
        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectListAll Exception");
            e.printStackTrace();
        }
    }
}
