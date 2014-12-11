package com.example.boilerchat.ui.loader;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import com.kii.cloud.storage.KiiGroup;
import com.kii.cloud.storage.KiiUser;
import com.example.boilerchat.util.Logger;
/**
* A Loader to get {@link KiiGroup} which is belonged by logged in user.
*
* 
*/
public class ChatListLoader extends AbstractAsyncTaskLoader<List<KiiGroup>> {
	public ChatListLoader(Context context) {
		super(context);
	}
	@Override
	public List<KiiGroup> loadInBackground() {
		try {
			List<KiiGroup> groups = KiiUser.getCurrentUser().memberOfGroups();
			for (KiiGroup group : groups) {
				group.refresh();
			}
			return groups;
		} catch (Exception e) {
			Logger.e("Unable to list groups", e);
			return new ArrayList<KiiGroup>();
		}
	}
}