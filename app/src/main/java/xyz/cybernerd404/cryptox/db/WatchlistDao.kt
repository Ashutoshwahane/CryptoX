package xyz.cybernerd404.cryptox.db

import androidx.room.*

@Dao
interface WatchlistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(
        watchlistCoinEntity: WatchlistCoinEntity
    )

    @Query("SELECT * FROM crypto_coin_table")
    suspend fun getCoin(): List<WatchlistCoinEntity>


}