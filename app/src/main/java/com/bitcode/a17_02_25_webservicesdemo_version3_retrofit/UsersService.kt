package com.bitcode.a17_02_25_webservicesdemo_version3_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {

    @GET("users")
    suspend fun getAllUsers(@Query("page") pageNumber : Int) : APIResponse

    @GET("users/{user_id}")
    suspend fun getUserById(@Path("user_id") id : Int) : APIResponseForUser

    companion object{
        fun getInstance(): UsersService{
            var retrofit = Retrofit.Builder()
                            .baseUrl("https://reqres.in/api/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

            var usersService = retrofit.create(UsersService::class.java)
            return usersService
        }
    }
}