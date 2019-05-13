package com.example.bertone.mytp02;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewHolder> {

        public static RecyclerInterface recyclerInterface;
    Context context;
    public List<Pastas> minhaLista;
    //Meu Adapter
    public MeuAdapter(Context ctx, List<Pastas> list, RecyclerInterface clickRecyclerInterface){

        this.context = ctx;
        this.minhaLista = list;
        this.recyclerInterface = clickRecyclerInterface;
    }

    @Override
    public void onBindViewHolder(MeuViewHolder viewHolder, final int i) {
        Pastas pasta = minhaLista.get(i);
        viewHolder.txtNome.setText(i + ":" +pasta.getNome());
        viewHolder.btnDeleta.setOnClickListener((new View.OnClickListener()
        {
            public void onClick (View v){
                Pastas contatoDeletado = minhaLista.get(i);
                minhaLista.remove(contatoDeletado);
                notifyItemRemoved(i);
                notifyDataSetChanged();
            } } ));
    }

    @Override
    public MeuAdapter.MeuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_item,
                viewGroup, false);
        return new MeuViewHolder(itemView);
    }
    @Override
    public int getItemCount() {
        return minhaLista.size();
    }


    public class MeuViewHolder extends RecyclerView.ViewHolder {

        public View btnDeleta;
        protected TextView txtNome;

        public MeuViewHolder(final View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerInterface.onItemClick(minhaLista.get(getLayoutPosition()));

                }});


        }
    }
}
