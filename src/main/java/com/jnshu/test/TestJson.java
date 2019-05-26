package com.jnshu.test;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

/*
* json格式
* {
  "hobbies": [
    "hiking",
    "swimming"
  ],
  "sex": "male",
  "name": "John",
  "is_student": true,
  "age": 22
}
* */

public class TestJson {
    public static void main(String[] args) throws Exception {
        File file = new File("src/main/java/com/jnshu/mockdata/test1.json");
        String content = FileUtils.readFileToString(file,"utf-8");
        JSONObject jsonObject = new JSONObject(content);

        System.out.println("name: "+jsonObject.getString("name"));
        System.out.println("sex: "+jsonObject.getString("sex"));
        System.out.println("is_student: "+jsonObject.getBoolean("is_student"));
        System.out.println("age: "+jsonObject.getInt("age"));

        JSONArray jsonArray = jsonObject.getJSONArray("hobbies");
        System.out.println("hobbies: ");
        for (int i = 0; i < jsonArray.length(); i++) {
            String s = (String) jsonArray.get(i);
            System.out.println(s);
        }

    }

}
