package com.ban.incl.instantclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.fragment.addclass.AddClassFragment;
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
            TextView txtLogin = (TextView) findViewById(R.id.txt_login);
            txtLogin.setText(sLoginName);
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
