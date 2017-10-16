package com.i034114.taller_quiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.i034114.taller_quiz.MainActivity;
import com.i034114.taller_quiz.Models.ModelsComments;
import com.i034114.taller_quiz.R;
import com.i034114.taller_quiz.Views.MainComments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 12/10/17.
 */

public class AdaptersComments extends RecyclerView.Adapter<AdaptersComments.ViewHolder>{

    List<ModelsComments> CommentslList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public AdaptersComments(List<ModelsComments> CommentslList, Context context) {
        this.CommentslList = CommentslList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comments, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptersComments.ViewHolder holder, int position) {
        // Encargado de trabajar con el item.xml y sus componentes
        holder.id.setText(Integer.toString(CommentslList.get(position).getId()));
        holder.title.setText(CommentslList.get(position).getEmail());
        holder.body.setText(CommentslList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return CommentslList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView id;
        TextView title;
        TextView body;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);
            id = (TextView) item.findViewById(R.id.idComments);
            title = (TextView) item.findViewById(R.id.idemailC);
            body = (TextView) item.findViewById(R.id.bodyC);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
            Intent intent = new Intent(context, MainActivity.class);
            contextItem.startActivity(intent);
        }
    }
}
