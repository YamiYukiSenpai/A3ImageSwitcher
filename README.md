# A3ImageSwitcher
Assignment 3 for CENG319 (Software Project)

![Demo](.readme_src/demo.gif)

## Introduction
The purpose of the ImageSwitcher widget is to switch between 2 ImageViews. 

## History
The widget has been in Android SDK since API level 1 (Android 1.0).  The package library the component is under is  `android.widget`

## Major methods & attrubutes
* `setFactory(ViewSwitcher.ViewFactory factory)`
    * sets up the factory that creates 2 ImageViews that the ImageSwitcher will flip
    * From `ViewSwitcher`
* `setImageResource(int resid)`
    * sets a new image on the ImageSwitcher with the provided resource ID

## An example project
This repository is also an Android project that can be run on Android Studio.  Simply run `git clone https://github.com/YamiYukiSenpai/A3ImageSwitcher.git` to download this to your PC, and load the project in Android Studio.

### 1. Setting up ImageSwitcher in your activity's XML file
In `res/layout/activity_main.xml` (or whichever activity you want to place your ImageSwitcher), add this entry under any layout you choose:

        <ImageSwitcher
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/rand_imageSwitcher">
        </ImageSwitcher>
You can also add a button to flip to next image.

### 2. Upload images you want to use in the switcher
Paste them under `$PROJECT_DIR/app/src/main/res/drawable/`<sup>1</sup>

### 3. Setting up basic ImageSwitcher in your activity's Java file
#### 1. Create an array of images with `int` variable.
`setImageResource()` method uses an integer as its argument.

Example:

        int img_arr[] = {R.drawable.img1, R.drawable.img2,...};

#### 2. Enabling ImageSwitcher
In `MainActivity.java`, under onCreate class, add these lines to enable a basic image switcher:

        int curr_index = 0;
        sample_image_switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView rand_image = new ImageView(getApplicationContext());
                rand_image.setScaleType(CENTER_INSIDE);
                return rand_image;
            }
        });
        sample_image_switcher.setImageResource(img_arr[curr_index]);

### 4. Cycling to another image with a button
With a button, we can cycle to the next image with a random number generator.  I have enabled a loop that makes sure that we're not gonna flip to the same image.
This `curr_index` value can be incremented if you wish it so.  Just make sure that it won't bring you out of bounds.

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int new_index = curr_index;  // curr_index is initally 0
                while (new_index == curr_index) {
                    curr_index = rand.nextInt(img_arr.length);
                }
                //sample_background_image_switcher.setImageResource(img_arr[curr_index]);
                sample_image_switcher.setImageResource(img_arr[curr_index]);
            }
        });

# References
1. [Android Studio](https://developer.android.com/reference/android/widget/ImageSwitcher)
2. [TutorialsPoint](https://www.tutorialspoint.com/android/android_imageswitcher.htm)

## Note:
1. `$PROJECT_DIR` is your project's directory where `app/`, `gradle/` directories are in.
