package com.example.seminarmanager.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface SeminarService {

    // 세미나 리스 조회
    @GET("seminar/")
    fun getSeminarList(@Query("name") name: String, @Query("order") order: String) : Single<List<SimpleSeminar>>

    // 세미나 생성
    @FormUrlEncoded
    @POST("seminar/")
    fun postSeminar(@Field("name") name: String,
                    @Field("capacity") capacity: String,
                    @Field("count") count: String,
                    @Field("time") time: String,
                    @Field("online") online: String,
                    ) : Single<Seminar>

    // 특정 세미나 조회
    @GET("seminar/{seminarId}/")
    fun getSeminar(@Path("seminarId") seminarId: Long) : Single<Seminar>

    // 세미나 등록
    @FormUrlEncoded
    @POST("seminar/{seminarId}/user/")
    fun joinSeminar(@Path("seminarId") seminarId: Long) : Single<Seminar>

}