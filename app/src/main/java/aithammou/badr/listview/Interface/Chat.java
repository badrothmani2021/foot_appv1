package aithammou.badr.listview.Interface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import aithammou.badr.listview.CustomAdapter.ChatAdapter;
import aithammou.badr.listview.R;
import aithammou.badr.listview.Model.User;
import aithammou.badr.listview.loginRegister.LoginActivity;

public class Chat extends AppCompatActivity {

    ArrayList<User> listchat = new ArrayList<>();
    BottomNavigationView viewbar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat);

        Button logout = findViewById(R.id.logoutBtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

       addUserChat();

        ChatAdapter adapter = new ChatAdapter(this,listchat);

        // listviewchat
    /*    listView = findViewById(R.id.list_view_chat);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();*/


        // bottom navbar
        viewbar = findViewById(R.id.bottomnavigationview);
        viewbar.setBackground(null);
        viewbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:{
                        Intent i = new Intent(Chat.this,MainActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.profile:{
                        Intent i = new Intent(Chat.this,Profile.class);
                        startActivity(i);

                        return false;
                    }


                }
                return false;
            }
        });

    }

    private void  addUserChat(){

        listchat.add(new User("ait hammou","heeey , how are uuuu"));
        listchat.add(new User("abd ssamad","aa fin wsselto f dak lprojet"));
        listchat.add(new User("badr cherhoun","a fffeeen akha samati"));
        listchat.add(new User("badr bahadou","heeeey ,liiibraaa is ggoooooooood"));



    }




}