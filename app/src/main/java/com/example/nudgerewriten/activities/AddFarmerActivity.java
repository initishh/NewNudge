package com.example.nudgerewriten.activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nudgerewriten.R;

import java.io.File;
import java.io.IOException;


public class AddFarmerActivity extends AppCompatActivity {

    ImageView cameraBtn, farmerImg, backBtn2;
    EditText farmerName, farmerNo1, farmerNo2, farmerAdd;
    Toolbar toolbar;
    Uri img_uri;
    ProgressBar geoPb;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    boolean gotLocation = false;

    double longitude = 0.0;
    double latitude = 0.0;

    LocationManager locationManager;

    public boolean validLatLng(double lat, double lng) {
        if (lat != 0.0 && lng != 0.0) {
            this.gotLocation = true;
            return true;
        } else return false;
    }

    public boolean haveLocation() {
        return this.gotLocation;
    }

    // CHECK PERMISSION FOR LOCATION

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("The App wants your location.")
                        .setMessage("Turn on GPS!")
                        .setPositiveButton("Give Permission.", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(AddFarmerActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //Request location updates:
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farmer);

        cameraBtn = findViewById(R.id.camera_btn);
        farmerImg = findViewById(R.id.farmer_img);

        farmerName = findViewById(R.id.farmer_name);
        farmerAdd = findViewById(R.id.farmer_add);
        farmerNo1 = findViewById(R.id.farmer_no_1);
        farmerNo2 = findViewById(R.id.farmer_no_2);
        backBtn2 = findViewById(R.id.back_btn2);

        geoPb = findViewById(R.id.geo_pb);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        checkLocationPermission();

        toolbar = findViewById(R.id.toolbar_farmer_add);

        toolbar.inflateMenu(R.menu.farmer_add_menu);
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.actions_add) {
                    Toast.makeText(AddFarmerActivity.this, "Adding farmer", Toast.LENGTH_SHORT).show();
                    return true;
                } else return false;
            }
        });

        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.farmer_add_menu, menu);
        return true;
    }

    public void captureImage() {

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};


        AlertDialog.Builder builder = new AlertDialog.Builder(AddFarmerActivity.this);

        builder.setTitle("Add Photo!");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, 1);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }

        });

        builder.show();

    }


    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 1) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                farmerImg.setImageBitmap(photo);

            } else if (requestCode == 2) {
                img_uri = data.getData();
                farmerImg.setImageURI(img_uri);
            }

            // Create a criteria object to retrieve provider
            Criteria criteria = new Criteria();

            // Get the name of the best provider
            String provider = locationManager.getBestProvider(criteria, true);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                checkLocationPermission();
                return;
            }
            Toast.makeText(this, "Geo-tagging the image.", Toast.LENGTH_LONG).show();
            locationManager.requestLocationUpdates(provider, 1000, 0.0f, mLocationListener); // (String) provider, time in milliseconds when to check for an update, distance to change in coordinates to request an update, LocationListener.
        }
    }

    LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged (Location location){
            Log.i("Success","Somewhat.");
            if (!haveLocation() && validLatLng(location.getLatitude(), location.getLongitude())) {
                // Stops the new update requests.
                locationManager.removeUpdates(mLocationListener);
                longitude = location.getLongitude();
                latitude = location.getLatitude();

                Toast.makeText(getApplicationContext(), "Image Successfully Geo-tagged.", Toast.LENGTH_SHORT).show();
            }
        }

        public void onStatusChanged(java.lang.String s, int i, android.os.Bundle bundle) {
        }

        public void onProviderEnabled(java.lang.String s){
        }

        public void onProviderDisabled(java.lang.String s){
            Log.i("Success","Problem");
        }

    };
}
