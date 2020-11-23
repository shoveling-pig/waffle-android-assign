package com.example.seminarmanager.api

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    // 로그인
    @FormUrlEncoded
    @PUT("user/login/")
    fun login(@Field("username") username: String, @Field("password") password: String) : Single<User>

    // 회원가입
    @FormUrlEncoded
    @POST("user/")
    fun signUp(@Field("username") username: String,
               @Field("password") password: String,
               @Field("email") email: String,
               @Field("first_name") firstname: String,
               @Field("last_name") lastname: String,
               @Field("role") role: String,
               @Field("company") company: String,
               @Field("year") year: String,
               @Field("university") university: String,
               @Field("accepted") accepted: String
               ): Single<Response<User>>

    // 회원정보 조회
    @GET("user/me/")
    fun getUserInfo() : Single<User>

    // 회원정보 수정
    @FormUrlEncoded
    @PUT("user/me/")
    fun editUserInfo(@Field("username") username: String,
                    @Field("firstname") firstname: String,
                    @Field("lastname") lastname: String
                    ): Single<User>

}