package com.example.jsonparserexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(MainActivity.EXTRA_URL);
        String creatorName = intent.getStringExtra(MainActivity.EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(MainActivity.EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);

        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewLikes.setText("Likes: " + likeCount);
    }
}