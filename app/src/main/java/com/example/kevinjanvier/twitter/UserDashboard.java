package com.example.kevinjanvier.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import io.fabric.sdk.android.Fabric;

public class UserDashboard extends AppCompatActivity {

    //Image Loader object
    private ImageLoader imageLoader;

    //NetworkImageView Ojbect
    private NetworkImageView profileImage;

    //TextView object
    private TextView textViewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_user_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Initializing views
        profileImage = (NetworkImageView) findViewById(R.id.profileImage);
        textViewUsername = (TextView) findViewById(R.id.textViewUsername);

        //Getting the intent
        Intent intent = getIntent();

        //Getting values from intent
        String username = intent.getStringExtra(MainActivity.KEY_USERNAME);
        String profileImageUrl = intent.getStringExtra(MainActivity.KEY_PROFILE_IMAGE_URL);

        //Loading image
        imageLoader = CustomVolleyRequest.getInstance(this).getImageLoader();
        imageLoader.get(profileImageUrl, ImageLoader.getImageListener(profileImage, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        profileImage.setImageUrl(profileImageUrl, imageLoader);

        //Setting the username in textview
        textViewUsername.setText("@"+username);
    }

}