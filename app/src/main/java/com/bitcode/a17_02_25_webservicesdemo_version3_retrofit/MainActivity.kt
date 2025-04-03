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

            //worker or background thread created -- by switching scope to IO from MainThread
            CoroutineScope(Dispatchers.IO).launch {
                //getAllUsers
                var apiResponse = usersService.getAllUsers(1)
                Log.e("tag", "${apiResponse.users}")

                //getUserById
                var apiResponseForUser = usersService.getUserById(5)

                Log.e("tag", "${apiResponseForUser.user}")

                //post User
                var postUser = PostUser("morpheus", "leader")
                var postUserResponse = usersService.postUser(postUser)

                Log.e("tag", "$postUserResponse")

                //put User - update
                var putUser = PutUser("morpheus", "zion resident")

                var postResponseForUpdateUser = usersService.updateUser(putUser, 2)
                Log.e("tag","Put --- $postResponseForUpdateUser")

                //delete user
                var deleteUserResponse = usersService.deleteUser(2)

                //switching back from IO to MainThread for binding of data purpose
                withContext(coroutineContext) {
                    activityMainBinding.txtViewForFirstName.text = apiResponse.users[0].firstName
                }
            }
        }
    }
}