package com.ban.incl.instantclass.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;

import com.ban.incl.instantclass.R;

import java.util.List;


/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener {
    /**
     * Determines whether to always show the simplified settings UI, where
     * settings are presented in a single list. When false, settings are shown
     * as a master/detail two-pane view on tablets. When true, a single pane is
     * shown on tablets.
     */
    private static final boolean ALWAYS_SIMPLE_PREFS = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_settings);
        //setContentView(R.xml.settings_layout);
        //getActionBar().setTitle("설정");

        Preference pAppdName = (Preference)findPreference("pwdChg");
        Preference pAppPolicy = (Preference)findPreference("keyPolService");
        Preference pAppPolicyGps = (Preference)findPreference("keyPolGps");
        Preference pAppDropUser = (Preference)findPreference("keyOut");

        pAppdName.setOnPreferenceClickListener(this);
        pAppPolicy.setOnPreferenceClickListener(this);
        pAppPolicyGps.setOnPreferenceClickListener(this);
        pAppDropUser.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference)
    {
        // 도움말 선택시
        if(preference.getKey().equals("pwdChg"))
        {
            Intent intent = new Intent(this, PwdChgActivity.class);
            startActivity(intent);
        }
        else if(preference.getKey().equals("keyPolService"))
        {
            Intent addClassIntent = new Intent(this, AddClassActivity.class);
            startActivity(addClassIntent);
        }
        else if(preference.getKey().equals("keyPolGps"))
        {
            Intent addClassIntent = new Intent(this, AddClassActivity.class);
            startActivity(addClassIntent);

        } else if(preference.getKey().equals("keyOut")){
            Intent intent = new Intent(this, DropUserActivity.class);
            startActivity(intent);
        }

        return false;
    }
}
