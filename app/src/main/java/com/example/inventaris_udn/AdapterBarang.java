package com.example.inventaris_udn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.NamaViewHolder> {
    DatabaseHelper db;
    @NonNull
    @Override
    public NamaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_barang, viewGroup, false);

        return new NamaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamaViewHolder holder, int i) {
        String title = dataBarang[Integer.parseInt(db.COL_BRG_NAMA)];
        String jml = dataJumlah[Integer.parseInt(db.COL_BRG_JUMLAH)];
        holder.txtBrg.setText(title);
        holder.txtJml.setText(jml);

    }

    @Override
    public int getItemCount() {
        return dataBarang.length;
    }

    public class NamaViewHolder extends RecyclerView.ViewHolder{
        TextView txtBrg , txtJml;
        Button btnBuy;
        public NamaViewHolder(View itemView) {
            super(itemView);
            txtBrg = (TextView) itemView.findViewById(R.id.txt_barang);
            txtJml = (TextView) itemView.findViewById(R.id.txt_jumlah);
            btnBuy = (Button) itemView.findViewById(R.id.btn_pinjam);
        }
    }


    private String[] dataBarang;
    private String[] dataJumlah;
    public AdapterBarang(String[] databarang, String[] datajumlah){
        this.dataBarang = databarang;
        this.dataJumlah = datajumlah;
    }
}
