package xyz.cybernerd404.cryptox.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import xyz.cybernerd404.cryptox.view.home.networks.HomeNetworksFragment
import xyz.cybernerd404.cryptox.view.home.calculator.HomeCalculatorFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return when(position) {
            0 -> {
                HomeCalculatorFragment()
            }
            1 -> {
                HomeNetworksFragment()
            }

            else -> HomeCalculatorFragment()
        }

    }
}