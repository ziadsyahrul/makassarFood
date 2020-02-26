package com.ziadsyahrul.makassarfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailResepActivity extends AppCompatActivity {

    @BindView(R.id.imgLogoMakanan)
    ImageView imgLogoMakanan;
    @BindView(R.id.txtTitleResep)
    TextView txtTitleResep;
    @BindView(R.id.txtDetailResep)
    TextView txtDetailResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);
        ButterKnife.bind(this);

        String namaFood = getIntent().getStringExtra("nf");
        int gambarFood = getIntent().getIntExtra("gf",0);
        String resepMakanan = getIntent().getStringExtra("rm");

        txtTitleResep.setText(namaFood);
        txtDetailResep.setText(resepMakanan);
        Glide.with(this).load(gambarFood).into(imgLogoMakanan);

    }
}
