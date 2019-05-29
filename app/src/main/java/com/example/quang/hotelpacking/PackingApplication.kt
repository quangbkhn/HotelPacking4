package com.example.quang.hotelpacking

import android.app.Application
import android.util.Log
import android.widget.Toast
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*

const val SERVER = "tcp://postman.cloudmqtt.com"
const val PORT = 17482
const val USERNAME ="mliyedfs"
const val PASSWORD = "ivDJb1oRl8G2"
class PackingApplication:Application() {
    lateinit var client:MqttAndroidClient
    lateinit var options:MqttConnectOptions
    override fun onCreate() {
        super.onCreate()
        val clientid = MqttClient.generateClientId()
        options = MqttConnectOptions().also {
            it.userName = USERNAME
            it.password = PASSWORD.toCharArray()
            it.isAutomaticReconnect = true
        }
        client = MqttAndroidClient(this.applicationContext,"$SERVER:$PORT",clientid)
    }

    }
