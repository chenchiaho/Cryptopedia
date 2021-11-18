package com.example.android.cryptopedia.domain.use_case.get_coins

import com.example.android.cryptopedia.common.Resource
import com.example.android.cryptopedia.data.remote.dto.toCoin
import com.example.android.cryptopedia.domain.model.Coin
import com.example.android.cryptopedia.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Unable to reach server. Check your internet connection"))
        }
    }
}