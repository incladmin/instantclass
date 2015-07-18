package com.ban.incl.instantclass.util;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

/**
 * InclDbConnection - Instant Class DB 접속
 * 사용법 : String return = new InclDbConnection(mode).excute(new HashMap()).get();
 *
 */
public class InclDbConnection extends AsyncTask<Object, Integer, String>{

    private final String INCL_DB_URL = "http://incladmin.cafe24.com/";

    private String sFileName = "";

    public InclDbConnection(String mode) {
        //TODO : InclDbConnection init
        switch (mode.toUpperCase()) {
            case "SELECT" :
                sFileName = "getData.php";
                break;
            case "DETAIL" :
                sFileName = "getData.php";
                break;
            case "INSERT" :
                sFileName = "insertClass.php";
                break;
        }
    }

    @Override
    protected String doInBackground(Object... obj) {
        //TODO : InclDbConnection doInBackground
        String sReturn = null;

        Map<String, String> paramMap = (Map)obj[0];

        sReturn = getHttp(paramMap);

        Log.d("INCL_DEBUG", "return value = " + sReturn);

        return sReturn;
    }

    private String getHttp(Map<String, String> paramMap) {
        try{
            URL url = new URL(INCL_DB_URL + sFileName);

            String sParam = "";
            for( String key : paramMap.keySet() ) {
                if(sParam.isEmpty()) {
                    sParam =         URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(paramMap.get(key), "UTF-8");
                } else {
                    sParam += "&" + URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(paramMap.get(key), "UTF-8");
                }
            }

            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");

            if(!sParam.isEmpty()) {
                wr.write(sParam);
            }
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            for(;;){

                line = reader.readLine();
                if(line == null) break;

                sb.append(line + "\n");
            }
            return sb.toString();
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    // nothing to do
    protected void onPostExecute(String str){

    }


}