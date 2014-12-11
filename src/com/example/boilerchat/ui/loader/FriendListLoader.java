package com.example.boilerchat.ui.loader;

import java.util.List;
import android.content.Context;
import com.example.boilerchat.model.ChatFriend;
/**
* A Loader to get {@link ChatFriend} from chat_friends bucket.
*
* 
*/
public class FriendListLoader extends AbstractAsyncTaskLoader<List<ChatFriend>> {
	public FriendListLoader(Context context) {
		super(context);
	}
	@Override
	public List<ChatFriend> loadInBackground() {
		return ChatFriend.list();
	}
}