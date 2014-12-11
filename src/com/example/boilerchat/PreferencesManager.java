package com.example.boilerchat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
/**
* A helper class to handle SharedPreferences.
*
*  
*/
public class PreferencesManager {
interface Key {
static final String ACCESS_TOKEN = "token";
static final String SENDER_ID = "65004617865";
}
public static void setStoredAccessToken(String token) {
setString(Key.ACCESS_TOKEN, token);
}
public static String getStoredAccessToken() {
return getSharedPreferences().getString(Key.ACCESS_TOKEN, null);
}
private static SharedPreferences getSharedPreferences() {
return PreferenceManager.getDefaultSharedPreferences(BoilerChatApplication.getContext());
}
private static void setString(String key, String value) {
Editor editor = getSharedPreferences().edit();
editor.putString(key, value);
editor.commit();
}
}