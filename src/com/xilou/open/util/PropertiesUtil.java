package com.xilou.open.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * 以资源流的行式读取properties文件
	 * 
	 * @param propFileName
	 *            properties文件
	 * @return
	 */
	public static Properties getPropertiesByClassLoader(String propFileName) {
		Properties prop = new Properties();
		InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream(propFileName);
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	/**
	 * 以文件流的行式读取properties文件，无需重启应用
	 * 
	 * @param propFileName
	 *            properties文件
	 * @return
	 */
	public static Properties getPropertiesByInputStream(String propFileName) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(propFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				prop.load(input);
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}
