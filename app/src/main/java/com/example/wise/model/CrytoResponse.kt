package com.example.wise.model

data class CrytoResponse(
    val markets: ArrayList<Crypto>,
    val pagination: Pagination
)