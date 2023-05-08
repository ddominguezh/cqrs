package com.ddominguezh.cqrs.shared.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CQRSPropertyUtilsTest {

	@Test
	public void get_package_name() {
		assertEquals("com.ddominguezh", CQRSPropertyUtils.getInstance().getPackage());
	}
}
