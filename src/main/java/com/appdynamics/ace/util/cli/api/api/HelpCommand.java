package com.appdynamics.ace.util.cli.api.api;

import org.apache.commons.cli.Option;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.marx
 * Date: 25.09.13
 * Time: 17:49
 */
public class HelpCommand implements Command {

    public HelpCommand() {

    }

    @Override
    public int execute(OptionWrapper options) {
        System.out.println("Help :");
        System.out.println("======\n");
        System.out.println("Usage : "+options.getCommandEcecution().getName() +" <COMMAND>\n");

        if (!options.getCommandEcecution().isHelpVerboseEnabled()) {
            System.out.println(" To get more help on Commands please execute "+options.getCommandEcecution().getName() +" <COMMAND> -help");
            System.out.println("--\nCommands Available:\n");
        }

        for (Command cmd : options.getCommandEcecution().getCommands()){

            if (options.getCommandEcecution().isHelpVerboseEnabled()) {
                System.out.println("==  Command\n");
                System.out.println( cmd.getName());
                System.out.println("");

                System.out.println(cmd.getHelp());
                System.out.println("");
            } else {
                System.out.println(cmd.getName());
            }


        }


        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public List<Option> getCLIOptions() {
        return new ArrayList<Option>();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getDescription() {
        return "Show Help for Command.";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getHelp() {
        return HelpUtil.getCommandHelp(this);
    }
}
