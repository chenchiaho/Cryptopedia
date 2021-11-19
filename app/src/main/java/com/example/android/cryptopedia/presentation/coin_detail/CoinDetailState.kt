package com.example.android.cryptopedia.presentation.coin_detail

import com.example.android.cryptopedia.domain.model.Coin
import com.example.android.cryptopedia.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
