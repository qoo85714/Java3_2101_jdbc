package tw.org.iii;

import org.json.JSONStringer;
import org.json.JSONWriter;

public class Jsontest {

	public static void main(String[] args) {
		String json = new JSONStringer().object()
					.key("key1")
					.value("value1")
					.endObject()
					.toString();
		System.out.println(json);
		
		String json2 = new JSONStringer().array()
				.object()
				.key("key1")
				.value("value1")
				.endObject()
				.object()
				.key("key2")
				.value("value2")
				.endObject()
				.endArray()
				.toString();
		System.out.println(json2);
		
		JSONWriter jw = new JSONStringer().array();
		
		jw.object().key("key1").value("value1").endObject();
	
		
		jw.endArray();
		System.out.println(jw.toString());
	}
}
