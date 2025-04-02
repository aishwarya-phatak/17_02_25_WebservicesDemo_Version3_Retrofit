package com.bitcode.a17_02_25_webservicesdemo_version3_retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bitcode.a17_02_25_webservicesdemo_version3_retrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        var usersService = UsersService.getInstance()

        activityMainBinding.btnFetchData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                var apiResponse = usersService.getAllUsers(1)

                Log.e("tag", "${apiResponse.users}")

                withContext(coroutineContext) {
                    activityMainBinding.txtViewForFirstName.text = apiResponse.users[0].firstName
                }
            }
        }
    }
}