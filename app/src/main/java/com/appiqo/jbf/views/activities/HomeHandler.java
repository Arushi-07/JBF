package com.appiqo.jbf.views.activities;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.appiqo.jbf.R;
import com.appiqo.jbf.adapter.CustomArrayAdapter;
import com.appiqo.jbf.adapter.CustomSwipeAdapter;
import com.appiqo.jbf.views.fragments.BestSellings;
import com.appiqo.jbf.views.fragments.CartStepOne;
import com.appiqo.jbf.views.fragments.CartStepThree;
import com.appiqo.jbf.views.fragments.CartStepTwo;
import com.appiqo.jbf.views.fragments.Notification;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class HomeHandler extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ImageView hamburger,cart,search,menu,notification,back;
    TextView title,notification_count,cart_count;
    AutoScrollViewPager viewPager;
    ArrayList<Integer> images;
    Dialog search_dialog;
    ListView listView;
    ArrayList<String> popularSearches;
    LinearLayout homeContainer,toolbarLayout,cart_steps;
    TextView stepCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_handler);
        init();
        changeStatusBarColor();
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationIcon(null);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle("HOME");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        title.setText("HOME");

        getImages();
        viewPager.setAdapter(new CustomSwipeAdapter(getApplicationContext(),images));
        viewPager.startAutoScroll(4000);
        viewPager.setScrollDurationFactor(6);
        viewPager.setCycle(true);

        search_dialog=new Dialog(this);
        search_dialog.getWindow().setWindowAnimations(R.style.DialogAnimation);
        search_dialog.setCanceledOnTouchOutside(true);
       // search_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //style id
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate( R.layout.search_layout, null );
                listView=(ListView) view.findViewById(R.id.popular_searches);
                createPopularSearches();
                listView.setAdapter(new CustomArrayAdapter(getApplicationContext(),popularSearches));
                search_dialog.setContentView(view);
                search_dialog.show();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               changeContainer("notification",new Notification(),"NOTIFICATION");
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeCartContainer("CartStepOne","CART",1,new CartStepOne());

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fashionContainer, new BestSellings())
                .commit();
    }
    public void changeCartContainer(String tag,String title,int step,Fragment fragment)
    {
        homeContainer.setVisibility(View.VISIBLE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.homeContainer, fragment)
                .addToBackStack(tag)
                .commit();

        back.setVisibility(View.VISIBLE);
        setInvisibility();
        this.title.setText(title);
        stepCount.setText(step+"");
        toolbarLayout.setBackgroundColor(getResources().getColor(R.color.red));
        cart_steps.setVisibility(View.VISIBLE);
    }

    public void changeContainer(String tag,Fragment fragment,String title)
    {
        homeContainer.setVisibility(View.VISIBLE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.homeContainer, fragment)
                .addToBackStack(tag)
                .commit();

        back.setVisibility(View.VISIBLE);
        setInvisibility();
        this.title.setText(title);
        toolbarLayout.setBackgroundColor(getResources().getColor(R.color.red));
        cart_steps.setVisibility(View.INVISIBLE);

    }
    private void setInvisibility() {

        hamburger.setVisibility(View.INVISIBLE);
        cart.setVisibility(View.INVISIBLE);
        cart_count.setVisibility(View.INVISIBLE);
        menu.setVisibility(View.INVISIBLE);
        notification.setVisibility(View.INVISIBLE);
        notification_count.setVisibility(View.INVISIBLE);
    }

    private void setVisibility()
    {
        hamburger.setVisibility(View.VISIBLE);
        cart.setVisibility(View.VISIBLE);
        cart_count.setVisibility(View.VISIBLE);
        menu.setVisibility(View.VISIBLE);
        notification.setVisibility(View.VISIBLE);
        notification_count.setVisibility(View.VISIBLE);

    }
    public void init()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        hamburger=(ImageView)findViewById(R.id.hamburger);
        notification=(ImageView)findViewById(R.id.notification);
        back=(ImageView)findViewById(R.id.back);
        title=(TextView)findViewById(R.id.title);
        viewPager=(AutoScrollViewPager)findViewById(R.id.view_pager);
        search=(ImageView)findViewById(R.id.search);
        cart=(ImageView)findViewById(R.id.cart);
        menu=(ImageView)findViewById(R.id.menu);
        notification_count=(TextView)findViewById(R.id.notification_count);
        cart_count=(TextView)findViewById(R.id.cart_count);
        homeContainer=(LinearLayout)findViewById(R.id.homeContainer);
        toolbarLayout=(LinearLayout)findViewById(R.id.toolbar_layout);
        cart_steps=(LinearLayout)findViewById(R.id.cart_steps);
        stepCount=(TextView)findViewById(R.id.step_count);
    }
    @Override
    public void onBackPressed() {

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.homeContainer);
        if(currentFragment instanceof Notification ||currentFragment instanceof CartStepOne|| currentFragment instanceof CartStepTwo
        ||currentFragment instanceof CartStepThree)
        {
            getSupportFragmentManager().popBackStack();
        }
        else
        {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
       // currentFragment = getSupportFragmentManager().findFragmentById(R.id.homeContainer);
        if(currentFragment instanceof Notification ||currentFragment instanceof CartStepOne)
        {
            homeContainer.setVisibility(View.GONE);
            back.setVisibility(View.INVISIBLE);
            title.setText("HOME");
            setVisibility();
            toolbarLayout.setBackgroundColor(getResources().getColor(R.color.transparent));
            cart_steps.setVisibility(View.INVISIBLE);
        }
        else if( currentFragment instanceof CartStepTwo)
        {
            stepCount.setText("1");
            title.setText("CART");
        }
        else if(currentFragment instanceof CartStepThree)
        {
            stepCount.setText("2");
            title.setText("ADDRESSES");
        }

    }

    public void getImages() {
        images=new ArrayList<Integer>();
        images.add(R.drawable.offerone);
        images.add(R.drawable.offertwo);
        images.add(R.drawable.offerthree);
    }

    public void createPopularSearches() {
        popularSearches=new ArrayList<>();
        popularSearches.add("Men's T Shirt");
        popularSearches.add("Men's Jeans");
        popularSearches.add("Women's Jeans");
        popularSearches.add("Women's Dresses");
        popularSearches.add("Women's Top");
        popularSearches.add("Kid's Shirts");
        popularSearches.add("Printed T Shirts");

    }

    private void changeStatusBarColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}
