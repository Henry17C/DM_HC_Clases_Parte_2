package com.examenp.dillan.dispositivosm_recyclewie_dc.core


import com.test.dm_clases_hc.data.network.endpoint.jikan.anime.FullInfoAnime
import com.test.dm_clases_hc.data.network.endpoint.jikan.top.Data
import com.test.dm_clases_hc.logic.entities.FullInfoAnimeLG

fun FullInfoAnime.getFullInfoAnimeLG()=FullInfoAnimeLG(

    this.data.mal_id,
    this.data.title_english,
    this.data.images.jpg.small_image_url,
    this.data.images.jpg.large_image_url,
    this.data.snapsis
)

fun Data.getFullInfoAnimeLG()=FullInfoAnimeLG(

    this.mal_id,
    this.title_english,
    this.images.jpg.small_image_url,
    this.images.jpg.large_image_url,
    this.synopsis
)