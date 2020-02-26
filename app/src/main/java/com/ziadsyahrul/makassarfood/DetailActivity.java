package com.ziadsyahrul.makassarfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String RM = "rm";
    public static final String GF = "gf";
    public static final String NF = "nf";
    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    String resepMakanan, namaFood;
    int gambarFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

         namaFood = getIntent().getStringExtra("nf");
         gambarFood = getIntent().getIntExtra("gf",0);


        //TODO Mengubah textView dan imageView dengan data dari halaman sebelumnya
        txtTitle.setText(namaFood);
        txtDetail.setText(getIntent().getStringExtra("df"));
        Glide.with(this).load(gambarFood).into(imgLogo);
        resepMakanan =  getIntent().getStringExtra("rm");
    }


    public void btnResep(View view) {
        Intent pindah = new Intent(this, DetailResepActivity.class);
        pindah.putExtra(RM, resepMakanan );
        pindah.putExtra(GF, gambarFood);
        pindah.putExtra(NF, namaFood);
        startActivity(pindah);
    }
}
