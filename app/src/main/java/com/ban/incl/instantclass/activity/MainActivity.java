package com.ban.incl.instantclass.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.fragment.AddClassFragment;
import com.ban.incl.instantclass.fragment.InclRecyclerFragment;
import com.ban.incl.instantclass.fragment.MainFragment;
import com.ban.incl.instantclass.fragment.NavigationDrawerCallbacks;
import com.ban.incl.instantclass.fragment.NavigationDrawerFragment;
import com.ban.incl.instantclass.util.InclDbConnection;

import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    private Toolbar mToolbar;
    private DrawerLayout dlDrawer;
//    private ActionBarDrawerToggle dtToggle;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 첫화면 메인 페이지로
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit();

//        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//
//        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, 0, 0);
//        dlDrawer.setDrawerListener(dtToggle);
//
//        findViewById(R.id.iv_interest).setOnClickListener(mClickListener);
//        findViewById(R.id.iv_mylist).setOnClickListener(mClickListener);
//        findViewById(R.id.iv_notice).setOnClickListener(mClickListener);
//        findViewById(R.id.iv_qna).setOnClickListener(mClickListener);
//        findViewById(R.id.iv_setting).setOnClickListener(mClickListener);
//        findViewById(R.id.btn_add_class).setOnClickListener(mClickListener);
//        findViewById(R.id.iv_login).setOnClickListener(mClickListener);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);

        //TODO: session
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            String sLoginName = bundle.getString("LOGIN_NAME");
            TextView txtLogin = (TextView) findViewById(R.id.lbl_login);
            txtLogin.setText(sLoginName);
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            switch (v.getId()) {
                case R.id.iv_mylist:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, MainFragment.newInstance())
                            .commit();
                    break;
                case R.id.iv_interest:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, MainFragment.newInstance())
                            .commit();
                    break;
                case R.id.iv_setting:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, InclRecyclerFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.iv_notice:
                    //TODO : 삭제
                    try {
                        String s = new InclDbConnection("SELECT").execute(new HashMap()).get();
                    } catch (Exception e) {
                        Log.d("INCL_DEBUG", "MAIN > iv_notice Exception");
                    }
                    break;
                case R.id.iv_qna:
                    // TODO : 삭제
                    try {
                        String s = new InclDbConnection("DETAIL").execute(new HashMap()).get();
                    } catch (Exception e) {
                        Log.d("INCL_DEBUG", "MAIN > iv_qna Exception");
                    }
                    break;
                case R.id.btn_add_class:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, AddClassFragment.newInstance())
                            .addToBackStack(null)
                            .commit();

                    break;
                case R.id.iv_login:
                    Intent intent = new Intent(getApplicationContext() , LoginActivity.class);
                    startActivity(intent);
                    break;
            }
            dlDrawer.closeDrawers();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        // Sync the toggle state after onRestoreInstanceState has occurred.
//        dtToggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        dtToggle.onConfigurationChanged(newConfig);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        Toast.makeText(MainActivity.this, "click > " + item.getItemId(), Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.btn_search) {
            Toast.makeText(MainActivity.this, "search button click", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    //TODO: back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
                */
    }
}
