package com.example.submission3.ui.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.submission3.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}