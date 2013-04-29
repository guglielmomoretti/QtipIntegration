package org.ceia.qtip.client.components;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

public class QtipUtils {

	@SuppressWarnings("unchecked")
	public static <T> T createObject(Class<T> object) {
		return (T) JavaScriptObject.createObject().cast();
	}


	@SuppressWarnings("unchecked")
	public static <T> T createArray(Class<T> object) {
		return (T) JavaScriptObject.createArray().cast();
	}

	public static final native boolean isObjectEmpty(JavaScriptObject obj) /*-{
		var GWT_ID = "__gwt_ObjectId";
		var foundGwtID = false;
		var propertyCount = 0;

		if (obj == null)
			return true;

		try {
			for ( var key in obj) {
				if (obj.hasOwnProperty(key)) {
					++propertyCount;
					if (key.toString().toLowerCase() == GWT_ID.toLowerCase()) {
						foundGwtID == true;
					}
				}
			}

			if (propertyCount < 1)
				return true;

			if (propertyCount == 1 && foundGwtID)
				return true;
		} catch (e) {
		}
		return false;

	}-*/;

	public static void removeKeyFromObject(JavaScriptObject obj, String key) {
		new JSONObject(obj).put(key, null);
	};
}
