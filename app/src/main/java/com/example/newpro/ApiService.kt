package com.example.newpro

import retrofit2.Retrofit


object ApiService {
    private  val TAG = "--ApiService"

//    private const val BASE_URL = "http:///KotlinExample/LoginRegistration/"
private const val BASE_URL = "http://fujil3ossmew.tk/Fujiya/"

    fun loginApiCall() = Retrofit.Builder()
        .baseUrl(BASE_URL)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ApiWorker.gsonConverter)
        .client(ApiWorker.client)
        .build()
        .create(ApiList::class.java)
}


//    fun loginApiCall(): ApiList = Retrofit.Builder()
//        .baseUrl(BASE_URL)
////            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .addConverterFactory(ApiWorker.gsonConverter)
//        .client(ApiWorker.client)
//        .build()
//        .create(ApiList::class.java)
//}
