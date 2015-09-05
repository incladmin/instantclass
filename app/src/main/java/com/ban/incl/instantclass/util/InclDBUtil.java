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

    private static final String SELECT = "getData.php";
    private static final String DETAIL = "getDataDetail.php";
    private static final String INSERT = "insertClass.php";
    private static final String SELECTUSERINFO = "getUserData.php";
    private static final String REGIST = "saveRegist.php";
    private static final String INTEREST = "saveInterest.php";

    private static final String REGIST_LIST = "getRegistList.php";
    private static final String INTEREST_LIST = "getInterestList.php";
    private static final String ORDER_DISTANCE = "getData.php";
    private static final String ORDER_DATE = "getData.php";
    private static final String ORDER_INTEREST = "getData.php";

    public static List<ClassVO> selectAllList() {
        List<ClassVO> list = new ArrayList<>();
        try {
            String s = new InclDbConnection(SELECT).execute(new HashMap()).get();
            list = InclUtil.ConvertStrToList(s);
        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectListAll Exception");
            e.printStackTrace();
        }

        return list;
    }

    public static List<ClassVO> selectList(ListType type) {
        List<ClassVO> list = new ArrayList<>();
        try {
            String s = "";
            Map paramMap = new HashMap();
            //TODO : session
            paramMap.put("user_id", "incladmin");
            switch (type) {
                case REGIST_LIST:
                    s = new InclDbConnection(REGIST_LIST).execute(paramMap).get();
                    list = InclUtil.ConvertStrToList(s);
                    break;
                case INTEREST_LIST:
                    s = new InclDbConnection(INTEREST_LIST).execute(paramMap).get();
                    list = InclUtil.ConvertStrToList(s);
                    break;
                case ORDER_DISTANCE:
                    s = new InclDbConnection(ORDER_DISTANCE).execute(paramMap).get();
                    list = InclUtil.ConvertStrToList(s);
                    break;
                case ORDER_DATE:
                    s = new InclDbConnection(ORDER_DATE).execute(paramMap).get();
                    list = InclUtil.ConvertStrToList(s);
                    break;
                case ORDER_INTEREST:
                    s = new InclDbConnection(ORDER_INTEREST).execute(paramMap).get();
                    list = InclUtil.ConvertStrToList(s);
                    break;
            }
        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectList type = " + type);
            Log.d("INCL_DEBUG", "selectList Exception");
            e.printStackTrace();
        }
        return list;
    }

    public static void insertClass(Map map) {
        try {
            String s = new InclDbConnection(INSERT).execute(map).get();
        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectListAll Exception");
            e.printStackTrace();
        }
    }

    public static UserVO selectUserInfo(Map map){

        UserVO userVO = new UserVO();

        try{
            String s = new InclDbConnection(SELECTUSERINFO).execute(map).get();
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

    public static ClassVO selectClassDetail(Map map) {
        List list = new ArrayList();
        ClassVO vo = new ClassVO();

        try {
            String s = new InclDbConnection(DETAIL).execute(map).get();
            list = InclUtil.ConvertStrToList(s);

        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectClassDetail Exception");
            e.printStackTrace();
        }

        if(!list.isEmpty()) {
            vo = (ClassVO)list.get(0);
        }

        return vo;
    }

    public static String saveInclRegist(Map map) {
        String s = "";
        try {
            s = new InclDbConnection(REGIST).execute(map).get();

        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectClassDetail Exception");
            e.printStackTrace();
        }

        return s;
    }

    public static String saveInclInterest(Map map) {
        String s = "";
        try {
            s = new InclDbConnection(INTEREST).execute(map).get();

        } catch (Exception e) {
            Log.d("INCL_DEBUG", "selectClassDetail Exception");
            e.printStackTrace();
        }

        return s;
    }
}
