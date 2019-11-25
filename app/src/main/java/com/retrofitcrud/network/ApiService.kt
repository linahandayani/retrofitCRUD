package com.retrofitcrud.network

import com.retrofitcrud.model.ResponseLogin
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("login_api")
    fun login_api(
        @Query("nama") username: String,
        @Query("password") password: String
        ): Call<ResponseLogin>
}