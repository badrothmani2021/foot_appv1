package aithammou.badr.listview.loginRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.nio.file.FileStore;
import java.util.HashMap;
import java.util.Map;

import aithammou.badr.listview.Interface.MainActivity;
import aithammou.badr.listview.R;

public class Register extends AppCompatActivity {


    EditText fullname,email,password,phone;
    Button registerbtn,gotologin;
    boolean valid = true ;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.Phone);
        registerbtn = findViewById(R.id.registerbtn);
        gotologin = findViewById(R.id.gotologin);


      registerbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              checkField(fullname);
              checkField(email);
              checkField(password);
              checkField(phone);



              if(valid){
                  // start the user registration process
                  fauth.createUserWithEmailAndPassword(
                          email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                      @Override
                      public void onSuccess(AuthResult authResult) {
                          FirebaseUser user = fauth.getCurrentUser();
                          Toast.makeText(Register.this, "Account Create", Toast.LENGTH_SHORT).show();
                          DocumentReference df = fstore.collection("users").document(user.getUid());
                          Map<String,Object> userInfo = new HashMap<>();
                          userInfo.put("FullName",fullname.getText().toString());
                          userInfo.put("useremail",email.getText().toString());
                          userInfo.put("phone",phone.getText().toString());
                          //specify if the user is admin
                          userInfo.put("isUser","1");

                          df.set(userInfo);

                          startActivity(new Intent(getApplicationContext(), MainActivity.class));
                          finish();
                      }


                  }).addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          Toast.makeText(Register.this, "Failed to Create Account", Toast.LENGTH_SHORT).show();
                      }
                  });
              }
          }
      });


        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });


    }



    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }



}