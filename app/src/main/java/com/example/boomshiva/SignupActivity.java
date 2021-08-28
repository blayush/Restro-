package com.example.boomshiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.dhaval2404.imagepicker.ImagePicker;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignupActivity extends AppCompatActivity {
    TextView uploadTextButton;
    CircleImageView uploadImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uploadTextButton =findViewById(R.id.uploadTextView);
        uploadImage=findViewById(R.id.profile_image);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        uploadTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(SignupActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

    }
}