package ggn.home.help.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import ggn.home.help.features.base.ApplicationClass;
import ggn.home.help.web.models.User;

public class SharedPrefHelper {
    private SharedPreferences.Editor edit;
    private SharedPreferences preferences;
    private SharedPreferences preferencesSaved;

    public static final String LANGUAGE = "language";

    public SharedPrefHelper(Context context) {
        preferences = context.getSharedPreferences("EFarmX", Context.MODE_PRIVATE);
        preferencesSaved = context.getSharedPreferences("EFarmXSaved", Context.MODE_PRIVATE);
    }

    public void setUserData(User data) {

        if (data == null) {
            return;
        }
//        setUserName(data.fullName);
//        setEmail(data.email);
//        setUserId(data.id);
//        if (!TextUtils.isEmpty(data.accessToken))
//            setAuthToken(data.accessToken);
//        if (!TextUtils.isEmpty(data.image))
//            setProfileImage(data.image);
//        setMobile(data.mobile);
//        setUserType(data.roles);
//        saveUser(data);

        ApplicationClass.resetRetrofit();
    }

    public void setLanguage(String language) {
        edit = preferences.edit();
        edit.putString(LANGUAGE, language);
        edit.apply();
    }

    public String getLanguage() {
        return preferences.getString(LANGUAGE, "en");
    }

    private void setUserName(String userName) {
        edit = preferences.edit();
        edit.putString("userName", userName);
        edit.apply();
    }

    public String getUserName() {
        return preferences.getString("userName", "");
    }

    private void setEmail(String userName) {
        edit = preferences.edit();
        edit.putString("email", userName);
        edit.apply();
    }

    public String getEmail() {
        return preferences.getString("email", "");
    }

    private void setProfileImage(String userName) {
        edit = preferences.edit();
        edit.putString("profileImage", userName);
        edit.apply();
    }

    public String getProfileImage() {
        return preferences.getString("profileImage", "");
    }

    private void setUserId(String userName) {
        edit = preferences.edit();
        edit.putString("userId", userName);
        edit.apply();
    }

    public String getUserId() {
        return preferences.getString("userId", "");
    }

}
