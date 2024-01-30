package com.examenp.dillan.dispositivosm_recyclewie_dc.core
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.jikan.top.Data
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.jikan.anime.FullInfoAnime
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.entities.FullInfoAnimeLG



fun FullInfoAnime.getFullInfoAnimeLG()= FullInfoAnimeLG (
    this.data.mal_id,
    this.data.title_english,
    this.data.duration,
    this.data.type,
    this.data.url,
    this.data.year,
    this.data.images.jpg.small_image_url,
    this.data.images.jpg.large_image_url,
    this.data.synopsis

)

public fun Data.getFullInfoAnimeLG()= FullInfoAnimeLG (
    this.mal_id,
    this.title_english,
    "0",
    "",
    "",
    0,
    this.images.jpg.small_image_url,
    this.images.jpg.large_image_url,
    this.synopsis

)
