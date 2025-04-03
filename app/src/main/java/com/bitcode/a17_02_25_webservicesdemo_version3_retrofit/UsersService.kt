package com.bitcode.a17_02_25_webservicesdemo_version3_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {

    @GET("users")
    suspend fun getAllUsers(@Query("page") pageNumber : Int) : APIResponse

    @GET("users/{user_id}")
    suspend fun getUserById(@Path("user_id") id : Int) : APIResponseForUser

    @POST("users")
    suspend fun postUser(@Body user: PostUser) : PostResponseForUser

    @PUT("users/{user_id}")
    suspend fun updateUser(@Body user: PutUser, @Path("user_id") id : Int )
                        : PostResponseForUpdateUser

    @DELETE("users/{user_id}")
    suspend fun deleteUser(@Path("user_id") id : Int)

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