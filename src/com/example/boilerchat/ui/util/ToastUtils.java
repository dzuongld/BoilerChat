package com.example.boilerchat.ui.util;

import com.example.boilerchat.BoilerChatApplication;
import android.content.Context;
import android.widget.Toast;
/**
* A suite of utilities surrounding the use of the Toast.
*
* 
*/
public class ToastUtils {
	public static final void showShort(Context context, String msg) {
		show(context, msg, Toast.LENGTH_SHORT);
	}
	public static final void showLong(Context context, String msg) {
		show(context, msg, Toast.LENGTH_LONG);
	}
	private static final void show(Context context, String msg, int duration) {
		Toast.makeText(context, msg, duration).show();
	}
	public static final void showShort(Context context, int msgId) {
		show(context, msgId, Toast.LENGTH_SHORT);
	}
	public static final void showLong(Context context, int msgId) {
		show(context, msgId, Toast.LENGTH_LONG);
	}
	public static final void show(Context context, int msgId, int duration) {
		String msg = BoilerChatApplication.getMessage(msgId);
		show(context, msg, duration);
	}
}