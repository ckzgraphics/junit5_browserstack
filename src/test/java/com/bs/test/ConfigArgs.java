package com.bs.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class ConfigArgs implements ArgumentsProvider {

	public Stream<? extends Arguments> provideArguments(ExtensionContext arg0) throws Exception {
		
		
		Map<String, String> data1 = new HashMap<String, String>();
		data1.put("os", "Windows");
		data1.put("os_version", "10");
		data1.put("browser", "Chrome");
		
		Map<String, String> data2 = new HashMap<String, String>();
		data2.put("os", "Windows");
		data2.put("os_version", "xp");
		data2.put("browser", "Firefox");
		
		Map<String, String> data3 = new HashMap<String, String>();
		data3.put("os", "OS X");
		data3.put("os_version", "Mojave");
		data3.put("browser", "Safari");
		
		List<Map<String, String>> listData = new ArrayList<Map<String,String>>();
		listData.add(data1);
		listData.add(data2);
		listData.add(data3);
		
		Stream<Arguments> finalStream1 = null; 
		boolean firstLoop = true;
		
		for(int index=0; index<listData.size(); index++){
			
			Arguments ss = Arguments.of(listData.get(index).get("os"), listData.get(index).get("os_version"), listData.get(index).get("browser"));
			Stream<Arguments> t = Stream.of(ss);			
			
			if(firstLoop){
				finalStream1 = t;
				firstLoop = false;
			} else {
				finalStream1 =  Stream.concat(finalStream1, t);
			}
			
			ss = null;
			t = null;
			
		}
		
//		Arguments ss = Arguments.of("OS X", "Mojave", "Safari");
//		Stream<Arguments> t = Stream.of(ss);
//		
//		Arguments ss2 = Arguments.of("Windows", "10", "Chrome");
//		Stream<Arguments> t2 = Stream.of(ss2);
//		
//		Stream<Arguments> finalStream =  Stream.concat(t, t2);

		return finalStream1;
	}
	
	
	
}