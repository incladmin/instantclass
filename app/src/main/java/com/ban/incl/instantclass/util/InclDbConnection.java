package com.ban.incl.instantclass.util;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/**
 * InclDbConnection - Instant Class DB 접속
 * 사용법 : String return = new InclDbConnection().excute(new HashMap()).get();
 *
 */
public class InclDbConnection extends AsyncTask<Object, Integer, String>{

    private final String INCL_DB_URL = "http://incladmin.cafe24.com/";

    private String sFileName = "";

    public InclDbConnection(String mode) {
        //TODO : InclDbConnection init
        if("SELECT".equals(mode.toUpperCase())) {
            sFileName = "getData.php";
        } else if("DETAIL".equals(mode.toUpperCase())) {
            sFileName = "getDataDetail.php";
        }
    }

    @Override
    protected String doInBackground(Object... obj) {
        //TODO : InclDbConnection doInBackground
        String sReturn = null;

        Map<String, String> paramMap = (Map)obj[0];
        paramMap.put("class_id", "1");

        sReturn = getHttp(paramMap);

        Log.d("InclDbConnection IN", sReturn);

        return sReturn;
    }

    private String getHttp(Map<String, String> paramMap) {
        try{
            URL url = new URL(INCL_DB_URL + sFileName);

            String sParam = "";
            for( String key : paramMap.keySet() ) {
                if(sParam.isEmpty()) {
                    sParam =        URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(paramMap.get(key), "UTF-8");
                } else {
                    sParam += "&" + URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(paramMap.get(key), "UTF-8");
                }
            }

            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            if(!sParam.isEmpty()) {
                wr.write(sParam);
            }
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                sb.append(line);
                break;
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