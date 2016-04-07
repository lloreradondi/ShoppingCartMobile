package app.portfolio.ordering;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import app.portfolio.ordering.Adapter.BaseDrawerAdapter;
import app.portfolio.ordering.Fragment.Products;
import app.portfolio.ordering.Fragment.Profile;
import app.portfolio.ordering.Fragment.Settings;
import app.portfolio.ordering.Fragment.ShoppingCart;
import app.portfolio.ordering.Interface.DrawerCallBack;

public class BaseActivity extends AppCompatActivity {
    Context context;
    String TITLES[] = {"My Profile","Products","Settings"};
    int ICONS[] = {R.mipmap.ic_account, R.mipmap.ic_format_list_bulleted,R.mipmap.ic_settings};
    String NAME = "Dione Llorera";
    String EMAIL = "dionedavellorera@yahoo.com";
    int PROFILE = R.mipmap.profile_picture;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        context = getApplicationContext();
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        DrawerCallBack drawerCallBack = new DrawerCallBack() {
            @Override
            public void onDrawerItemClicked(int position) {
                switch (position) {
                    case 1:
                        showFragment(new Profile());
                        Drawer.closeDrawers();
                        break;
                    case 2:
                        showFragment(new Products());
                        Drawer.closeDrawers();
                        break;
                    case 3:
                        showFragment(new Settings());
                        Drawer.closeDrawers();
                    default:
                        break;
                }
            }
        };
        mAdapter = new BaseDrawerAdapter(context,TITLES,ICONS,NAME,EMAIL,PROFILE, drawerCallBack);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer, toolbar,R.string.open_drawer,R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        Drawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, fragment);
        fragmentTransaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.base, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_shopping_cart:
                showFragment(new ShoppingCart());
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
