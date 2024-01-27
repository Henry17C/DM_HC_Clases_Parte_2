package com.test.dm_clases_hc.data.network.endpoint.jikan.top

data class Pagination(
    val current_page: Int,
    val has_next_page: Boolean,
    val items: com.test.dm_clases_hc.data.network.endpoint.jikan.top.Items,
    val last_visible_page: Int
)