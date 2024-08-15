package com.yuryi.aura.test.presentation.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.yuryi.aura.test.presentation.receiver.NotificationDismissedReceiver

class NotificationSender(private val context: Context) {

    fun sendNotification(title: String, content: String, @DrawableRes icon: Int, id: Int) {
        val intent = Intent(context, NotificationDismissedReceiver::class.java)
        val deleteIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context)
            .setSmallIcon(icon)
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setDeleteIntent(deleteIntent)
            .setAutoCancel(true)

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(id, builder.build())
    }
}