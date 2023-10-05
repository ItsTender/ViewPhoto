package com.tawfeeq.viewphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button BSI;

    ImageView ImageView;

    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BSI=findViewById(R.id.btnimg);
        ImageView=findViewById(R.id.Previewimage);
        BSI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageChooser();
            }
        });


    }
    private void ImageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Select Picture"),SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent Data){
        super.onActivityResult(requestCode,resultCode,Data);

        if(resultCode == RESULT_OK){
            if(resultCode== SELECT_PICTURE){
                Uri SIuri = Data.getData();
                if(null != SIuri){
                    ImageView.setImageURI(SIuri);
                }
            }

        }
    }
}