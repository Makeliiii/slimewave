package com.example.lab33;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView text = (TextView) findViewById(R.id.text);
        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        ImageView img3 = (ImageView) findViewById(R.id.img3);
        ImageView img4 = (ImageView) findViewById(R.id.img4);

        switch (item.getItemId()) {
            case R.id.mammals:
                text.setText("Click on animal to play its' cry!");
                setAll(img1, R.drawable.bear, R.raw.bear);
                setAll(img2, R.drawable.elephant, R.raw.elephant);
                setAll(img3, R.drawable.lamb, R.raw.lamb);
                setAll(img4, R.drawable.wolf, R.raw.wolf);
                return true;
            case R.id.birds:
                text.setText("Click on animal to play its' cry!");
                setAll(img1, R.drawable.huuhkaja, R.raw.huuhkaja_norther_eagle_owl);
                setAll(img2, R.drawable.peippo, R.raw.peippo_chaffinch);
                setAll(img3, R.drawable.peukaloinen, R.raw.peukaloinen_wren);
                setAll(img4, R.drawable.punatulkku, R.raw.punatulkku_northern_bullfinch);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setAll(ImageView img, int imgID, int cryID) {
        final MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(this, cryID);
        img.setImageResource(imgID);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
    }
}
