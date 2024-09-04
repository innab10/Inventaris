package com.example.inventaris_udn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterAdmin extends RecyclerView.Adapter<AdapterAdmin.NamaViewHolder> {
    DatabaseHelper db;
    @NonNull
    @Override
    public NamaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.barang_admin, viewGroup, false);
        return new NamaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamaViewHolder holder, int i) {
        String title = Barang[Integer.parseInt(db.COL_BRG_NAMA)];
        String jml = Jumlah[Integer.parseInt(db.COL_BRG_JUMLAH)];
        holder.Brg.setText(title);
        holder.Jml.setText(jml);

    }

    @Override
    public int getItemCount() {
        return Barang.length;
    }

    public class NamaViewHolder extends RecyclerView.ViewHolder{
        TextView Brg , Jml;
        Button Edt, Hps;
        public NamaViewHolder(View itemView) {
            super(itemView);
            Brg = (TextView) itemView.findViewById(R.id.brg);
            Jml = (TextView) itemView.findViewById(R.id.jumlah);
            Edt = (Button) itemView.findViewById(R.id.btn_edit);
            Hps = (Button) itemView.findViewById(R.id.btn_hapus);
        }
    }


    private String[] Barang;
    private String[] Jumlah;
    public AdapterAdmin(String[] dataitem, String[] dataharga){
        this.Barang = dataitem;
        this.Jumlah = dataharga;
    }
}
