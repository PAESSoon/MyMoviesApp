package com.example.mymovies;

import static com.example.mymovies.MainActivity.movies_array;
import static com.example.mymovies.MovieListFragment.movieSelected;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PosterFragment extends Fragment {

    static PosterFragment posterFragment;
    static ImageView posterImg;
    static Movie my_current_movie = null;
    static PagerAdapter m_pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poster, container, false);
        posterImg = view.findViewById(R.id.imageView);

        if(my_current_movie == null) {
            String loveActuallyTitle = getResources().getString(R.string.love_actually_title);
            String loveActuallyDirectors = getResources().getString(R.string.love_actually_director);
            String loveActuallyActors = getResources().getString(R.string.love_actually_stars);
            String loveActuallyTrailer = getResources().getString(R.string.love_actually_trailer);
            my_current_movie = new Movie(loveActuallyTitle, R.drawable.love_actually, R.string.love_actually_description, loveActuallyDirectors, loveActuallyActors, loveActuallyTrailer);
        }

        posterImg.setImageResource(my_current_movie.getImage());

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

    //    always guarantee that there is only 1 posterFragment
    public static PosterFragment getInstance() {
        if(posterFragment == null) {
            Log.d("PosterFragment", "is null");
            return new PosterFragment();
        } else {
            Log.d("PosterFragment", "is not null");
            return posterFragment;
        }
    }
}