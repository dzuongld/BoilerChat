package com.example.boilerchat.ui.loader;

import java.util.List;
import android.content.Context;
import com.example.boilerchat.model.ChatStamp;
/**
* A Loader to get {@link ChatStamp} from chat_stamps bucket.
*
* 
*/
public class ChatStampListLoader extends AbstractAsyncTaskLoader<List<ChatStamp>> {
	public ChatStampListLoader(Context context) {
		super(context);
	}
	@Override
	public List<ChatStamp> loadInBackground() {
		return ChatStamp.listOrderByNewly();
	}
}