package com.profile.workmanger;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerView recyclerView;
    SongAdapter adapter;
    List<SongList> songLists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setuptoolbar();
        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new SongAdapter(this,songLists);
        recyclerView.setAdapter(adapter);
        setupdata();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView= (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void setuptoolbar(){
        drawerLayout=findViewById(R.id.draw);
        toolbar=findViewById(R.id.toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
    public  void setupdata(){
        SongList songList=new SongList(R.drawable.circleimage,"waseem");
        songLists.add(songList);
        SongList songList1=new SongList(R.drawable.circleimage,"haider");
        songLists.add(songList1);
        SongList songList2=new SongList(R.drawable.circleimage,"Rizwan");
        songLists.add(songList2);
        SongList songList3=new SongList(R.drawable.circleimage,"Karmat");
        songLists.add(songList3);
        SongList songList4=new SongList(R.drawable.circleimage,"Faisal");
        songLists.add(songList4);
        SongList songList5=new SongList(R.drawable.circleimage,"Rashid");
        songLists.add(songList5);
        SongList songList6=new SongList(R.drawable.circleimage,"Allhah Rakha");
        songLists.add(songList6);
        SongList songList7=new SongList(R.drawable.circleimage,"Tanveer");
        songLists.add(songList7);
        SongList songList8=new SongList(R.drawable.circleimage,"Ali");
        songLists.add(songList8);
        SongList songList9=new SongList(R.drawable.circleimage,"Fahad");
        songLists.add(songList9);
        SongList songList10=new SongList(R.drawable.circleimage,"Mustafa");
        songLists.add(songList10);
        SongList songList11=new SongList(R.drawable.circleimage,"shakeel");
        songLists.add(songList11);
    }

}