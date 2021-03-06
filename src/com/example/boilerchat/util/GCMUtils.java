package com.example.boilerchat.util;

import java.io.IOException;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.example.boilerchat.ApplicationConst;
import com.example.boilerchat.BoilerChatApplication;
/**
* A suite of utilities surrounding the use of the GCM(Google Cloud Messaging)
*
* 
*/
public class GCMUtils {
	private GCMUtils() {
	}
	public static String register() throws Exception {
		String registrationId = null;
		int retry = 0;
		while (retry < 3) {
			try {
				GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(BoilerChatApplication.getContext());
				registrationId = gcm.register(ApplicationConst.SENDER_ID);
			break;
			} catch (IOException ignore) {
				Thread.sleep(1000);
				retry++;
				Logger.w("failed to register GCM. retry " + retry + " times reason=" + ignore.getMessage());
			}
		}
		if (registrationId == null || retry >= 3) {
			throw new IOException("failed to register GCM");
		}
		return registrationId;
	}
}