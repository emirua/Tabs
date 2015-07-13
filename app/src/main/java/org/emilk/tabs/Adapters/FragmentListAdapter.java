package org.emilk.tabs.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

import java.util.List;

/**
 * Created by Emilio on 10/07/2015.
 */
public class FragmentListAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    Context context;
    private List<Fragment> fragments;
    private List<String> titles;
    private List<Integer> tabIcons;


    public FragmentListAdapter(FragmentManager fm, Context context, List<Fragment> fragments, List<String> titles, List<Integer> tabIcons) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
        this.tabIcons = tabIcons;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        SpannableString spannableString = new SpannableString("  " + titles.get(position));
//        spannableString.setSpan(new ImageSpan(context, tabIcons.get(position), ImageSpan.ALIGN_BASELINE), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return spannableString;
//    }


    @Override
    public int getPageIconResId(int position) {
        return tabIcons.get(position);
    }
}
