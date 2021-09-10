package com.example.boomshiva;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boomshiva.Models.Users;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignupActivity extends AppCompatActivity {
    TextView uploadTextButton;
    CircleImageView uploadImage;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    Button registerButton;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextName;
    EditText editTextPhoneNo;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        registerButton=findViewById(R.id.loginButton);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail=findViewById(R.id.editTextemail);
        editTextPassword=findViewById(R.id.editTextPassword);
        uploadTextButton =findViewById(R.id.uploadTextView);
        progressDialog=new ProgressDialog(SignupActivity.this);
        progressDialog.setTitle("Registering you..");
        progressDialog.setMessage("Wait till registration finishes!");
        uploadImage=findViewById(R.id.profile_image);
        database = FirebaseDatabase.getInstance("https://boomshiva-9a7eb-default-rtdb.firebaseio.com/");
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        uploadTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImagePicker.with(SignupActivity.this)
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                       // .galleryOnly()
                        .crop()

                        .start();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                mAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(),editTextPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Users users=new Users(editTextName.getText().toString(),editTextEmail.getText().toString(),editTextPassword.getText().toString(),editTextPhoneNo.getText().toString());
                           String id=task.getResult().getUser().getUid();
                           database.getReference().child("Users").child(id).setValue(users);
                            Toast.makeText(SignupActivity.this, "Registered Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(SignupActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri=data.getData();
        uploadImage.setImageURI(uri);
    }
}