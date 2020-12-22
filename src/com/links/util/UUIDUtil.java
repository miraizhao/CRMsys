package com.links.util;

import java.util.UUID;

public class UUIDUtil {
	/**
	 * 生成一个32位唯一的字符串，便于对数据存储主键生成
	 * @return
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		if (s.length() > 0)
			return s.substring(0, 5)+s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
		return "";
	}
}
