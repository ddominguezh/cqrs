package com.ddominguezh.cqrs.shared.domain.bus.command;

public final class CommandHandlerExecutionError extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3793625140778121780L;

	public CommandHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}