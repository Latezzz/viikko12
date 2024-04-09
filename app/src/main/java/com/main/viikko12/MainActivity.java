package com.main.viikko12;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListGrocery listGrocery;
    private Bundle data = new Bundle();

    private Fragment bottomFragment = new BottomFragment();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 fragmentArea = findViewById(R.id.viewArea);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);
        fragmentArea.setAdapter(tabPagerAdapter);




        getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameBottom, bottomFragment)
                        .commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        data.putString("dataID", importantText());
        bottomFragment.setArguments(data);

    }

    public String importantText() {
        String important;
        String name;
        StringBuilder str = new StringBuilder();
        int i = 0;


        listGrocery = ListGrocery.getInstance();
        ArrayList<Grocery> groceries = new ArrayList<>();
        groceries = listGrocery.getGroceries();

        for (Grocery g: groceries) {
            if (g.isImportant() == true) {
                name = g.getName();
                if (i == 0) {
                    str.append(name);
                } if (i > 0) {
                    str.append(", ").append(name);
                }
                i++;
            }
        }
        important = str.toString();
        return important;
    }


}