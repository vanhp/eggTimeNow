/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vanh.android.eggtimernotifications.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.vanh.android.eggtimernotifications.MainActivity
import com.vanh.android.eggtimernotifications.R

// Notification ID.
private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0

// TODO: Step 1.1 extension function to send messages (GIVEN)
/**
 * Builds and delivers the notification.
 *
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    // Create the content intent for the notification, which launches
    // this activity
    val intent = Intent(applicationContext, MainActivity::class.java)
    //  PendingIntent can be by system restart the up, and can be reused
    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext, NOTIFICATION_ID,intent,PendingIntent.FLAG_UPDATE_CURRENT)
    // TODO: Step 2.0 add style

    // TODO: Step 2.2 add snooze action

    // TODO: Step 1.2 get an instance of NotificationCompat.Builder
    // Build the notification
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    )
        .setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true) //self dismiss when tap

    notify(NOTIFICATION_ID,builder.build())


    // TODO: Step 1.8 use the new 'breakfast' notification channel

    // TODO: Step 1.3 set title, text and icon to builder

    // TODO: Step 1.13 set content intent

        // TODO: Step 2.1 add style to builder

        // TODO: Step 2.3 add snooze action

        // TODO: Step 2.5 set priority

    // TODO: Step 1.4 call notify

}

//  Cancel all notifications
fun NotificationManager.cancelNotifications() = cancelAll()


