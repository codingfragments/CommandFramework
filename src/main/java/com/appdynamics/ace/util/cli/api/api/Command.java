package com.appdynamics.ace.util.cli.api.api;

import org.apache.commons.cli.Option;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.marx
 * Date: 25.09.13
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
public interface Command {

    public int execute(OptionWrapper options) throws CommandException;

    String getName();

    List<Option> getCLIOptions();

    String getDescription();

    public String getHelp();
}
