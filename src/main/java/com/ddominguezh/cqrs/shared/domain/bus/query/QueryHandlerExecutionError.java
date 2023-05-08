package com.ddominguezh.cqrs.shared.domain.bus.query;

public final class QueryHandlerExecutionError extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3727855636897950345L;

	public QueryHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}
