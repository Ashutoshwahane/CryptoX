package xyz.cybernerd404.cryptox.view

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.view.coins.CoinFragment
import xyz.cybernerd404.cryptox.view.exchange.BlockChainFragment
import xyz.cybernerd404.cryptox.view.home.HomeFragment
import xyz.cybernerd404.cryptox.view.more.MoreFragment
import xyz.cybernerd404.cryptox.view.trending.TrendingFragment

class MainActivity : AppCompatActivity() {

    lateinit var activeFragment: Fragment
    private val homeFragment = HomeFragment()
    private val coinFragment = CoinFragment()
    private val trendingFragment = TrendingFragment()
    private val exchangeFragment = BlockChainFragment()
    private val moreFragment = MoreFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activeFragment = trendingFragment

        bottom_navigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.homeFragment -> {
                        loadFragment(homeFragment)
                        return true
                    }
                    R.id.coinFragment -> {
                        loadFragment(coinFragment)
                        return true
                    }
                    R.id.trendingFragment -> {
                        loadFragment(trendingFragment)
                        return true
                    }
                    R.id.exchangeFragment -> {
                        loadFragment(exchangeFragment)
                        return true
                    }
                    R.id.moreFragment -> {
                        loadFragment(moreFragment)
                        return true
                    }

                    else -> {
                        loadFragment(homeFragment)
                        return false
                    }
                }
            }
        })
        activeFragment = trendingFragment
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.executePendingTransactions()
        if (!fragment.isAdded) {
            transaction.hide(activeFragment)
            transaction.add(R.id.fragmentContainerView, fragment)
            transaction.show(fragment)
            activeFragment = fragment
        } else {
            transaction.hide(activeFragment)
            transaction.show(fragment)
            activeFragment = fragment
        }
        transaction.commitAllowingStateLoss()
        supportFragmentManager.executePendingTransactions()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}