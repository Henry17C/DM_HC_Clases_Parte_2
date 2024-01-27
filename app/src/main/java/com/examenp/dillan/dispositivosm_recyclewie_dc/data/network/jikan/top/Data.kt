package com.test.dm_clases_hc.data.network.endpoint.jikan.top

import com.examenp.dillan.dispositivosm_recyclewie_dc.core.getFullInfoAnimeLG

data class Data(
    val aired: com.test.dm_clases_hc.data.network.endpoint.jikan.top.Aired,
    val airing: Boolean,
    val approved: Boolean,
    val background: String,
    val broadcast: com.test.dm_clases_hc.data.network.endpoint.jikan.top.Broadcast,
    val demographics: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Demographic>,
    val duration: String,
    val episodes: Int,
    val explicit_genres: List<Any>,
    val favorites: Int,
    val genres: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Genre>,
    val images: com.test.dm_clases_hc.data.network.endpoint.jikan.top.Images,
    val licensors: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Licensor>,
    val mal_id: Int,
    val members: Int,
    val popularity: Int,
    val producers: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Producer>,
    val rank: Int,
    val rating: String,
    val score: Double,
    val scored_by: Int,
    val season: String,
    val source: String,
    val status: String,
    val studios: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Studio>,
    val synopsis: String,
    val themes: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Theme>,
    val title: String,
    val title_english: String,
    val title_japanese: String,
    val title_synonyms: List<String>,
    val titles: List<com.test.dm_clases_hc.data.network.endpoint.jikan.top.Title>,
    val trailer: com.test.dm_clases_hc.data.network.endpoint.jikan.top.Trailer,
    val type: String,
    val url: String,
    val year: Int
)