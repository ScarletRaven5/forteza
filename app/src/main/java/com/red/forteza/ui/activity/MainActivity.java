package com.red.forteza.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.red.forteza.R;
import com.red.forteza.data.api.FirebaseApi;
import com.red.forteza.ui.fragment.AnatomyFragment;
import com.red.forteza.ui.fragment.EmptyFragment;
import com.red.forteza.ui.fragment.GuardsFragment;
import com.red.forteza.ui.fragment.HistoryFragment;
import com.red.forteza.ui.fragment.HomeFragment;
import com.red.forteza.ui.fragment.SettingsFragment;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

//    @BindView(R.id.firebaseImg)
//    ImageView img;

    private StorageReference mStorageRef;
    FirebaseApi firebase = new FirebaseApi();
    int menuItemID;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        swapContent(R.id.nav_home);

//        firebase.readImageValue("data/images/position1", getBaseContext(), img);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        menuItemID = item.getItemId();
        swapContent(menuItemID);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void swapContent(int itemId) {
        setTitle(null);
        switch (itemId) {
            case R.id.nav_home:
                setTitle(Res.string(R.string.nav_home));
                setContent(HomeFragment.newInstance());
                break;
            case R.id.nav_history:
                setTitle(Res.string(R.string.nav_history));
                setContent(HistoryFragment.newInstance());
                break;
            case R.id.nav_parts:
                setTitle(Res.string(R.string.nav_parts));
                setContent(AnatomyFragment.newInstance());
                break;
            case R.id.nav_positions:
                setTitle(Res.string(R.string.nav_guards));
                setContent(GuardsFragment.newInstance());
                break;
            case R.id.nav_quiz:
                setTitle(Res.string(R.string.nav_quiz));
                setContent(EmptyFragment.newInstance());
                break;
            case R.id.nav_change:
                setTitle(Res.string(R.string.nav_change));
                setContent(SettingsFragment.newInstance());
                break;
        }
    }
}
