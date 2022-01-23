package aithammou.badr.listview.Interface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import aithammou.badr.listview.R;

public class Profile extends AppCompatActivity {


    BottomNavigationView viewbar;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    TextView profilename,profilenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fauth = FirebaseAuth.getInstance();
        profilename = findViewById(R.id.id_user_name_profile);
        profilenumber = findViewById(R.id.id_user_phone);




        viewbar = findViewById(R.id.bottomnavigationview);
        viewbar.setBackground(null);
        viewbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:{
                        Intent i = new Intent(Profile.this,MainActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.chat:{
                        Intent i = new Intent(Profile.this,Chat.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.searh:{
                        Intent i = new Intent(Profile.this,Search.class);
                        startActivity(i);

                        return false;
                    }


                }
                return false;
            }
        });





    }


    private void checkUserStatus(){
        FirebaseUser user = fauth.getCurrentUser();
        String currentid = user.getUid();
        DocumentReference reference;
        fstore = FirebaseFirestore.getInstance();
        reference = fstore.collection("users").document(currentid);
      reference.get()
              .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                  @Override
                  public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                      if(task.getResult().exists()){
                          String name = task.getResult().getString("FullName");
                          String number = task.getResult().getString("phone");
                          profilename.setText(name);
                          profilenumber.setText(number);
                          //here you can add image and city and other user info

                      }else{
                          Intent intent = new Intent(Profile.this,MainActivity.class);
                          startActivity(intent);
                      }
                  }
              });
    }

    @Override
    protected void onStart() {
        checkUserStatus();
        super.onStart();
    }


}