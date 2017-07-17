package com.tensun.tinderswipedemo;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class Utils {

    /** 取得profiles.json 的所有數據, 並放到 Profile */
    public static List<Profile> loadProfiles(Context context){

        try{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            JSONArray array = new JSONArray(loadJSONFromAsset(context, "profiles.json"));                                // 建立一個JSONArray, 並包含profiles.json
            List<Profile> profileList = new ArrayList<>();                                                              // 建立一個List<Profile>

            for(int i=0;i<array.length();i++){                                                                          // 把array的所有東西, 先分別轉成profile, 再分別放進profileList
                Profile profile = gson.fromJson(array.getString(i), Profile.class);
                profileList.add(profile);
            }
            return profileList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static String loadJSONFromAsset(Context context, String jsonFileName) {

        String json = null;
        InputStream is=null;

        try {
            AssetManager manager = context.getAssets();
            is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
