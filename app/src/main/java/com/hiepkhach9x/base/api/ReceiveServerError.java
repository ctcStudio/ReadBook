package com.hiepkhach9x.base.api;

import com.android.volley.VolleyError;

@SuppressWarnings("serial")
public class ReceiveServerError extends VolleyError {
	private int code;
	public ReceiveServerError(Throwable throwable,int code) {
		super(throwable);
		this.code=code;
	}

	@Override
	public String getMessage() {
		return getMessageCode(code);
	}

	public String getMessageCode(int code) {
		String string = "Loi chung";
		switch (code) {
		case 1001:
			string = "Loi sai key";
			break;
		case 1002:
			string = "RequestId khong hop le";
			break;
		case 1003:
			string = "Ma doi tac khong ton tai";
			break;
		case 1004:
			string = "Sai kieu integer cua tham so truyen vao";
			break;

		default:
			break;
		}
		return string;
	}
}
