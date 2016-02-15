package com.hiepkhach9x.base.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * process method define on DfeApi
 *
 * JSONObject jsonObject = new JSONObject();
 * DfeJsonRequest request = new DfeJsonRequest(BASE_URI, jsonObject, listener, errorListener);
 * return mQueue.add(request);
 *
 */
public class DfeApiImpl implements DfeApi {
	private final RequestQueue mQueue;

	public DfeApiImpl(RequestQueue requestQueue) {
		mQueue = requestQueue;
	}
}
