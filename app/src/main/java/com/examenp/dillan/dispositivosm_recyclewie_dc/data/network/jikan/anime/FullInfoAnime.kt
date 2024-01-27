package com.test.dm_clases_hc.data.network.endpoint.jikan.anime

import com.test.dm_clases_hc.logic.entities.FullInfoAnimeLG

data class FullInfoAnime(
    val `data`: Data

)

fun FullInfoAnime.getFullAnimeLG() = FullInfoAnimeLG(
    this.data.mal_id,
    this.data.title_english,
    this.data.images.jpg.small_image_url,
    this.data.images.jpg.large_image_url,
    this.data.snapsis
)

