package com.dicoding.moviecatalogue.activities;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.moviecatalogue.R;
import com.dicoding.moviecatalogue.adapter.MovieAdapter;
import com.dicoding.moviecatalogue.models.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lv_list)
    ListView lvList;
    private String[] title;
    private String[] director;
    private String[] cast;
    private String[] sinopsis;
    private String[] releaseDate;
    private String[] genre;
    private String[] duration;
    private String[] trailer;
    private String[] rating;
    private TypedArray thumbnail;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new MovieAdapter(this);
        lvList.setAdapter(adapter);

        prepare();
        addItem();
        detailIntent();

    }


    private void prepare() {
        title = getResources().getStringArray(R.array.title);
        cast = getResources().getStringArray(R.array.cast);
        director = getResources().getStringArray(R.array.director);
        genre = getResources().getStringArray(R.array.genre);
        sinopsis = getResources().getStringArray(R.array.sinopsis);
        duration = getResources().getStringArray(R.array.duration);
        releaseDate = getResources().getStringArray(R.array.release_date);
        trailer = getResources().getStringArray(R.array.trailer);
        rating = getResources().getStringArray(R.array.rating);
        thumbnail = getResources().obtainTypedArray(R.array.thumbnail);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Movie movie = new Movie();
            movie.setThumbnail(thumbnail.getResourceId(i, -1));
            movie.setTitle(title[i]);
            movie.setCast(cast[i]);
            movie.setDirector(director[i]);
            movie.setDuration(duration[i]);
            movie.setGenre(genre[i]);
            movie.setRating(rating[i]);
            movie.setReleaseDate(releaseDate[i]);
            movie.setSinopsis(sinopsis[i]);
            movie.setTrailer(trailer[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void detailIntent(){
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                //startActivity(new Intent(getApplicationContext(), DetailMovieActivity.class));
                Movie movie = new Movie();
                movie.setTitle(movies.get(i).getTitle());
                movie.setCast(movies.get(i).getCast());
                movie.setDirector(movies.get(i).getDirector());
                movie.setDuration(movies.get(i).getDuration());
                movie.setGenre(movies.get(i).getGenre());
                movie.setRating(movies.get(i).getRating());
                movie.setReleaseDate(movies.get(i).getReleaseDate());
                movie.setSinopsis(movies.get(i).getSinopsis());
                movie.setTrailer(movies.get(i).getTrailer());
                movie.setThumbnail(movies.get(i).getThumbnail());

                Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.MOVIE, movie);
                startActivity(intent);
            }
        });
    }
}
