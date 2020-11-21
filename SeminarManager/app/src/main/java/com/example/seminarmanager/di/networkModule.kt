package com.example.seminarmanager.di

import com.example.seminarmanager.BuildConfig
import com.example.seminarmanager.SeminarManagerApplication
import com.example.seminarmanager.api.SeminarService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), BuildConfig.WAFFLE_BACKEND_BASE_URL) }
    single { provideApiService(get()) }
}

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val apiKeyInterceptor = object: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val url = request.url.newBuilder().build()
            return chain.proceed(request.newBuilder().url(url).build())
        }
    }

    val tokenInterceptor = object: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val authHeader = SeminarManagerApplication.prefs.getString("user_token_key", "")

            val original = chain.request()
            val builder = original.newBuilder().method(original.method, original.body)
            builder.header("Authorization", "Token $authHeader")
            return chain.proceed(builder.build())
        }
    }

    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(apiKeyInterceptor)
        .addInterceptor(tokenInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): SeminarService =
    retrofit.create(SeminarService::class.java)