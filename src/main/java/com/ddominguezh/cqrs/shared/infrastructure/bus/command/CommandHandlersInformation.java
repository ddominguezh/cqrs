package com.ddominguezh.cqrs.shared.infrastructure.bus.command;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;

import com.ddominguezh.cqrs.shared.domain.CQRSPropertyUtils;
import com.ddominguezh.cqrs.shared.domain.bus.command.Command;
import com.ddominguezh.cqrs.shared.domain.bus.command.CommandHandler;
import com.ddominguezh.cqrs.shared.domain.bus.command.CommandNotRegisteredError;

public final class CommandHandlersInformation {

	@SuppressWarnings("rawtypes")
	HashMap<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;

    @SuppressWarnings("rawtypes")
	public CommandHandlersInformation() {
        Reflections reflections = new Reflections(CQRSPropertyUtils.getInstance().getPackage());
        Set<Class<? extends CommandHandler>> classes = reflections.getSubTypesOf(CommandHandler.class);

        indexedCommandHandlers = formatHandlers(classes);
    }

    @SuppressWarnings("rawtypes")
	public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private HashMap<Class<? extends Command>, Class<? extends CommandHandler>> formatHandlers(
        Set<Class<? extends CommandHandler>> commandHandlers
    ) {
        HashMap<Class<? extends Command>, Class<? extends CommandHandler>> handlers = new HashMap<Class<? extends Command>, Class<? extends CommandHandler>>();

        for (Class<? extends CommandHandler> handler : commandHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
    
}
