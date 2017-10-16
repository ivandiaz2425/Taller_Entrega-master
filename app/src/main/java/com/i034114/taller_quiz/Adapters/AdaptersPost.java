package com.i034114.taller_quiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.i034114.taller_quiz.Models.ModelsPost;
import com.i034114.taller_quiz.Models.ModelsUsers;
import com.i034114.taller_quiz.R;
import com.i034114.taller_quiz.Views.MainComments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 12/10/17.
 */

public class AdaptersPost extends RecyclerView.Adapter<AdaptersPost.ViewHolder>  {


    List<ModelsPost> postlList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public AdaptersPost(List<ModelsPost> postlList, Context context) {
        this.postlList = postlList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posts, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Encargado de trabajar con el item.xml y sus componentes
        holder.id.setText(Integer.toString(postlList.get(position).getId()));
        holder.title.setText(postlList.get(position).getTitle());
        holder.body.setText(postlList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postlList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView id;
        TextView title;
        TextView body;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);
            id = (TextView) item.findViewById(R.id.idpost);
            title = (TextView) item.findViewById(R.id.idtitleP);
            body = (TextView) item.findViewById(R.id.bodyP);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
            Intent intent = new Intent(context, MainComments.class);
            intent.putExtra("idPost", postlList.get(getLayoutPosition()).getId());

            contextItem.startActivity(intent);
        }
    }



}
