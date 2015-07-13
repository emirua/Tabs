package org.emilk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.astuetz.PagerSlidingTabStrip;

import org.emilk.tabs.Adapters.FragmentListAdapter;
import org.emilk.tabs.fragments.FragmentContacts;
import org.emilk.tabs.fragments.FragmentPartidos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab_layout)
    PagerSlidingTabStrip tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar mtoolbar = getSupportActionBar();
        mtoolbar.setTitle("Selecciona una Tab");
        mtoolbar.setDisplayHomeAsUpEnabled(true);

        setUpFragmentsInViewPager(mtoolbar);

    }

    private void setUpFragmentsInViewPager(ActionBar t) {
        t.setElevation(0);

        List<Fragment> fragments= new ArrayList<>();
        fragments.add(new FragmentContacts());
        fragments.add(new FragmentPartidos());

        List<String> titles= new ArrayList<>();
        titles.add("Contactos");
        titles.add("Partidos");

        List<Integer> tabicons= new ArrayList<>();
        tabicons.add(R.drawable.tab_user_selector);
        tabicons.add(R.drawable.tab_world_selector);


        FragmentListAdapter fA= new FragmentListAdapter(getSupportFragmentManager(), MainActivity.this, fragments, titles, tabicons);

        viewPager.setAdapter(fA);

        tabLayout.setViewPager(viewPager);

        Field field = null;
        try {
            field = PagerSlidingTabStrip.class.getDeclaredField("tabsContainer");
            field.setAccessible(true);
            LinearLayout tabsContainer = (LinearLayout) field.get(tabLayout);
            tabsContainer.getChildAt(0).setSelected(true);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        tabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int currentSelection = 0;
            Field field;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                try {
                    field = PagerSlidingTabStrip.class.getDeclaredField("tabsContainer");
                    field.setAccessible(true);
                    LinearLayout tabsContainer = (LinearLayout) field.get(tabLayout);
                    tabsContainer.getChildAt(currentSelection).setSelected(false);
                    currentSelection = position;
                    tabsContainer.getChildAt(position).setSelected(true);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
