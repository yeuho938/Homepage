package com.example.myapplicationr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcvCatecvory;
    ArrayList<Category> arrayList;
   private ImageView login;
   private ImageView signin;
   private ImageView profile;
    private RecyclerView rcvClothes;
    private Button recentBtn,nearbyBtn;
    private GridLayoutManager gridLayoutManager;

    int icons[] = {R.drawable.zalo,R.drawable.tiktok,R.drawable.facebook,R.drawable.tiw};

    String iconsName[] = {"Zalo", "TikTok", "Facebook", "Twitter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login =(ImageView) findViewById(R.id.imageView);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LogIn.class);
                startActivity(intent);
            }
        });
        signin = (ImageView) findViewById(R.id.imageView3);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
        profile = (ImageView) findViewById(R.id.imageView4);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Profile.class);
                startActivity(intent);
            }
        });
        rcvCatecvory = findViewById(R.id.main_rcv);
        arrayList = new ArrayList<>();

        rcvCatecvory.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        rcvCatecvory.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < icons.length; i++) {
            Category itemModel = new Category();
            itemModel.setResourceId(icons[i]);
            itemModel.setTitle(iconsName[i]);

            //add in array list
            arrayList.add(itemModel);
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), arrayList);
        rcvCatecvory.setAdapter(adapter);


        //Food

        recentBtn = findViewById(R.id.recent);
        nearbyBtn = findViewById(R.id.nearby);

        rcvClothes = findViewById(R.id.rcv_food);
        gridLayoutManager = new GridLayoutManager(this,2);
        rcvClothes.setLayoutManager(gridLayoutManager);

        ClothesAdapter clothesAdapter = new ClothesAdapter(getListClothes());
        rcvClothes.setAdapter(clothesAdapter);

        recentBtn.setOnClickListener(this);
        nearbyBtn.setOnClickListener(this);
    }

    private List<Clothes> getListClothes() {

        List<Clothes> list= new ArrayList<>();

        list.add(new Clothes(R.drawable.gg,"Áo Vest Black ","Áo    đẹp nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.gg,"Áo Vest Black ","Áo đẹp nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.f,"Áo Vest White ","Áo đẹp nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.f,"Áo Vest White ","Áo đẹp nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi,"Áo white nice ","Bộ đồ xịn xỏ ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi,"Áo white nice ","Bộ đồ xịn xỏ ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi,"Áo white nice","Bộ đồ xịn xỏ ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi,"Áo white nice ","Bộ đồ xịn xỏ ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi,"Áo white nice ","Bộ đồ xịn xỏ ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go," Dress good ","Mua đông never lạnh ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go,"Dress good  ","Mua đông never lạnh ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go,"Dress good  ","Mua đông never lạnh ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go,"Dress good  ","Mua đông never lạnh ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go,"Dress good  ","Mua đông never lạnh", Clothes.TypeNearBy));
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recent:
                scrollToItem(0);
                break;
            case R.id.nearby:
                scrollToItem(7);
                break;
        }
    }

    private void scrollToItem(int index) {
        if(gridLayoutManager == null)
        {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index,0);
    }
}

