package org.mar_3.shoppingapp;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public FragmentManager fragmentManager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigation drawer to action bar, used as reference:
        // https://www.geeksforgeeks.org/navigation-drawer-in-android/

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNavigationViewListener();

        this.fragmentManager = getSupportFragmentManager();

        // Load the default first fragment at startup
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, StartFragment.class, null)
                    .commit();
        }
    }

    private void setNavigationViewListener() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // Method for checking which navigation drawer item was clicked, then switching to right fragment
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getTitle().toString()) {

            case "Settings": {
                fragmentManager
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView, SettingsFragment.class, null)
                        .commit();
                drawerLayout.close();
                return true;
            }
            case "Previous Lists": {
                fragmentManager
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView, PreviousListsFragment.class, null)
                        .commit();
                drawerLayout.close();
                return true;
            }
            case "About": {
                fragmentManager
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView, AboutFragment.class, null)
                        .commit();
                drawerLayout.close();
                return true;
            }
            default: {
                return false;
            }
        }
    }

    // Opening and closing the navigation drawer
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // changed the logic when device's back button is pressed,
    // This way the application will only close if there are fragments in the
    // back stack of the fragment manager.
    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            finish();
        }
        else {
            super.onBackPressed();
        }
    }
}