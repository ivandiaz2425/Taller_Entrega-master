package com.i034114.taller_quiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.i034114.taller_quiz.Models.ModelsUsers;
import com.i034114.taller_quiz.R;
import com.i034114.taller_quiz.Views.MainPosts;
import com.squareup.picasso.Picasso;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 12/10/17.
 */

public class AdaptersUsers extends RecyclerView.Adapter<AdaptersUsers.ViewHolder> {

    List<ModelsUsers> usersList = new ArrayList<>();
    Context context;

    public AdaptersUsers(List<ModelsUsers> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Encargado de trabajar con el item.xml y sus componentes

        holder.id.setText(Integer.toString(usersList.get(position).getId()));
        holder.name.setText(usersList.get(position).getName());
        holder.username.setText(usersList.get(position).getUsername());
        holder.address.setText(usersList.get(position).getAddress());
        holder.company.setText(usersList.get(position).getCompany());
        Picasso.with(context).load(usersList.get(position).getArrayPhotosU()).into((holder.foto));


    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id;
        TextView name;
        TextView username;
        TextView address;
        TextView company;
        ImageView foto;


        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);
            foto=(ImageView)item.findViewById(R.id.id_Foto_User);
            id = (TextView) item.findViewById(R.id.id);
            name = (TextView) item.findViewById(R.id.name);
            username = (TextView) item.findViewById(R.id.username);
            address = (TextView) item.findViewById(R.id.Address);
            company = (TextView) item.findViewById(R.id.Company);

        }

        @Override
        public void onClick(View view) {

            Context contextItem = view.getContext();
            Intent intent = new Intent(context, MainPosts.class);
            intent.putExtra("idUser", usersList.get(getLayoutPosition()).getId());

            contextItem.startActivity(intent);
        }
    }



}
