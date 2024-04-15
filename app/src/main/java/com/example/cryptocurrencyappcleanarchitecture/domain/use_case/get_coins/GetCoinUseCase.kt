package com.example.cryptocurrencyappcleanarchitecture.domain.use_case.get_coins

import com.example.cryptocurrencyappcleanarchitecture.common.Resource
import com.example.cryptocurrencyappcleanarchitecture.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyappcleanarchitecture.domain.model.CoinDetail
import com.example.cryptocurrencyappcleanarchitecture.domain.repository.CoinRepository
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
            emit(Resource.Loading())
            val coinDetail = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))
        }
        catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }
    }
}