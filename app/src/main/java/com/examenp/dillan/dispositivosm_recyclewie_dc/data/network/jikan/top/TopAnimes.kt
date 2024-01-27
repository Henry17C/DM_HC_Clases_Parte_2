package com.test.dm_clases_hc.data.network.endpoint.jikan.top

data class TopAnimes(
    val data: List<Data> =listOf(),
    val pagination: Pagination? = null
)