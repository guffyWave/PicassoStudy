package com.gufran.picassostudy;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoTools;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    File file;
    Picasso picasso;
    String imageURL1 = "http://www.hespress.com/thumbnail.php?file=kiosque1_855989950.jpg&size=article_medium";
    String imageURL2 = "https://t1.hespress.com/cache/thumbnail/article_medium/kiosque1_855989950.jpg";
    String imageURL3 = "http://en.tintin.com/images/tintin/actus/actus/004465/boutique-tintin.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        File path = Environment.getExternalStorageDirectory();
        file = new File(path, "img.jpg");
        picasso = Picasso.with(getApplicationContext());

    }

    public void showImage(View v) {
//        File path = Environment.getExternalStorageDirectory();
//        file = new File(path, "img.jpg");


        picasso.setLoggingEnabled(true);
        picasso.setIndicatorsEnabled(true);
        picasso.load(imageURL3)
                .into(imageView);
    }

    public void showFile(View v) {
        File path = Environment.getExternalStorageDirectory();
        file = new File(path, "img.jpg");
        picasso.setLoggingEnabled(true);
        picasso.setIndicatorsEnabled(true);
        picasso.load(file)
                .into(imageView);
    }

    public void showFileTransform(View v) {
        File path = Environment.getExternalStorageDirectory();
        file = new File(path, "img.jpg");
        picasso.setLoggingEnabled(true);
        picasso.setIndicatorsEnabled(true);
        picasso.load(file).transform(new BitmapTransform(100, 100))
                .centerInside()
                .into(imageView);
    }

    //

    public void removeImage(View v) {
        PicassoTools.clearCache(Picasso.with(MainActivity.this));
    }


    //        Picasso.with(MainActivity.this).load(file).error(R.mipmap.ic_launcher).
//                into(imageView);

//        Picasso.with(MainActivity.this).load("http://en.tintin.com/images/tintin/actus/actus/004465/boutique-tintin.jpg").error(R.mipmap.ic_launcher).
//                into(imageView);


//        Picasso.with(MainActivity.this)
//                .load("http://en.tintin.com/images/tintin/actus/actus/004465/boutique-tintin.jpg")
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(imageView);
}
