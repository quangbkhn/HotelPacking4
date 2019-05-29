package com.example.quang.hotelpacking.Fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quang.hotelpacking.Class.Vehicle
import com.example.quang.hotelpacking.ClassAdapter.VehicleAdapter
import com.example.quang.hotelpacking.R
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class List_fragment : Fragment() {
    var list = mutableListOf<Vehicle>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.list_fragment, container, false)
        var recyclerview = v.findViewById<RecyclerView>(R.id.list_cho)
        var recyclerviewadapter = VehicleAdapter(context,list)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = recyclerviewadapter
        return v

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        list.add(Vehicle("123","quaan","yes"))
        val clientId = MqttClient.generateClientId()
       val client = MqttAndroidClient(activity?.applicationContext,"tcp://postman.cloudmqtt.com:17482",clientId)
 try {
            val options = MqttConnectOptions()
            options.userName = "mliyedfs"
            options.password = "ivDJb1oRl8G2".toCharArray()
            var token = client.run({ connect(options) })
     token.actionCallback = object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    // We are connected
                    Log.d("A", "onSuccess")
                    Toast.makeText(activity,"ket noi thanh cong ",Toast.LENGTH_LONG).show()
                    client.subscribe("dock_man/respond/bike/123", 1);
                    client.setCallback(object: MqttCallback{
                        override fun connectionLost(cause: Throwable?) {

                        }

                        override fun deliveryComplete(token: IMqttDeliveryToken?) {
                        }

                        override fun messageArrived(topic: String, message: MqttMessage) {

                            Toast.makeText(activity,message.toString(),Toast.LENGTH_LONG).show()

                        }

                    })
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d("A", "onFailure")
                    Toast.makeText(activity,"ket noi that bai",Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: MqttException) {
            e.printStackTrace()
        }
       super.onCreate(savedInstanceState)
    }

    }



