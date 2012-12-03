package com.cf.xmlrpc;

import java.net.URI;
import java.util.HashMap;

import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Client extends Activity {
	
	private XMLRPCClient client;
	private URI uri;
	private TextView textView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //uri = URI.create("http://www.lukapeharda.com/demos/xmlrpc-test/public/server/");
        uri = URI.create("http://10.0.2.2/xmlrpc-test/public/server/");
		client = new XMLRPCClient(uri);
		
		textView = (TextView) findViewById(R.id.text_view);
		
		//textView.setText(testMethod());
		textView.setText(getDataMethod(12));
		
		/*try {
			//String test = (String) client.call("cf.test");
			//textView.setText(test);
			data = (Object[]) client.call("cf.getData", num);
			Log.i("XMLRPC Test", String.valueOf(data.getClass().isArray()));
			for(Object o: data) {
				Log.i("XMLRPC Test", o.getClass().getName());
				HashMap map = (HashMap)o;
				temp = temp + "'datetime' => " + map.get("datetime") + ", 'number' => " + map.get("number") + ", 'title' => " + map.get("title") + "\n\n";
				Log.i("XMLRPC Test", "keys: " + map.keySet().toString());
				Log.i("XMLRPC Test", "values: 'datetime' => " + map.get("datetime") + ", 'number' => " + map.get("number") + ", 'title' => " + map.get("title"));
			}
			//Log.d("XMLRPC Test", data.toString());
			textView.setText(temp);
		} catch (XMLRPCException e) {
			Log.w("XMLRPC Test", "Error", e);
		}*/
    }
	
	private String testMethod() {
		String text = "";
		try {
			text = (String) client.call("cf.test");
		} catch (XMLRPCException e) {
			Log.w("XMLRPC Test", "Error", e);
			text = "XMLRPC error";
		}		
		return text;
	}
	
	private String getDataMethod(int num) {
		String text = "";
		try {
			Object[] data = (Object[]) client.call("cf.getData", num);
			for(Object o: data) {
				HashMap map = (HashMap) o;
				text = text + "'datetime' => " + map.get("datetime") + ", 'number' => " + map.get("number") + ", 'title' => " + map.get("title") + "\n\n";
			}
		} catch (XMLRPCException e) {
			Log.w("XMLRPC Test", "Error", e);
			text = "XMLRPC error";
		}		
		return text;
	}
}