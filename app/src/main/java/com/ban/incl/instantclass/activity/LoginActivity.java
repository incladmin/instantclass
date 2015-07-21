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

                UserVO userVo = new UserVO();

                EditText userId = (EditText)findViewById(R.id.userId);
                EditText password = (EditText)findViewById(R.id.password);

                if(userId==null || password==null){
                    Log.d("","null check");
                }

                userVo.setUSER_ID(userId.getText().toString());
                userVo.setPASSWORD(password.getText().toString());

                Log.d("t=====================", userVo.getUSER_ID());
                Log.d("t=====================",userVo.getPASSWORD());

                Map map = InclUtil.ConvertObjtoMap(userVo);

                InclDBUtil.selectUserInfo(map);




                //TODO: session
                intent.putExtra("LOGIN_NAME", "ban");

                startActivity(intent);
            }
        });
    }

}
