package com.example.mymovies;

import static com.example.mymovies.MovieListFragment.movieSelected;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class YoutubeFragment extends Fragment {

    String key = ""; // youtube API key

    static YoutubeFragment youtubeFragment;
    static Movie my_current_movie = null;
    static PagerAdapter m_pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_youtube, container, false);
        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerSupportFragment.initialize(key, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer,
                    boolean b) {

                if (my_current_movie == null) {
                    youTubePlayer.loadVideo(getResources().getString(R.string.love_actually_trailer));
                } else {
                    String userChoice = my_current_movie.getYouTubeLink();
                    // Log.d("userChoice", userChoice);
                    youTubePlayer.loadVideo(userChoice);
                }

                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                    YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        getFragmentManager().beginTransaction().replace(R.id.youtube_container, youTubePlayerSupportFragment).commit();
        return v;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        m_pagerAdapter = pagerAdapter;
    }

    public void setData(Movie movieSelected) {
        my_current_movie = movieSelected;
        if (m_pagerAdapter != null) {
            m_pagerAdapter.notifyDataSetChanged();
        }
    }

    // always guarantee that there is only 1 YoutubeFragment
    public static YoutubeFragment getInstance() {
        if (youtubeFragment == null) {
            return new YoutubeFragment();
        } else {
            return youtubeFragment;
        }
    }
}