

package com.vienna.util;

import java.util.UUID;

public class UuidUtil {
	public static String getUUID(){
		UUID uid = UUID.randomUUID();
		String id = uid.toString();
		String str = id.replace("-", "");
		return str;
	}
}	
