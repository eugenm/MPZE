package android.mittelstand.de.mpze.activities;

import android.app.FragmentManager;
import android.mittelstand.de.mpze.R;
import android.mittelstand.de.mpze.adapters.UserAdapter;
import android.mittelstand.de.mpze.data.User;
import android.mittelstand.de.mpze.fragments.ListFragment;
import android.mittelstand.de.mpze.fragments.MainFragment;
import android.mittelstand.de.mpze.fragments.SettingsFragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm;
    MainFragment mainFragment;
    ListFragment listFragment;
    SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getFragmentManager();
        mainFragment = new MainFragment();
        listFragment = new ListFragment();
        settingsFragment = new SettingsFragment();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fm.beginTransaction().replace(R.id.content_frame, mainFragment).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_main) {
            fm.beginTransaction().replace(R.id.content_frame, mainFragment).commit();
        } else if (id == R.id.nav_list) {
            fm.beginTransaction().replace(R.id.content_frame, listFragment).commit();
        } else if (id == R.id.nav_settings) {
            fm.beginTransaction().replace(R.id.content_frame, settingsFragment).commit();
        } else if (id == R.id.nav_exit) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
