package com.pankel.proyectointeligenciaambiental

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.pankel.proyectointeligenciaambiental.navigation.NavManager
import com.pankel.proyectointeligenciaambiental.ui.theme.ProyectoInteligenciaAmbientalTheme
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel
import org.eclipse.paho.client.mqttv3.*
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

class MainActivity : ComponentActivity() {
    private val broker = "mqtt://192.168.48.245:1883"
    private val clientId = MqttClient.generateClientId()
    private val topic = "map"

    private lateinit var client: MqttClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //connectToMqtt()

        setContent {
            var receivedMessage by remember { mutableStateOf("") }

            val AppViewModel: AppViewModel by viewModels()

            ProyectoInteligenciaAmbientalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*sendAndShowMessage(receivedMessage = receivedMessage) { message ->
                        sendMessage(message)
                    }*/
                    NavManager(appViewModel = AppViewModel)
                }
            }
        }
    }

    @Composable
    fun sendAndShowMessage(receivedMessage: String, onSendMessage: (String) -> Unit) {
        Column{
            Text(text = "Received Message: $receivedMessage")

            Button(onClick = {
                onSendMessage("Hello MQTT!!")
            }) {
                Text(text = "Send Message")
            }
        }
    }

    private fun connectToMqtt() {
        client = MqttClient(broker, clientId, MemoryPersistence())
        client.connect()

        client.setCallback(object : MqttCallbackExtended {
            override fun connectComplete(reconnect: Boolean, serverURI: String) {
                client.subscribe(topic)
            }

            override fun messageArrived(topic: String, message: MqttMessage) {
                val payload = String(message.payload)
                Log.d("MQTT", "Received message: $payload")
            }

            override fun deliveryComplete(token: IMqttDeliveryToken) {}

            override fun connectionLost(cause: Throwable) {}
        })
    }


    fun sendMessage(message: String){
        try {
            val mqttMessage = MqttMessage(message.toByteArray())
            client.publish(topic, mqttMessage)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        client.disconnect()
    }
}