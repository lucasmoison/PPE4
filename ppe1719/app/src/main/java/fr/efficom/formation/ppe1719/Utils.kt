package fr.efficom.formation.ppe1719

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createBornesService(): BornesService{
    val urlApi = "https://ibm-patisserie-mysql-php-20190301074804229-grumpy-hartebeest.eu-gb.mybluemix.net/"
    val retrofit = Retrofit.Builder().baseUrl(urlApi)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bornesService = retrofit.create(BornesService::class.java)
    return bornesService
}