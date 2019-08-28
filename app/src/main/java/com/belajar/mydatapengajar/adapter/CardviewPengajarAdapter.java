package com.belajar.mydatapengajar.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.mydatapengajar.MainActivity;
import com.belajar.mydatapengajar.R;
import com.belajar.mydatapengajar.model.Pengajar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class CardviewPengajarAdapter extends RecyclerView.Adapter<CardviewPengajarAdapter.CardViewHolder> {
    private ArrayList<Pengajar> listPengajar;

    public CardviewPengajarAdapter(ArrayList<Pengajar> list) {
        this.listPengajar = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_pengajar, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        Pengajar pengajar = listPengajar.get(position);
        final String namaPengajar = listPengajar.get(holder.getAdapterPosition()).getName();
        final String deskripsiPengajar = listPengajar.get(holder.getAdapterPosition()).getDescription();
        final String photoPengajar = listPengajar.get(holder.getAdapterPosition()).getPhoto();

        Glide.with(holder.itemView.getContext())
                .load(pengajar.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(pengajar.getName());
        holder.tvDescription.setText(pengajar.getDescription());

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick(View view) {
            Toast.makeText(holder.itemView.getContext(), "Anda Memilih " + namaPengajar, Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnDial.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
            Toast.makeText(holder.itemView.getContext(), "Hubungi " + deskripsiPengajar, Toast.LENGTH_SHORT).show();
        }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(holder.itemView.getContext(), "Ini adalah " + photoPengajar, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPengajar.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;
        Button btnDetail, btnDial;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            btnDial = itemView.findViewById(R.id.btn_dial);
        }
    }
}
