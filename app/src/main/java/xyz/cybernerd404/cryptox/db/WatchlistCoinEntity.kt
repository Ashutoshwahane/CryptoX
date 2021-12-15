package xyz.cybernerd404.cryptox.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_coin_table")
data class WatchlistCoinEntity(
    @PrimaryKey
    var id: String? = null,
    var name:String? = null,
    var currentPrice: Any? = null,
    var symbol: Any? = null,
    var coinImage: String? = null,
    var isSelected: Boolean = false

)