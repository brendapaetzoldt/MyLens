package com.example.mylens.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mylens.R;
import com.example.mylens.adapter.PagerAdapter;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //  private List<Lente> lentes;

    Button button;
    ListView listView;
    private Lente lente = null;
    private LenteDAO dao;
    private List<Lente> lentes;
    List<Lente> lentesUsar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_lentes);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });


        // getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();

        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabHome = findViewById(R.id.home);
        TabItem tabHistorico = findViewById(R.id.historico);

        final ViewPager viewPager = findViewById(R.id.viewPager);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


}
