package bzh.zomzog.kotlinworkshop.domain

import java.time.LocalDateTime

data class Pony(
    val id: String? = null,
    val name: String,
    val type: PonyType,
    val createdAt: LocalDateTime? = null
)