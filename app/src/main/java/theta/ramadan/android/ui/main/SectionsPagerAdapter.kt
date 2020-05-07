package theta.ramadan.android.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import theta.ramadan.android.R
import theta.ramadan.android.ui.ChatFragment
import theta.ramadan.android.ui.ui.home.HomeFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3,
    R.string.tab_text_4
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var fragment: Fragment = HomeFragment()


        when (position) {

            0 -> {
                fragment = HomeFragment()
            }
            1 -> {
                fragment = PlaceholderFragment()
            }

            2 -> {
                fragment = ChatFragment()
            }

            3 -> {
                fragment = HomeFragment()
            }
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 4 total pages.
        return 4
    }
}
