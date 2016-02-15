package com.hiepkhach9x.base.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class DfeRequest extends Request<JSONObject> {
	public DfeRequest(String url, Map<String, String> params,
			Listener<JSONObject> listener, ErrorListener errorListener) {
		super(Method.POST, url, errorListener);
		mListener = listener;
		mParams = params;
	}

	private Listener<JSONObject> mListener;
	private Map<String, String> mParams;

	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
//		String requestId = new Random().nextLong() + "";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("appid", QTCSApp.get().getAppId());
//		params.put(
//				"key",
//				getKey(KitesConfig.SECURITY_KEY,KitesConfig.APP_ID, requestId));
//		params.put("requestid", requestId);
//		mParams.putAll(params);
//		return mParams;
		return null;
	}

	/**
	 * Kites always return code=0 when request success, otherwise failure
	 * 
	 * @param jsonObject
	 * @return
	 * @throws JSONException
	 */
	private boolean isSuccess(JSONObject jsonObject) throws JSONException {
		int code = getCodeKites(jsonObject);
		return code == 0 ? true : false;
	}

	private int getCodeKites(JSONObject jsonObject) throws JSONException {
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
                        getCodeKites(jsonObject)));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException je) {
			return Response.error(new ParseError(je));
		}
	}

	@Override
	protected void deliverResponse(JSONObject response) {
		mListener.onResponse(response);
	}
}
