package com.hiepkhach9x.base.api.model;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

import java.util.HashSet;

public abstract class DfeModel implements
		com.android.volley.Response.ErrorListener {
	private HashSet<ErrorListener> mErrorListeners;
	private HashSet<OnDataChangedListener> mListeners;
	private VolleyError mVolleyError;

	public DfeModel() {
		mErrorListeners = new HashSet<ErrorListener>();
		mListeners = new HashSet<OnDataChangedListener>();
	}

	public final void addDataChangedListener(
			OnDataChangedListener ondatachangedlistener) {
		mListeners.add(ondatachangedlistener);
	}

	public final void addErrorListener(
			com.android.volley.Response.ErrorListener errorlistener) {
		mErrorListeners.add(errorlistener);
	}

	protected void clearErrors() {
		mVolleyError = null;
	}

	public VolleyError getVolleyError() {
		return mVolleyError;
	}

	public boolean inErrorState() {
		return mVolleyError == null ? false : true;
	}

	public abstract boolean isReady();

	protected void notifyDataSetChanged() {
		for (OnDataChangedListener onDataChangedListener : mListeners) {
			onDataChangedListener.onDataChanged();
		}
	}

	protected void notifyErrorOccured(VolleyError volleyerror) {
		for (ErrorListener errorListener : mErrorListeners) {
			errorListener.onErrorResponse(volleyerror);
		}
	}

	@Override
	public void onErrorResponse(VolleyError volleyerror) {
		mVolleyError = volleyerror;
		notifyErrorOccured(volleyerror);
	}

	public final void removeDataChangedListener(
			OnDataChangedListener ondatachangedlistener) {
		mListeners.remove(ondatachangedlistener);
	}

	public final void removeErrorListener(
			com.android.volley.Response.ErrorListener errorlistener) {
		mErrorListeners.remove(errorlistener);
	}

	public final void unregisterAll() {
		mListeners.clear();
		mErrorListeners.clear();
	}
}
