package com.crio.jukebox.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.exception.Nosuchcommandexception;


public class CommandInvoker {
    private static final Map<String, Icommand> commandMap = new HashMap<>();

    public void register(String commandName, Icommand command){
        commandMap.put(commandName,command);
    }

    private Icommand get(String commandName){
        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName, List<String> tokens) throws Nosuchcommandexception{
        Icommand command = get(commandName);
        if(command == null){
            throw new Nosuchcommandexception();
        }
        command.execute(tokens);
    }

}
