package com.i034114.taller_quiz.Views;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.i034114.taller_quiz.Adapters.AdaptersComments;
import com.i034114.taller_quiz.Adapters.AdaptersPost;
import com.i034114.taller_quiz.Connection.HttpManager;
import com.i034114.taller_quiz.Models.ModelsComments;
import com.i034114.taller_quiz.Models.ModelsPost;
import com.i034114.taller_quiz.Parser.JsonComments;
import com.i034114.taller_quiz.Parser.JsonPost;
import com.i034114.taller_quiz.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class MainComments extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    List<ModelsComments> CommentsList;
    AdaptersComments adaptersComments;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comments);
        toolbar = (Toolbar) findViewById(R.id.Toolbar3);
        showToolbar(getResources().getString(R.string.PantallaComments));

        progressBar = (ProgressBar) findViewById(R.id.id_PantallaComments);
        recyclerView = (RecyclerView) findViewById(R.id.id_PantallaComments1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadData(Integer.toString(getIntent().getExtras().getInt("idPost")));
    }

    public void showToolbar(String I) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(I);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menucomments, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        loadData(Integer.toString(getIntent().getExtras().getInt("idPost")));
        return super.onOptionsItemSelected(item);

    }

    public Boolean isOnLine(){
        // Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Validar el estado obtenido de la conexion
        if (networkInfo != null){
            return true;
        }else {
            return false;
        }
    }

    public void loadData(String idPost){
        if (isOnLine()){
            MainComments.TaskPhoto taskPhoto = new MainComments.TaskPhoto();
            taskPhoto.execute("https://jsonplaceholder.typicode.com/comments?postId="+idPost);
        }else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        adaptersComments = new AdaptersComments(CommentsList, getApplicationContext());
        recyclerView.setAdapter(adaptersComments);
    }

    public class TaskPhoto extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpManager.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                CommentsList = JsonComments.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            processData();

            progressBar.setVisibility(View.GONE);
        }
    }
}
