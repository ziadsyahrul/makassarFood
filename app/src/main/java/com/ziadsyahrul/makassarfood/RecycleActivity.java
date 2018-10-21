package com.ziadsyahrul.makassarfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    //TODO 1 mengenerate butterknife untuk recycleview
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    //TODO 2 membuat variable array untuk menampung data nama,detail dan gambar dari String Array pada
    String[] namaFood;
    String[] detailFood;
    int[] gambarFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        //TODO 3 Mengisi variable array dari folder -> Strings,drawable
        namaFood = getResources().getStringArray(R.array.food_name);
        detailFood = getResources().getStringArray(R.array.detail_food);
        gambarFood = new int[]{R.drawable.coto_makasar,R.drawable.pallubasa_makassar,R.drawable.sup_konro, R.drawable.es_pisang_ijo,R.drawable.pallubutung_makassar,R.drawable.sop_saudara,R.drawable.pisang_epe,R.drawable.sarabba,R.drawable.barongko};

        //TODO 4 Membuat object adpater dan mengirim data nama,detail dan gambar ke adapter
        Adapter adapter = new Adapter(RecycleActivity.this, gambarFood, namaFood, detailFood);
        //TODO 5 Mensetting recyclerview dan mengeset recycleview dengan adapter
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter(adapter);

    }
}
