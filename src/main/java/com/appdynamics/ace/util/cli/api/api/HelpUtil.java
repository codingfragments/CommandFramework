package com.appdynamics.ace.util.cli.api.api;

import org.apache.commons.cli.Option;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.marx
 * Date: 26.09.13
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class HelpUtil {
    private static final String CONST_SPACES = "            ";

    public static String getCommandHelp(Command cmd) {
        StringBuilder erg = new StringBuilder();

        erg.append("---  Description").append("\n")
            .append(cmd.getDescription()).append("\n")
            .append("---  Options").append("\n");

        for (Option o: cmd.getCLIOptions()) {
            erg.append(o.getOpt())
               .append((o.getOpt().length() < CONST_SPACES.length())?CONST_SPACES.substring(o.getOpt().length()):"\t")
               .append(" : ")
               .append(o.isRequired()?"(required) ":"(optional) ")
               .append(o.getDescription())
               .append("\n");

        }
        return erg.toString();


    }
}
