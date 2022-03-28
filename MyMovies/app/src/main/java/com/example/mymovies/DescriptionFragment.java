package com.example.mymovies;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionFragment extends Fragment {

    static DescriptionFragment descriptionFragment;
    static TextView tv_display, descriptionText, directorText, directorName, starsText, starName;
    static Movie my_current_movie = null;
    static PagerAdapter m_pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        tv_display = view.findViewById(R.id.youtube_title);
        descriptionText = view.findViewById(R.id.description_text);
        directorName = view.findViewById(R.id.director_name);
        starName = view.findViewById(R.id.stars_names);

//        Log.d("DescriptionViewcreated", "DescriptionViewcreated");

        if(my_current_movie == null) {
            String loveActuallyTitle = getResources().getString(R.string.love_actually_title);
            String loveActuallyDirectors = getResources().getString(R.string.love_actually_director);
            String loveActuallyActors = getResources().getString(R.string.love_actually_stars);
            String loveActuallyTrailer = getResources().getString(R.string.love_actually_trailer);
            my_current_movie = new Movie(loveActuallyTitle, R.drawable.love_actually, R.string.love_actually_description, loveActuallyDirectors, loveActuallyActors, loveActuallyTrailer);
        }
            tv_display.setText(my_current_movie.getTitle());
            descriptionText.setText(my_current_movie.getDescription());
            directorName.setText(my_current_movie.getDirectors());
            starName.setText(my_current_movie.getActors());

        return view;
    }

    public void setData(Movie movieSelected) {
        my_current_movie = movieSelected;
        if(m_pagerAdapter != null) {
            m_pagerAdapter.notifyDataSetChanged();
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        m_pagerAdapter = pagerAdapter;
    }

    //    always guarantee that there is only 1 descriptionFragment
    public static DescriptionFragment getInstance() {
        if(descriptionFragment == null) {
            return new DescriptionFragment();
        } else {
            return descriptionFragment;
        }
    }
}