package xyz.cybernerd404.cryptox.utils

import xyz.cybernerd404.cryptox.model.CoinResponseItem

interface CoinClickListener {
 fun coinClickListener(coinResponseItem: CoinResponseItem)
}

interface NewsClickListener{
 fun newsClickListener(newUrl: String)
}