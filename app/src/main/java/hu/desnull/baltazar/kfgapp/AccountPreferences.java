package hu.desnull.baltazar.kfgapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class AccountPreferences extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    SharedPreferences sharedPrefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.account_preferences);

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        onSharedPreferenceChanged(sharedPrefs, getString(R.string.access_token_valid_date));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference pref = findPreference(key);
        pref.setSummary("idk but prolly true");
    }
}
