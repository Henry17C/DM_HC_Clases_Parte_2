package com.test.dm_clases_hc.data.network.endpoint.jikan.anime

data class Trailer(
    val embed_url: String,
    val images: com.test.dm_clases_hc.data.network.endpoint.jikan.anime.ImagesX,
    val url: String,
    val youtube_id: String
)