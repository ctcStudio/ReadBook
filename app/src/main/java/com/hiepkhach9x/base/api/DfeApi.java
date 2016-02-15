package com.hiepkhach9x.base.api;

import com.hiepkhach9x.readbook.utils.Config;

/**
 * define method get api
 * example public abstract Request<JSONObject> getListBook(param1,param2....Listener<JSONObject> listener, ErrorListener errorListener);
 */
public interface DfeApi {
	public static final String BASE_URI = Config.SERVER_URL;

}
