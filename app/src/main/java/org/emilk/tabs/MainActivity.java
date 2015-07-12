package org.emilk.tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.emilk.tabs.Adapters.FragmentAdapter;
import org.emilk.tabs.fragments.FragmentContacts;
import org.emilk.tabs.fragments.FragmentPartidos;

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
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar mtoolbar = getSupportActionBar();
        mtoolbar.setTitle("Selecciona de las Tabs");
        mtoolbar.setDisplayHomeAsUpEnabled(true);

        setUpFragmentsInViewPager(mtoolbar);

    }

    private void setUpFragmentsInViewPager(ActionBar t) {
        t.setElevation(0);
        List<Fragment> fragments= new ArrayList<>();
        fragments.add(new FragmentContacts());
        fragments.add(new FragmentPartidos());


        FragmentAdapter fA= new FragmentAdapter(getSupportFragmentManager(),fragments);

        viewPager.setAdapter(fA);

        tabLayout.setupWithViewPager(viewPager);
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
