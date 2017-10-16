package com.i034114.taller_quiz.Parser;

import com.i034114.taller_quiz.Models.ModelsPost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 12/10/17.
 */

public class JsonPost {
    public static List<ModelsPost> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<ModelsPost> PostList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            ModelsPost Post = new ModelsPost();
            Post.setUserid(item.getInt("userId"));
            Post.setId(item.getInt("id"));
            Post.setTitle(item.getString("title"));
            Post.setBody(item.getString("body"));

            PostList.add(Post);
        }
        return PostList;
    }
}
