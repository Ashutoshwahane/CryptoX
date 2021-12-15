package xyz.cybernerd404.cryptox.model

import java.sql.Timestamp


data class BlockModel(
    var hash: String = "",
    var previous_hash: String = "",
    var time_stamp: String = "",
    var message: String? = ""
)