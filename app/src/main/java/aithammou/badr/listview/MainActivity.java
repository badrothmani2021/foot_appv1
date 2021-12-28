package aithammou.badr.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import aithammou.badr.listview.CustomAdapter.PostAdapter;
import aithammou.badr.listview.Fragments.ChatFragment;
import aithammou.badr.listview.Fragments.HomeFragment;
import aithammou.badr.listview.Fragments.ProfileFragment;
import aithammou.badr.listview.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {


    ArrayList<Post> listpost = new ArrayList<>();
    BottomNavigationView bottomnavigationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnavigationview = findViewById(R.id.bottomnavigationview);
        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.searh:
                        fragment = new SearchFragment();
                        break;

                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.chat:
                        fragment = new ChatFragment();
                        break;

                }

                return true;
            }
        });

        addPost();

        PostAdapter adapter = new PostAdapter(this,listpost);

        ListView listView = findViewById(R.id.listeview);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();




    //-------------------------------------------------------------------

        // pour l'affichage du d'arriere plan du bottom bar
        bottomnavigationview = findViewById(R.id.bottomnavigationview);
        bottomnavigationview.setBackground(null);

        // la on peut ajouter le click listener

    }

    private void addPost() {

        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));
        listpost.add(new Post("POMME DE TERRE","Gratin dauphinois Cyril Lignac","20",2.5));


    }

}