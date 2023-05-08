package com.ddominguezh.cqrs.shared.infrastructure.bus.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.ddominguezh.cqrs.shared.domain.bus.query.QueryHandler;
import com.ddominguezh.cqrs.shared.domain.bus.query.QueryNotRegisteredError;

public class QueryHandlersInformationTest {

	@SuppressWarnings({ "unused", "rawtypes" })
	@Test
	public void search_query_class() throws QueryNotRegisteredError {
		QueryHandlersInformation information = new QueryHandlersInformation();
		Class<? extends QueryHandler> queryHandlerClass = information.search(TestQuery.class);
	}
	
	@Test
	public void search_query_class_not_registered() {
		QueryHandlersInformation information = new QueryHandlersInformation();
		QueryNotRegisteredError exception = assertThrows(QueryNotRegisteredError.class, () -> information.search(TestQueryNotHandler.class));
		assertEquals("The query <class com.ddominguezh.cqrs.shared.infrastructure.bus.query.TestQueryNotHandler> hasn't a query handler associated", exception.getMessage());
	}
}
