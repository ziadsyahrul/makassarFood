package com.ziadsyahrul.makassarfood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;
    @BindView(R.id.btnGmail)
    Button btnGmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        Glide.with(this).load(R.drawable.fotogue).into(imgLogo);
    }


    @OnClick({R.id.btnGmail})
    public void onViewClicked(View view) {

        Intent pindah;

        switch (view.getId()) {
            case R.id.btnEmail:
                pindah = new Intent(this, RecycleActivity.class);
                startActivity(pindah);
                break;
            case R.id.btnGmail:
                pindah = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "ziadsm24@gmail.com", null));
                pindah.putExtra(Intent.EXTRA_SUBJECT, "");
                pindah.putExtra(Intent.EXTRA_SUBJECT, "");

                if (pindah.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(pindah, "pilih aplikasi yang akan digunakan"));
                } else {
                    Toast.makeText(this, "Tidak ada aplikasi yang bisa digunakan", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}


