package aithammou.badr.listview.Interface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import aithammou.badr.listview.R;

public class Search extends AppCompatActivity {

    BottomNavigationView viewbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        viewbar = findViewById(R.id.bottomnavigationview);
        viewbar.setBackground(null);
        viewbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:{
                        Intent i = new Intent(Search.this,MainActivity.class);
                        startActivity(i);

                        return false;
                    }
                    case R.id.chat:{
                        Intent i = new Intent(Search.this,Chat.class);
                        startActivity(i);

                        return false;
                    }

                    case R.id.profile:{
                        Intent i = new Intent(Search.this,Profile.class);
                        startActivity(i);

                        return false;
                    }


                }
                return false;
            }
        });

    }
}