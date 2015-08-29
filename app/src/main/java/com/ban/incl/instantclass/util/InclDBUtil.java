package com.ban.incl.instantclass.util;

import android.util.Log;

import com.ban.incl.instantclass.vo.ClassVO;
import com.ban.incl.instantclass.vo.UserVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InclDBUtil {

    public static List<ClassVO> selectAllList() {
        List<ClassVO> list = new ArrayList<>();
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

    public static void insertClass(Map map) {
        try {
            String s = new InclDbConnection("INSERT").execute(map).get();
        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectListAll Exception");
            e.printStackTrace();
        }
    }

    public static UserVO selectUserInfo(Map map){

        UserVO userVO = new UserVO();

        try{
            String s = new InclDbConnection("SELECTUSERINFO").execute(map).get();
            Log.d("### ohGamja ###",s);

            if(s!=null){
                JSONArray array = new JSONArray(s);

                for(int i=0; i<array.length();i++){
                    JSONObject jsonObj = array.getJSONObject(i);
                    userVO.setUSER_ID(jsonObj.getString("USER_ID"));
                    userVO.setPASSWORD(jsonObj.getString("PASSWORD"));
                }
            }

        }catch(Exception e){
            Log.d("### ohGamja ###","exception");
            e.printStackTrace();
        }

        return userVO;
    }
}
