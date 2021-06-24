package com.example.wise.model

import java.io.Serializable
data class Crypto(
    val exchange_id: String,
    val symbol: String,
    val price_unconverted: Float,
    val price: Float,
    val change_24h: Float,
    val spread: Float,
    val volume_24h: Float,
    val status: String,
    val time: String
):Serializable