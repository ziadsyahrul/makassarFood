package com.ziadsyahrul.makassarfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleRekomendasiActivity extends AppCompatActivity {

    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    String[] nama, namaJalan,nomor;
    int[] gambarTempat = {R.drawable.coto_nusantara,R.drawable.pallubasa_serigala,R.drawable.konro_karebosi,R.drawable.warung_bravo,R.drawable.warung_bravo,R.drawable.warung_pangkep,R.drawable.pantai_losari_pisangepe,R.drawable.sarabba_cerekang,R.drawable.mama_barongko,R.drawable.wasfah_nasikuning, R.drawable.restoran_pallumara, R.drawable.mie_titi_irian};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_rekomendasi);
        ButterKnife.bind(this);

        nama = getResources().getStringArray(R.array.nama_restoran);
        namaJalan = getResources().getStringArray(R.array.nama_jalan);
        nomor = getResources().getStringArray(R.array.no_telepon);

        AdapterRekomendasi adapterRekomendasi = new AdapterRekomendasi(this,nama,namaJalan,gambarTempat,nomor);

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapterRekomendasi);
    }
}
