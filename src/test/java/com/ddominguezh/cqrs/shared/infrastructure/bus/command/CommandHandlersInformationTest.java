package com.ddominguezh.cqrs.shared.infrastructure.bus.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.ddominguezh.cqrs.shared.domain.bus.command.CommandHandler;
import com.ddominguezh.cqrs.shared.domain.bus.command.CommandNotRegisteredError;

public class CommandHandlersInformationTest {

	@SuppressWarnings({ "rawtypes", "unused" })
	@Test
	public void search_command_class() throws CommandNotRegisteredError {
		CommandHandlersInformation information = new CommandHandlersInformation();
		Class<? extends CommandHandler> commandHandlerClass = information.search(TestCommand.class);
	}
	
	@Test
	public void search_command_class_not_registered() {
		CommandHandlersInformation information = new CommandHandlersInformation();
		CommandNotRegisteredError exception = assertThrows(CommandNotRegisteredError.class, () -> information.search(TestCommandNotHandler.class));
		assertEquals("The command <class com.ddominguezh.cqrs.shared.infrastructure.bus.command.TestCommandNotHandler> hasn't a command handler associated", exception.getMessage());
	}
}
