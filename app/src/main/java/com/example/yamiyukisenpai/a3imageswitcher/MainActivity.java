package com.example.yamiyukisenpai.a3imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.Random;

import static android.widget.ImageView.ScaleType.CENTER_INSIDE;
import static android.widget.ImageView.ScaleType.FIT_XY;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher sample_image_switcher, sample_background_image_switcher;
    //Animation in_effect = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
    //Animation out_effect = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
    Button next_button;
    int img_arr[] = {R.drawable.tali_me3, R.drawable.kubuntu_desktop, R.drawable.ts_fearless,
            R.drawable.liara_me3, R.drawable.flash_supergirl};
    Random rand = new Random();
    int curr_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curr_index = 0;
        sample_image_switcher = findViewById(R.id.rand_imageSwitcher);
        sample_image_switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView rand_image = new ImageView(getApplicationContext());
                rand_image.setScaleType(CENTER_INSIDE);
                return rand_image;
            }
        });
        sample_image_switcher.setImageResource(img_arr[curr_index]);
        sample_image_switcher.setInAnimation
                (AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        //sample_image_switcher.setInAnimation
                //(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        // Something that can be done at another time
        /*sample_background_image_switcher = findViewById(R.id.rand_back_imageSwitcher);
        sample_background_image_switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView rand_image_back = new ImageView(getApplicationContext());
                rand_image_back.setScaleType(FIT_XY);
                return rand_image_back;
            }
        });
        sample_background_image_switcher.setImageResource(img_arr[curr_index]);*/

        next_button = findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int new_index = curr_index;
                while (new_index == curr_index) {
                    curr_index = rand.nextInt(img_arr.length);
                }
                //sample_background_image_switcher.setImageResource(img_arr[curr_index]);
                sample_image_switcher.setImageResource(img_arr[curr_index]);
            }
        });


    }
}
