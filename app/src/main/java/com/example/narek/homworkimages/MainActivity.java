package com.example.narek.homworkimages;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String PATH2 = "/storage/sdcard1/Download/IMG__20160239__051216.png";
    private final String PATH3 = "/storage/sdcard1/Download/IMG__20160239__051251.jpg";
    private final String PATH = "/storage/sdcard1/Q73A8611.JPG";
    ImageView image;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView current = null;
    private DrawView drawView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        image = (ImageView) findViewById(R.id.image_view);
        image1 = (ImageView) findViewById(R.id.image_view1);
        image2 = (ImageView) findViewById(R.id.image_view2);
        image3 = (ImageView) findViewById(R.id.image);

        drawView = (DrawView) findViewById(R.id.draw_view);
            new LoadTask(image).execute(PATH2);
            new LoadTask(image1).execute(PATH);
            new LoadTask(image2).execute(PATH3);
            new LoadTask(image3).execute(PATH3);






        image.setOnClickListener(this);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.image_view:
                if (image != current && current == null) {

                    current = image;

                    drawView.animateImage(image, true);

                } else if(current ==image) {
                    drawView.animateImageBack(image);
                    current = null;
                }

                break;
            case R.id.image_view1:
                if (image1 != current && current == null) {

                    current = image1;

                    drawView.animateImage(image1, true);

                } else if(current ==image1) {
                    drawView.animateImageBack(image1);
                    current = null;
                }


                break;
            case R.id.image_view2:
                if (image2 != current && current == null) {
                    current = image2;

                    drawView.animateImage(image2, false);

                } else if(current ==image2) {
                    drawView.animateImageBack(image2);
                    current = null;
                }


                break;
            case R.id.image:
                if (image3 != current && current == null) {

                    drawView.animateImage(image3, false);
                    current = image3;

                } else if (current == image3) {
                    drawView.animateImageBack(image3);
                    current = null;
                }


                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.about:
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);

                return true;
            case R.id.settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
