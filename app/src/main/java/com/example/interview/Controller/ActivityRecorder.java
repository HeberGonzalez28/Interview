package com.example.interview.Controller;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.android.volley.RequestQueue;
import com.example.interview.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityRecorder extends AppCompatActivity {

    ImageView picture;
    Button btntakefoto, btnguardar;
    ImageButton btnplay, btnrecord, btndetener;
    EditText description, periodista, fecha;
    MediaRecorder grabacion;
    String archivo=null;
    String currentPhotoPath=null;
    MediaPlayer mediaPlayer;
    SeekBar seekbar;

    static final int REQUEST_IMAGE = 101;
    static final int ACCESS_CAMERA =  201;

    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);

        picture = findViewById(R.id.imageView);
        Bitmap image;

        btntakefoto = findViewById(R.id.btn_foto);
        btnguardar = findViewById(R.id.btnguardar);

        btnplay = findViewById(R.id.ibtnplay);
        btnrecord = findViewById(R.id.ibtnrecord);
        btndetener = findViewById(R.id.ibtndete);

        description = findViewById(R.id.txtdescripcion);
        periodista = findViewById(R.id.txtperiodista);
        fecha = findViewById(R.id.txtfecha);

        seekbar = findViewById(R.id.seekBar);
        seekbar.setEnabled(false);
        
        btntakefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permisos();
            }
        });
        
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendData();
            }
        });
    }

    private void SendData() {
    }

    private void permisos() {
        if(ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA},ACCESS_CAMERA);
        }
        else
        {
            dispatchTakePictureIntent();

        }

    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                ex.toString();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.interview.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE);
            }
        }
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE)
        {
            try {
                File Foto = new File(currentPhotoPath);
                picture.setImageURI(Uri.fromFile(Foto));
            }
            catch (Exception ex)
            {
                ex.toString();
            }
        }
    }

}