package com.ddominguezh.cqrs.shared.domain.exception;

public class CQRSPropertyFileException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9164589185549959211L;
	public CQRSPropertyFileException() {
		super("File cqrs property not exists");
	}
}
