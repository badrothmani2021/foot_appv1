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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import aithammou.badr.listview.CustomAdapter.PostAdapter;
import aithammou.badr.listview.Sqllitte.DatabaseAdapter;
import aithammou.badr.listview.Model.Post;
import aithammou.badr.listview.R;
import aithammou.badr.listview.loginRegister.LoginActivity;


public class MainActivity extends AppCompatActivity {


    ArrayList<Post> listpost = new ArrayList<>();
    BottomNavigationView viewbar;
    ListView listview;
    DatabaseAdapter databaseAdapter;
    FloatingActionButton addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //----------------calling precreatedb class and database adapter-------------------

     /*   PreCreateDB.copyDB(this);
        databaseAdapter = new DatabaseAdapter(this);
        ListView listpost = findViewById(R.id.listpost);
        final SimpleCursorAdapter simpleCursorAdapter = databaseAdapter.populateListViewFromDb();
        listpost.setAdapter(simpleCursorAdapter);
        listpost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) simpleCursorAdapter.getItem(position);
                String name = cursor.getString(1);
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });*/


        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    //-----------------------------------------------------------------------

        // pour ajouter l'objet post
//        addPost();

        PostAdapter adapter = new PostAdapter(this,listpost);
        // list view
        listview = findViewById(R.id.listpost);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();





    //-------------------------------------------------------------------

        addbtn = findViewById(R.id.add_button);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UploadPost.class));
                finish();
            }
        });


        // bottom navbar
        viewbar = findViewById(R.id.bottomnavigationview);
        viewbar.setBackground(null);
        viewbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){

                        case R.id.searh:{
                            Intent i = new Intent(MainActivity.this,Search.class);
                            startActivity(i);

                            return false;
                        }

                        case R.id.profile:{
                            Intent i = new Intent(MainActivity.this,Profile.class);
                            startActivity(i);

                            return false;
                        }
                        case R.id.chat:{
                            Intent i = new Intent(MainActivity.this,Chat.class);
                            startActivity(i);

                            return false;
                        }

                    }
                return false;
            }
        });


        //----------------------------------------------------------------




    }


    //--------------------------------------------------------------------
    // C'EST LA METHODE QUI NOUS PERMET D'AJOUTER UN POST
/*   private void addPost() {


        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20"));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20"));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20"));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20"));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20"));


    }*/



}