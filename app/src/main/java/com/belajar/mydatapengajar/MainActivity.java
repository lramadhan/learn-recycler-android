package com.belajar.mydatapengajar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.belajar.mydatapengajar.adapter.AboutPengajarAdapter;
import com.belajar.mydatapengajar.adapter.CardviewPengajarAdapter;
import com.belajar.mydatapengajar.adapter.DetailPengajarAdapter;
import com.belajar.mydatapengajar.adapter.GridPengajarAdapter;
import com.belajar.mydatapengajar.adapter.ListPengajarAdapter;
import com.belajar.mydatapengajar.model.Pengajar;
import com.belajar.mydatapengajar.model.PengajarData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPengajar;
    private ArrayList<Pengajar> list = new ArrayList<>();

    private String title = "Tampilan List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvPengajar = findViewById(R.id.rv_pengajar);
        rvPengajar.setHasFixedSize(true);

        list.addAll(PengajarData.getListData());
        showRecyclerList();
    }
//      Menampilkan recyclerlist
    private void showRecyclerList(){
        rvPengajar.setLayoutManager(new LinearLayoutManager(this));
        ListPengajarAdapter listPengajarAdapter = new ListPengajarAdapter(list);
        rvPengajar.setAdapter(listPengajarAdapter);

        listPengajarAdapter.setOnItemClickCallback(new ListPengajarAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Pengajar data) {
            showSelectedPengajar(data);
            }
        });
    }

//    Recycler Grid
    private void showrecyclerGrid(){
        rvPengajar.setLayoutManager(new GridLayoutManager(this, 2));
        GridPengajarAdapter gridPengajarAdapter = new GridPengajarAdapter(list);
        rvPengajar.setAdapter(gridPengajarAdapter);

        gridPengajarAdapter.setOnItemClickCallback(new GridPengajarAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Pengajar data) {
                showSelectedPengajar(data);
            }
        });
    }



//    Recycler Cardview
    private void showrecyclerCardview(){
        rvPengajar.setLayoutManager(new LinearLayoutManager(this));
        CardviewPengajarAdapter cardviewPengajarAdapter = new CardviewPengajarAdapter(list);
        rvPengajar.setAdapter(cardviewPengajarAdapter);
    }

//    Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Tampilan List";
                setActionBarTitle(title);
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Tampilan Grid";
                setActionBarTitle(title);
                showrecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Tampilan kartu";
                setActionBarTitle(title);
                showrecyclerCardview();
                break;

            case R.id.action_about:
                Intent moveIntent = new Intent(MainActivity.this, AboutPengajarAdapter.class);
                startActivity(moveIntent);
                break;
        }
    }

//    ubah judul
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedPengajar(Pengajar pengajar) {
        Toast.makeText(this, "Kamu memilih " + pengajar.getName(), Toast.LENGTH_SHORT).show();
//        Tambah intent
        Intent ambil = new Intent(MainActivity.this, DetailPengajarAdapter.class);
        ambil.putExtra("name",  pengajar.getName());
        ambil.putExtra("description", pengajar.getDescription());
        ambil.putExtra("photo", pengajar.getPhoto());

        startActivity(ambil);
    }

}
