package org.yaoming.mydemos.libcollections.home.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import org.yaoming.mydemos.libcollections.R;
import org.yaoming.mydemos.libcollections.democode.view.DemoCodeFragment;
import org.yaoming.mydemos.libcollections.global.AbUtil.AbViewUtil;
import org.yaoming.mydemos.libcollections.home.presenter.HomePresenterImpl;


public class HomeActivity extends AppCompatActivity implements IHomeView{

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private HomePresenterImpl mHomePresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AbViewUtil.scaleContentView((ViewGroup)getWindow().getDecorView().findViewById(android.R.id.content));
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle =  new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mHomePresenterImpl= new HomePresenterImpl(this);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mHomePresenterImpl.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });

        switch2DemoCode();
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

    @Override
    public void switch2DemoCode() {
        getSupportFragmentManager().beginTransaction().add(R.id.frame_content,new DemoCodeFragment()).commit();
        mToolbar.setTitle(R.string.navigation_demos);
    }

    @Override
    public void switch2Website() {
        getSupportFragmentManager().beginTransaction().add(R.id.frame_content,new DemoCodeFragment()).commit();
        mToolbar.setTitle(R.string.navigation_website);
    }

    @Override
    public void switch2AboutMe() {
        getSupportFragmentManager().beginTransaction().add(R.id.frame_content,new DemoCodeFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
    }
}
