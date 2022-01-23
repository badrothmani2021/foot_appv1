package aithammou.badr.listview.loginRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import aithammou.badr.listview.Interface.Admin;
import aithammou.badr.listview.Interface.MainActivity;
import aithammou.badr.listview.R;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button loginbtn,gotoRegister;
    boolean valid = true;
    FirebaseAuth fauth ;
    FirebaseFirestore fstore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        email = findViewById(R.id.loginemail);
        password = findViewById(R.id.loginpassword);
        loginbtn = findViewById(R.id.loginbtn);
        gotoRegister = findViewById(R.id.gotoRegister);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(email);
                checkField(password);


                if(valid){
                    fauth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(LoginActivity.this, "Logged in Successfuly.", Toast.LENGTH_SHORT).show();
                            checkUserAccessLevel(authResult.getUser().getUid());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });


        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));

            }
        });




    }

    private void checkUserAccessLevel(String uid) {
        DocumentReference df = fstore.collection("users").document(uid);
        // extract the data from the document
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("TAG", "onSuccess: "+ documentSnapshot.getData());
                // identify the user access level

                //is admin
                if(documentSnapshot.getString("isAdmin") != null){
                    startActivity(new Intent(getApplicationContext(), Admin.class));
                    finish();
                }

                // is user
                if(documentSnapshot.getString("isUser") != null);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
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



    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}


