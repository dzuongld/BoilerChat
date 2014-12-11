package com.example.boilerchat;

import com.kii.cloud.analytics.KiiAnalytics;
import com.kii.cloud.storage.*;
import com.example.boilerchat.util.Logger;
import android.app.Application;
import android.content.Context;
/**
* Custom implementation of Application.
*
* 
*/
public class BoilerChatApplication extends Application {
	private static Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		// Initialize SDK when application is started.
		//Logger.i("initialize KII SDK");
		Kii.initialize(ApplicationConst.APP_ID, ApplicationConst.APP_KEY, Kii.Site.US);
		//Logger.i("initialize KII Analytics SDK");
		KiiAnalytics.initialize(context, ApplicationConst.APP_ID, ApplicationConst.APP_KEY, KiiAnalytics.Site.US);
	}
	public static Context getContext(){
		return context;
	}
	public static String getMessage(int msgId) {
		return context.getResources().getString(msgId);
	}
	public static String getFormattedMessage(int msgId, Object... args) {
		String message = context.getResources().getString(msgId);
	return String.format(message, args);
	}
}