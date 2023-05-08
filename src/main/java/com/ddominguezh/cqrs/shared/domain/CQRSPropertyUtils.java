package com.ddominguezh.cqrs.shared.domain;

import java.io.IOException;
import java.util.Properties;

import com.ddominguezh.cqrs.shared.domain.exception.CQRSPropertyFileException;

public class CQRSPropertyUtils {

	private static CQRSPropertyUtils _instance;
	private String packageName;
	public CQRSPropertyUtils() {
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/cqrs.properties"));
			this.packageName = properties.getProperty("package.name");
		} catch (IOException e) {
			throw new CQRSPropertyFileException();
		}
	}
	public static CQRSPropertyUtils getInstance() {
		if(_instance == null) {
			_instance = new CQRSPropertyUtils();
		}
		return _instance;
	}
	public String getPackage() {
		return this.packageName;
	}
}
