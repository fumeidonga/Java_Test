package test_java.test.test_json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GsonManager {

	private static Gson gson = null;
	static {
		if (gson == null) {
			gson = new Gson();
		}
	}

	/**
	 * 转成list
	 * 
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> GsonToList(String gsonString) {
		List<T> list = null;
		if (gson != null) {
			list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
			}.getType());
		}
		return list;
	}

	/**
	 * 这里的入参是json数组类型的字符串 jsonArrayString转成list
	 */
	public static <T> List<T> GsonToList(String json, Class<T> cls) {
		Gson gson = new Gson();
		List<T> list = new ArrayList<T>();
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();
		for (final JsonElement elem : array) {
			list.add(gson.fromJson(elem, cls));
		}
		return list;
	}
}
