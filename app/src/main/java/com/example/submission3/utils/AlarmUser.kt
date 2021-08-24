package com.example.submission3.utils

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.submission3.R
import com.example.submission3.ui.activity.HomeActivity
import java.util.*

class AlarmUser : BroadcastReceiver() {

    companion object {
        private const val ID_REPEATING = 101
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        showNotification(context)
    }

    private fun showNotification(context: Context?) {
        val channelId = "reminder_channel"
        val channelName = "reminder_github"

        val title = context?.resources?.getString(R.string.title_reminder)
        val message = context?.resources?.getString(R.string.message_reminder)

        val intent = Intent(context, HomeActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(context)
            .addParentStack(HomeActivity::class.java)
            .addNextIntent(intent)
            .getPendingIntent(ID_REPEATING, PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationManagerCompat =
            context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val mBuilder = NotificationCompat.Builder(context, channelId)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_favorite)
            .setContentTitle(title)
            .setContentText(message)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setColor(ContextCompat.getColor(context, android.R.color.transparent))
            .setSound(alarmSound)
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            channel.apply {
                enableVibration(true)
                vibrationPattern = longArrayOf(1000, 1000, 1000, 1000, 1000)
            }
            mBuilder.setChannelId(channelId)
            notificationManagerCompat.createNotificationChannel(channel)
        }
        val notification = mBuilder.build()
        notificationManagerCompat.notify(ID_REPEATING, notification)
    }

    fun setRepeatingReminder(context: Context?) {
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent: PendingIntent = Intent(context, AlarmUser::class.java).let {
            PendingIntent.getBroadcast(context, ID_REPEATING, it, 0)
        }

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 9)
        }

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, intent)
        Toast.makeText(context, context.getString(R.string.reminder_on), Toast.LENGTH_SHORT).show()
    }

    fun cancelAlarm(context: Context?) {
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmUser::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, ID_REPEATING, intent, 0)
        pendingIntent.cancel()

        alarmManager.cancel(pendingIntent)

        Toast.makeText(context, context.getString(R.string.reminder_off), Toast.LENGTH_SHORT).show()
    }
}