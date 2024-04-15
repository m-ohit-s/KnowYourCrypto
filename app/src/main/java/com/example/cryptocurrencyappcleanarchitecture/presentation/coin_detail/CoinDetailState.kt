package com.example.cryptocurrencyappcleanarchitecture.presentation.coin_detail

import com.example.cryptocurrencyappcleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail?= null,
    val error: String = ""
)
