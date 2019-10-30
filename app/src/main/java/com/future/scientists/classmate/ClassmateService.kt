package com.future.scientists.classmate

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ClassmateService {
    @POST("api/auth/auth.php")
    fun saveUser(@Body user: User): Call<User>
}