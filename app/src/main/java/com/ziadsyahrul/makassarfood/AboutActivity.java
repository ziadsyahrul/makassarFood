package com.ziadsyahrul.makassarfood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;
    @BindView(R.id.btnEmail)
    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEmail)
    public void onViewClicked() {
         Intent pindah;

        //TODO membuat Intent untuk memanggil Email
        pindah = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","replacestudio@gmail.com", null));

        //TODO memasukkan subject dan isi pesan ke dalam Intent
        pindah.putExtra(Intent.EXTRA_SUBJECT, "Kritik Dan Saran Aplikasi kulinerest");
        pindah.putExtra(Intent.EXTRA_SUBJECT, "Ketik Saran disini");

        //TODO mengecek apakah user memiliki aplikasi email
        if (pindah.resolveActivity(getPackageManager()) != null){
            //TODO memanggil intent dan memunculkan popup memilih aplikasi
            startActivity(Intent.createChooser(pindah, "Pilih aplikasi yang akan digunakan"));
        }else{
            //TODO menampilkan pesan dengan toast
            Toast.makeText(this,"Tidak ada aplikasi Email yang bisa digunakan",Toast.LENGTH_SHORT).show();
        }
    }
}
