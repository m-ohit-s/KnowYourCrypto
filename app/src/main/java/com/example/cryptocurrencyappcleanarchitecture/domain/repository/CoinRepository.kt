package com.example.cryptocurrencyappcleanarchitecture.domain.repository

import com.example.cryptocurrencyappcleanarchitecture.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyappcleanarchitecture.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}