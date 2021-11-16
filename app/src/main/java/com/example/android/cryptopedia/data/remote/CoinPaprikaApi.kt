package com.example.android.cryptopedia.data.remote

import com.example.android.cryptopedia.data.remote.dto.CoinDetailDto
import com.example.android.cryptopedia.data.remote.dto.CoinDto
import com.example.android.cryptopedia.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinID") coinId: String): CoinDetailDto
}