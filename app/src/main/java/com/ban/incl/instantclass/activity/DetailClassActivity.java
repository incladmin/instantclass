package com.ban.incl.instantclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ban.incl.instantclass.R;

public class DetailClassActivity extends ActionBarActivity implements View.OnClickListener{

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_class);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_detail);

        findViewById(R.id.tb_detail_back).setOnClickListener(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_detail :
                Toast.makeText(DetailClassActivity.this, "back ", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.btn_search) {
            Toast.makeText(DetailClassActivity.this, "search button click", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

}
