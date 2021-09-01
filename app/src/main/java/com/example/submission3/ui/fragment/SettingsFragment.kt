package com.example.submission3.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import androidx.preference.SwitchPreferenceCompat
import com.example.submission3.R
import com.example.submission3.utils.AlarmUser

class SettingsFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var reminderPreference: SwitchPreferenceCompat
    private lateinit var reminderUser: AlarmUser
    private lateinit var reminder: String

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        reminderUser = AlarmUser()

        initReminder()
        initSharedPreference()
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == reminder) {
            if (sharedPreferences != null) {
                reminderPreference.isChecked = sharedPreferences.getBoolean(reminder, false)
            }
        }

        val state: Boolean =
            PreferenceManager.getDefaultSharedPreferences(context).getBoolean(reminder, false)

        setReminder(state)
    }

    private fun initReminder() {
        reminder = getString(R.string.reminder_key)
        reminderPreference =
            findPreference<SwitchPreferenceCompat>(reminder) as SwitchPreferenceCompat
    }

    private fun initSharedPreference() {
        val sharedPreferences = preferenceManager.sharedPreferences
        reminderPreference.isChecked = sharedPreferences.getBoolean(reminder, false)
    }

    private fun setReminder(state: Boolean) {
        if (state) {
            context?.let {
                reminderUser.setRepeatingReminder(it)
            }
        } else {
            context?.let {
                reminderUser.cancelAlarm(it)
            }
        }
    }
}