package com.ban.incl.instantclass.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.util.InclDBUtil;
import com.ban.incl.instantclass.util.InclUtil;
import com.ban.incl.instantclass.vo.UserVO;

import java.util.Map;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , MainActivity.class);

                // clear activity stack
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                UserVO userVO = new UserVO();

                EditText userId = (EditText)findViewById(R.id.userId);
                EditText password = (EditText)findViewById(R.id.password);

                if(userId.getText().toString().equals("")){
                    Log.d("### ohGamja ###","null check");
//                    findViewById(R.id.btn_login).setEnabled(false);
                }else if(password.getText().toString().equals("")){
                    Log.d("### ohGamja ###","null check2");
//                    findViewById(R.id.btn_login).setEnabled(false);
                }else{
                    Log.d("### ohGamja ###","null check3");
//                    findViewById(R.id.btn_login).setEnabled(true);
                }

                userVO.setUSER_ID(userId.getText().toString());
                userVO.setPASSWORD(password.getText().toString());
                Map map = InclUtil.ConvertObjtoMap(userVO);
                userVO = InclDBUtil.selectUserInfo(map);

                if(userVO.getUSER_ID()!=null) {
                    intent.putExtra("LOGIN_NAME", userVO.getUSER_ID());
                }else{
                    Log.d("### ohGamja ###","return value check");
                    intent.putExtra("LOGIN_NAME", "ban");
                }

                startActivity(intent);
            }
        });
    }

}
