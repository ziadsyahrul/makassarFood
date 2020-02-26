package com.ziadsyahrul.makassarfood;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class AdapterRekomendasi extends RecyclerView.Adapter<AdapterRekomendasi.CardViewViewHolder> {

    Context context;
    String[] nama, namaJalan,nomor;
    int[] gambarTempat;

    public AdapterRekomendasi(Context context, String[] nama, String[] namaJalan, int[] gambarTempat, String[] nomor) {
        this.context = context;
        this.nama = nama;
        this.namaJalan = namaJalan;
        this.gambarTempat = gambarTempat;
        this.nomor = nomor;
    }

    @NonNull
    @Override
    public AdapterRekomendasi.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_rekomendasi,viewGroup,false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRekomendasi.CardViewViewHolder cardViewViewHolder, final int i) {
        cardViewViewHolder.tv_item_jalan.setText(namaJalan[i]);
        cardViewViewHolder.tv_item_name.setText(nama[i]);
        Glide.with(context).load(gambarTempat[i]).into(cardViewViewHolder.img_item_photo);
        cardViewViewHolder.btn_set_telepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + nomor[i]));
                context.startActivity(intent);
            }
        });
        cardViewViewHolder.btn_set_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Your Like This Resto",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarTempat.length;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView img_item_photo;
        TextView tv_item_name;
        TextView tv_item_jalan;
        Button btn_set_favorite;
        Button btn_set_telepon;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item_photo = itemView.findViewById(R.id.img_item_photo);
            tv_item_name = itemView.findViewById(R.id.tv_item_name);
            tv_item_jalan = itemView.findViewById(R.id.tv_item_jalan);
            btn_set_favorite = itemView.findViewById(R.id.btn_set_favorite);
            btn_set_telepon = itemView.findViewById(R.id.btn_set_telepon);
        }
    }
}
