package com.ban.incl.instantclass.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.fragment.addclass.AddClassFragment;
import com.ban.incl.instantclass.fragment.addclass.AgreementFragment;

public class AddClassActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        Log.d("addClassActvity", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.add_class_container, AgreementFragment.newInstance())
                .commit();



//        findViewById(R.id.btn_add_class).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent addClassIntent = new Intent(getApplicationContext(), AddClassActivity.class);
//                // clear activity stack
//                Log.d("addClassActvity", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
//                addClassIntent.addFlags(addClassIntent.FLAG_ACTIVITY_CLEAR_TASK);
//                addClassIntent.addFlags(addClassIntent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(addClassIntent);
//                // ùȭ�� ���� ��������
//    //        FragmentManager fragmentManager = getSupportFragmentManager();
//    //        fragmentManager.beginTransaction()
//    //                .replace(R.id.container, MainFragment.newInstance())
//    //                .commit();
//            }
//        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
