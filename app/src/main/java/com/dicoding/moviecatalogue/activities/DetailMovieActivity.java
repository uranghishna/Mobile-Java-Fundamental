package com.dicoding.moviecatalogue.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.dicoding.moviecatalogue.R;
import com.dicoding.moviecatalogue.models.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String MOVIE = "movie";
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_rating)
    TextView txtRating;
    @BindView(R.id.txt_genre)
    TextView txtGenre;
    @BindView(R.id.txt_director)
    TextView txtDirector;
    @BindView(R.id.txt_cast)
    TextView txtCast;
    @BindView(R.id.txt_duration)
    TextView txtDuration;
    @BindView(R.id.txt_release_date)
    TextView txtReleaseDate;
    @BindView(R.id.btn_trailer)
    CardView btnTrailer;
    @BindView(R.id.img_thumbnail)
    ImageView imgThumbnail;
    @BindView(R.id.txt_sinopsis)
    TextView txtSinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);

        Movie movie = getIntent().getParcelableExtra(MOVIE);
        String title = movie.getTitle();
        String cast = movie.getCast();
        String director = movie.getDirector();
        String sinopsis = movie.getSinopsis();
        String releaseDate = movie.getReleaseDate();
        String duration = movie.getDuration();
        String rating = movie.getRating();
        String genre = movie.getGenre();
        int thumbnail = movie.getThumbnail();

        txtTitle.setText(title);
        txtCast.setText(cast);
        txtDirector.setText(director);
        txtSinopsis.setText(sinopsis);
        txtReleaseDate.setText(releaseDate);
        txtDuration.setText(duration);
        txtRating.setText(rating);
        txtGenre.setText(genre);
        Glide.with(this).load(thumbnail).into(imgThumbnail);

    }


    @OnClick({R.id.btn_back, R.id.btn_trailer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_trailer:
                Movie movie = getIntent().getParcelableExtra(MOVIE);
                String url = movie.getTrailer() ;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
        }
    }
}
