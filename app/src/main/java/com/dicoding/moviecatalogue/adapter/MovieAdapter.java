package com.dicoding.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.moviecatalogue.R;
import com.dicoding.moviecatalogue.models.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return view;
    }

    class ViewHolder {

        @BindView(R.id.img_thumnail)
        ImageView imgThumbnail;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_rating)
        TextView txtRating;
        @BindView(R.id.txt_sinopsis)
        TextView txtSinopsis;
        @BindView(R.id.txt_director)
        TextView txtDirector;
        @BindView(R.id.txt_cast)
        TextView txtCast;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


        void bind(Movie hero) {
            txtTitle.setText(hero.getTitle());
            txtRating.setText(hero.getRating());
            txtCast.setText(hero.getCast());
            txtDirector.setText(hero.getDirector());
            txtSinopsis.setText(hero.getSinopsis().substring(0,65) + "...");
            imgThumbnail.setImageResource(hero.getThumbnail());
        }
    }

}
