package com.hiepkhach9x.base.api;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class DfeJsonRequest extends JsonObjectRequest {

	public DfeJsonRequest(String url, JSONObject jsonRequest,
                          Listener<JSONObject> listener, ErrorListener errorListener) {
		super(url, jsonRequest, listener, errorListener);
	}

	/**
	 * AndG always return code=0 when request success, otherwise failure
	 * 
	 * @param jsonObject
	 * @return
	 * @throws JSONException
	 */
	private boolean isSuccess(JSONObject jsonObject) throws JSONException {
		int code = getCodeAndG(jsonObject);
		return code == 0 ? true : false;
	}

	private int getCodeAndG(JSONObject jsonObject) throws JSONException {
		return jsonObject.getInt("code");
	}

	@Override
	protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			JSONObject jsonObject = new JSONObject(jsonString);
			if (isSuccess(jsonObject))
				return Response.success(jsonObject,
                        HttpHeaderParser.parseCacheHeaders(response));
			else
				return Response.error(new ReceiveServerError(new Exception(""),
                        getCodeAndG(jsonObject)));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException je) {
			return Response.error(new ParseError(je));
		}
	}
}
