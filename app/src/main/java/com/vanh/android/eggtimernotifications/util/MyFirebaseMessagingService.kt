package com.vanh.android.eggtimernotifications.util

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService(){
    // will be called when in foreground and also have data come with
    // the notification
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG,"From ${remoteMessage.from }")
        
        remoteMessage.data.let { Log.d(TAG,"Message and data payload:" + remoteMessage.data) }
    }
    
    /**
     * Called if InstanceID token is updated or regenerate. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token)
    
        // my token
        //fGzsyFypTbG0dg73dWM2x0:APA91bEi4mJwa6rjWrZIKJK3oK1uw26_bEKG1IFmuTn2sZxofKdd81vzlpLYKcyaRfDM-zE2yCsiBpriVNV6yEBTNMfUrEOrVC0SNz10Fz2XUy5csFIq1mCnZeUgkbH5DikGghCSnBPi
    }
    
    private fun sendRegistrationToServer(token: String) {
        Log.d(TAG, "send message $token to server")
    }
}