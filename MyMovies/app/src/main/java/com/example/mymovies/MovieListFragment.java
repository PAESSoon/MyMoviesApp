package com.example.mymovies;

import static com.example.mymovies.MainActivity.genre;
import static com.example.mymovies.MainActivity.movies_array;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    static MovieListFragment movieListFragment;
    ArrayList<String> movieTitle = new ArrayList<>();
    ListView myListView;
    static Movie movieSelected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        Log.d("MovieListViewcreated", "MovieListViewcreated");

        movieTitle.addAll(Arrays.asList(movies_array));

        myListView = view.findViewById(R.id.my_list);

        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), R.layout.act_movie_list_view, R.id.item_name, movieTitle);

        this.setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        this.getListView().setOnItemClickListener(this);

//      highlight first item in list on initialization
        this.getListView().setItemChecked(0, true);
        this.getListView().requestFocusFromTouch();
        this.getListView().setSelected(true);

//        Log.d("item at position 0", this.getListView().getItemAtPosition(0) + "");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        view.setSelected(true);

        if(movieTitle.get(i).equals(getResources().getString(R.string.love_actually_title))) {
            String loveActuallyTitle = getResources().getString(R.string.love_actually_title);
            String loveActuallyDirectors = getResources().getString(R.string.love_actually_director);
            String loveActuallyActors = getResources().getString(R.string.love_actually_stars);
            String loveActuallyTrailer = getResources().getString(R.string.love_actually_trailer);
            movieSelected = new Movie(loveActuallyTitle, R.drawable.love_actually, R.string.love_actually_description, loveActuallyDirectors, loveActuallyActors, loveActuallyTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.friends_title))) {
            String friendsTitle = getResources().getString(R.string.friends_title);
            String friendsDirectors = getResources().getString(R.string.friends_director);
            String friendsActors = getResources().getString(R.string.friends_stars);
            String friendsTrailer = getResources().getString(R.string.friends_trailer);
            movieSelected = new Movie(friendsTitle, R.drawable.friends, R.string.friends_description, friendsDirectors, friendsActors, friendsTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Pikachu_title))) {
            String pikachuTitle = getResources().getString(R.string.Pikachu_title);
            String pikachuDirectors = getResources().getString(R.string.Pikachu_director);
            String pikachuActors = getResources().getString(R.string.Pikachu_stars);
            String pikachuTrailer = getResources().getString(R.string.Pikachu_trailer);
            movieSelected = new Movie(pikachuTitle, R.drawable.detective_pikachu, R.string.Pikachu_description, pikachuDirectors, pikachuActors, pikachuTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Free_Guy_title))) {
            String freeGuyTitle = getResources().getString(R.string.Free_Guy_title);
            String freeGuyDirectors = getResources().getString(R.string.Free_Guy_director);
            String freeGuyActors = getResources().getString(R.string.Free_Guy_stars);
            String freeGuyTrailer = getResources().getString(R.string.Free_Guy_trailer);
            movieSelected = new Movie(freeGuyTitle, R.drawable.free_guy, R.string.Free_Guy_description, freeGuyDirectors, freeGuyActors, freeGuyTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Bridget_Jones_title))) {
            String BridgetJonesTitle = getResources().getString(R.string.Bridget_Jones_title);
            String bridgetJonesDirectors = getResources().getString(R.string.Bridget_Jones_director);
            String bridgetJonesActors = getResources().getString(R.string.Bridget_Jones_stars);
            String bridgetJonesTrailer = getResources().getString(R.string.Bridget_Jones_trailer);
            movieSelected = new Movie(BridgetJonesTitle, R.drawable.bridget_jones_diary, R.string.Bridget_Jones_description, bridgetJonesDirectors, bridgetJonesActors, bridgetJonesTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Sing_title))) {
            String singTitle = getResources().getString(R.string.Sing_title);
            String singDirectors = getResources().getString(R.string.Sing_director);
            String singActors = getResources().getString(R.string.Sing_stars);
            String singTrailer = getResources().getString(R.string.Sing_trailer);
            movieSelected = new Movie(singTitle, R.drawable.sing, R.string.Sing_description, singDirectors, singActors, singTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Just_Go_title))) {
            String justGoTitle = getResources().getString(R.string.Just_Go_title);
            String justGoDirectors = getResources().getString(R.string.Just_Go_director);
            String justGoActors = getResources().getString(R.string.Just_Go_stars);
            String justGoTrailer = getResources().getString(R.string.Just_Go_trailer);
            movieSelected = new Movie(justGoTitle, R.drawable.just_go_with_it, R.string.Just_Go_description, justGoDirectors, justGoActors, justGoTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Infinity_War_title))) {
            String infinityWarTitle = getResources().getString(R.string.Infinity_War_title);
            String infinityWarDirectors = getResources().getString(R.string.Infinity_War_director);
            String infinityWarActors = getResources().getString(R.string.Infinity_War_stars);
            String infinityWarTrailer = getResources().getString(R.string.Infinity_War_trailer);
            movieSelected = new Movie(infinityWarTitle, R.drawable.infinity_war, R.string.Infinity_War_description, infinityWarDirectors, infinityWarActors, infinityWarTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.No_Time_To_Die_title))) {
            String bondTitle = getResources().getString(R.string.No_Time_To_Die_title);
            String bondDirectors = getResources().getString(R.string.No_Time_To_Die_director);
            String bondActors = getResources().getString(R.string.No_Time_To_Die_stars);
            String bondTrailer = getResources().getString(R.string.No_Time_To_Die_trailer);
            movieSelected = new Movie(bondTitle, R.drawable.no_time_to_die, R.string.No_Time_To_Die_description, bondDirectors, bondActors, bondTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Sonic_title))) {
            String sonicTitle = getResources().getString(R.string.Sonic_title);
            String sonicDirectors = getResources().getString(R.string.Sonic_director);
            String sonicActors = getResources().getString(R.string.Sonic_stars);
            String sonicTrailer = getResources().getString(R.string.Sonic_trailer);
            movieSelected = new Movie(sonicTitle, R.drawable.sonic, R.string.Sonic_description, sonicDirectors, sonicActors, sonicTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Cruella_title))) {
            String cruellaTitle = getResources().getString(R.string.Cruella_title);
            String cruellaDirectors = getResources().getString(R.string.Cruella_director);
            String cruellaActors = getResources().getString(R.string.Cruella_stars);
            String cruellaTrailer = getResources().getString(R.string.Cruella_trailer);
            movieSelected = new Movie(cruellaTitle, R.drawable.cruella, R.string.Cruella_description, cruellaDirectors, cruellaActors, cruellaTrailer);

        } else if(movieTitle.get(i).equals(getResources().getString(R.string.Parasite_title))) {
            String parasiteTitle = getResources().getString(R.string.Parasite_title);
            String parasiteDirectors = getResources().getString(R.string.Parasite_director);
            String parasiteActors = getResources().getString(R.string.Parasite_stars);
            String parasiteTrailer = getResources().getString(R.string.Parasite_trailer);
            movieSelected = new Movie(parasiteTitle, R.drawable.parasite, R.string.Parasite_description, parasiteDirectors, parasiteActors, parasiteTrailer);

        } else {
            String starIsBornTitle = getResources().getString(R.string.A_Star_Is_Born_title);
            String starIsBornDirectors = getResources().getString(R.string.A_Star_Is_Born_director);
            String starIsBornActors = getResources().getString(R.string.A_Star_Is_Born_stars);
            String starIsBornTrailer = getResources().getString(R.string.A_Star_Is_Born_trailer);
            movieSelected = new Movie(starIsBornTitle, R.drawable.a_star_is_born, R.string.A_Star_Is_Born_description, starIsBornDirectors, starIsBornActors, starIsBornTrailer);

        }

        try{

            PosterFragment posterFragment = PosterFragment.getInstance();
            posterFragment.setData(movieSelected);

            DescriptionFragment descriptionFragment = DescriptionFragment.getInstance();
            descriptionFragment.setData(movieSelected);

            YoutubeFragment youtubeFragment = YoutubeFragment.getInstance();
            youtubeFragment.setData(movieSelected);

        } catch(Exception e) {
            Log.e("Exception in onItemClick", e.toString());
        }


    }

    //    always guarantee that there is only 1 movieListFragment
    public static MovieListFragment getInstance() {
        if(movieListFragment == null) {
            return new MovieListFragment();
        } else {
            return movieListFragment;
        }
    }

}