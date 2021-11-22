package com.example.android.cryptopedia.domain.use_case.get_coin

import com.example.android.cryptopedia.common.Resource
import com.example.android.cryptopedia.data.remote.dto.toCoin
import com.example.android.cryptopedia.data.remote.dto.toCoinDetail
import com.example.android.cryptopedia.domain.model.Coin
import com.example.android.cryptopedia.domain.model.CoinDetail
import com.example.android.cryptopedia.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Unable to reach server. Check your internet connection"))
        }
    }
}