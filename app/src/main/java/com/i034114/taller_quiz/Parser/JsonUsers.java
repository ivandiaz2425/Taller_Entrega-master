package com.i034114.taller_quiz.Parser;

import com.i034114.taller_quiz.Models.ModelsUsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 12/10/17.
 */

public class JsonUsers {
    public static List<ModelsUsers> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<ModelsUsers> userslList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            ModelsUsers users = new ModelsUsers();
            users.setId(item.getInt("id"));
            users.setName(item.getString("name"));
            users.setUsername(item.getString("username"));

            JSONObject address = item.getJSONObject("address");
            users.setAddress(address.getString("city"));

            JSONObject company = item.getJSONObject("company");
            users.setCompany(company.getString("name"));

            userslList.add(users);
        }
        return userslList;
    }
}
