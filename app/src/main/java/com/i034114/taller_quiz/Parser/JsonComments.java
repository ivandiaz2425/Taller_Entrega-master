package com.i034114.taller_quiz.Parser;

import com.i034114.taller_quiz.Models.ModelsComments;
import com.i034114.taller_quiz.Models.ModelsPost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 12/10/17.
 */

public class JsonComments {

    public static List<ModelsComments> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<ModelsComments> CommentsList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            ModelsComments Comments = new ModelsComments();
            Comments.setPostid(item.getInt("postId"));
            Comments.setId(item.getInt("id"));
            Comments.setEmail(item.getString("email"));
            Comments.setBody(item.getString("body"));

            CommentsList.add(Comments);
        }
        return CommentsList;
    }
}
