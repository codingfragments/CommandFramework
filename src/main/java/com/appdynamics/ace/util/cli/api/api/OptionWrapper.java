package com.appdynamics.ace.util.cli.api.api;

import org.apache.commons.cli.CommandLine;

/**
* Created with IntelliJ IDEA.
* User: stefan.marx
* Date: 26.09.13
* Time: 10:12
* To change this template use File | Settings | File Templates.
*/
public class OptionWrapper {
    private final CommandLine _cmd;
    private CommandlineExecution _commandExecution;

    public OptionWrapper(CommandLine cmd, CommandlineExecution execution) {
        _cmd = cmd;
        _commandExecution = execution;
    }

    public boolean hasOption(String name) {
        return _cmd.hasOption(name);
    }

    public String getOptionValue(String name) {
        return _cmd.getOptionValue(name);
    }

    public String getOptionValue(String name, String defaultValue) {
        if (hasOption(name)) return getOptionValue(name);
        else return defaultValue;
    }

    public CommandlineExecution getCommandEcecution() {
        return _commandExecution;
    }
}
