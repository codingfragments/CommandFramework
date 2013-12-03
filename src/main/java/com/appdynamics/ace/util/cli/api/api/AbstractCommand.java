package com.appdynamics.ace.util.cli.api.api;

import org.apache.commons.cli.Option;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.marx
 * Date: 26.09.13
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCommand implements Command{



    @Override
    public List<Option> getCLIOptions() {

        return getCLIOptionsImpl();
    }

    protected abstract List<Option> getCLIOptionsImpl();

    @Override
    public int execute(OptionWrapper options) throws CommandException {
        return executeImpl(options);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getHelp(){
        return HelpUtil.getCommandHelp(this);
    }

    protected abstract int executeImpl(OptionWrapper options) throws CommandException;
}
