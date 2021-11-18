package com.example.android.cryptopedia.domain.repository

import com.example.android.cryptopedia.data.remote.dto.CoinDetailDto
import com.example.android.cryptopedia.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun  getCoins(): List<CoinDto>
    suspend fun  getCoinById(coinId: String): CoinDetailDto
}