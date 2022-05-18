package com.example.assigment3

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationHelper(var co: Context,var msg:String) {
    private val id="id"
    private val notifid=123
    fun Notification()
    {
        createNotification()
        val sent=Intent(co,MainActivity::class.java).apply { 
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pend=PendingIntent.getActivities(co,0,arrayOf(sent),0)
        val icon=BitmapFactory.decodeResource(co.resources,R.drawable.app_icon_your_company)
        val isnotif=NotificationCompat.Builder(co,id)
            .setSmallIcon(R.drawable.app_icon_your_company)
            .setLargeIcon(icon)
            .setContentTitle("User Name")
            .setContentText(msg)
            .setContentIntent(pend)
            .setPriority((NotificationCompat.PRIORITY_DEFAULT))
            .build()
            NotificationManagerCompat.from(co)
                .notify(notifid,isnotif)
    }
    
    private fun createNotification()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            val name=id
            val descrip=" Channel descrip"
            val imports =NotificationManager.IMPORTANCE_DEFAULT
            val cann=NotificationChannel(id,name,imports).apply { 
                description=descrip
            }
            val notificationManager=co.getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
            notificationManager.createNotificationChannel(cann)
            
        }
    }
    
}