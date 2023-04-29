package com.example.api

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiSample = "http://198.162.1.9:8000/order/list?response_type=code&client_id=&redirect_uri=%2F"

        val reqQueue: RequestQueue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET,apiSample,  { result ->
            Log.d("volley Example", result.toString())
        }, {err ->
            Log.d("volley Example", err.toString())
        })
        request.setRetryPolicy(
            DefaultRetryPolicy(
            10000, // 10 seconds timeout
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        )

        reqQueue.add(request)
    }
}
