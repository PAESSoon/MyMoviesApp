package com.example.mymovies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public PagerAdapter pagerAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton optionsBtn;
    static String genre;
    static String[] movies_array;
    ViewPager viewPager;
    static Movie genreSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies_array = getResources().getStringArray(R.array.movies);

        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_menu);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        optionsBtn = findViewById(R.id.options_button);

        DescriptionFragment descriptionFragment = DescriptionFragment.getInstance();
        PosterFragment posterFragment = PosterFragment.getInstance();

        /* ************ create a scrollable list ********** */
        MovieListFragment movieListFragment = new MovieListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, movieListFragment).commit();


        /* ************ Swipe ********** */
        viewPager = findViewById(R.id.top_container);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        descriptionFragment.setAdapter(pagerAdapter);
        posterFragment.setAdapter(pagerAdapter);

        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.fragments_tab);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onClickOptions(View v) {
        drawerLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.menu_comedy) {
            movies_array = getResources().getStringArray(R.array.comedy);
        } else if(id == R.id.menu_action) {
            movies_array = getResources().getStringArray(R.array.action);
        } else if(id == R.id.menu_drama){
            movies_array = getResources().getStringArray(R.array.drama);
        } else {
            movies_array = getResources().getStringArray(R.array.movies);
        }

        MovieListFragment movieListFragment = new MovieListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, movieListFragment).commit();

        if(movies_array[0].equals(getResources().getStringArray(R.array.action)[0])) {
            String onLoadMovieTitle = getResources().getString(R.string.Pikachu_title);
            String onLoadMovieDirectors = getResources().getString(R.string.Pikachu_director);
            String onLoadMovieActors = getResources().getString(R.string.Pikachu_stars);
            String onLoadMovieTrailer = getResources().getString(R.string.Pikachu_trailer);
            genreSelected = new Movie(onLoadMovieTitle, R.drawable.detective_pikachu, R.string.Pikachu_description, onLoadMovieDirectors, onLoadMovieActors, onLoadMovieTrailer);
        } else if(movies_array[0].equals(getResources().getStringArray(R.array.drama)[0])) {
            String onLoadMovieTitle = getResources().getString(R.string.Cruella_title);
            String onLoadMovieDirectors = getResources().getString(R.string.Cruella_director);
            String onLoadMovieActors = getResources().getString(R.string.Cruella_stars);
            String onLoadMovieTrailer = getResources().getString(R.string.Cruella_trailer);
            genreSelected = new Movie(onLoadMovieTitle, R.drawable.cruella, R.string.Cruella_description, onLoadMovieDirectors, onLoadMovieActors, onLoadMovieTrailer);
        } else {
            String onLoadMovieTitle = getResources().getString(R.string.love_actually_title);
            String onLoadMovieDirectors = getResources().getString(R.string.love_actually_director);
            String onLoadMovieActors = getResources().getString(R.string.love_actually_stars);
            String onLoadMovieTrailer = getResources().getString(R.string.love_actually_trailer);
            genreSelected = new Movie(onLoadMovieTitle, R.drawable.love_actually, R.string.love_actually_description, onLoadMovieDirectors, onLoadMovieActors, onLoadMovieTrailer);
        }

        try{
            PosterFragment posterFragment = PosterFragment.getInstance();
            posterFragment.setData(genreSelected);

            DescriptionFragment descriptionFragment = DescriptionFragment.getInstance();
            descriptionFragment.setData(genreSelected);

            YoutubeFragment youtubeFragment = YoutubeFragment.getInstance();
            youtubeFragment.setData(genreSelected);

        } catch(Exception e) {
            Log.e("Exception in onItemClick", e.toString());
        }

        drawerLayout.setVisibility(View.GONE);
//        drawerLayout.closeDrawer(GravityCompat.);
        return true;
    }
}