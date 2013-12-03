package com.appdynamics.ace.util.cli.api.api;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.marx
 * Date: 25.09.13
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */
public class CommandException extends Exception {
    public CommandException(String msg, Throwable t) {
        super(msg,t);
    }

    public CommandException(String s) {
        super(s);
    }
}
