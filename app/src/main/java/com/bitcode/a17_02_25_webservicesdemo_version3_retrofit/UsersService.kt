package com.bitcode.a17_02_25_webservicesdemo_version3_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET("users")
    suspend fun getAllUsers(@Query("page") pageNumber : Int) : APIResponse

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