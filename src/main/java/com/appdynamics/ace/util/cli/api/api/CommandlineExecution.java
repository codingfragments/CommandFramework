package com.appdynamics.ace.util.cli.api.api;

import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.marx
 * Date: 25.09.13
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public class CommandlineExecution {

    private final HashMap<String, Command> _commands;
    private final Options _simpleOptions;
    private String _cliName;

    public static final String CONST_CMD_HELP = "help";
    public  static final String CONST_CMD_DEBUG = "debug";
    private boolean _debug;
    private boolean _helpVerboseEnabled;


    public CommandlineExecution(String name)  {



        _commands = new HashMap<String,Command>();
        _cliName = name;


        _simpleOptions = new Options();
        _simpleOptions.addOption(new Option(CONST_CMD_HELP, "Show Command help."));
        _simpleOptions.addOption(new Option(CONST_CMD_DEBUG, "Show more Debug output."));


    }

    public void addCommand(Command cmd) {
        if (!_commands.containsKey(cmd.getName())) _commands.put(cmd.getName(),cmd);

    }

    public Command getCommand(String cmd) {

        if (_commands.containsKey(cmd)) return _commands.get(cmd);

        return new HelpCommand();
    }




    public int execute(String[] args)  {
        Command cmd = null;
        if (args.length >0) cmd = getCommand(args[0]);
        else cmd = getCommand(CONST_CMD_HELP);

        try {



        String[] args2  = (args.length > 1)?Arrays.copyOfRange(args, 1, args.length):new String[]{};
        _debug = false;

        Parser parser = new PosixParser();

        try {
            CommandLine hlpCmdLine = parser.parse(_simpleOptions, args2,false);



            if (hlpCmdLine.hasOption(CONST_CMD_HELP)) {
                System.out.println(cmd.getHelp());
                return 0;
            }
        } catch (ParseException ex) {
            // just Ignore Parsing Exception while parsing for help as the only option !!!!
        }

        Options opts = new Options();

        List<Option> cmdOptions = cmd.getCLIOptions();

        for (Option o : cmdOptions) {
            opts.addOption(o);
        }

        for (Object o: _simpleOptions.getOptions()) {
            opts.addOption((Option) o);
        }
        CommandLine cmdline = parser.parse(opts, args2);

        if (cmdline.hasOption(CONST_CMD_DEBUG)) {
                _debug = true;
        }

        return cmd.execute(new OptionWrapper(cmdline, this));
      } catch (ParseException e) {
          System.out.println("Some error occurred while Parsing the commandline :");
          System.out.println(e.getMessage());

          System.out.println("----------");
          System.out.println(cmd.getHelp());
          System.out.println("--");
          if (_debug) e.printStackTrace();
          return -1;
      } catch (CommandException e) {
          System.out.println("Some error occurred while Executing the commandline :");
          System.out.println(e.getMessage());
          if (_debug) e.printStackTrace();
          return -2;
      }
    }

    public String getName() {
        return _cliName;
    }

    public Collection<Command> getCommands() {
        return _commands.values();
    }

    public boolean isDebug() {
        return _debug;
    }

    public void setHelpVerboseEnabled(boolean helpVerboseEnabled) {
        _helpVerboseEnabled = helpVerboseEnabled;
    }

    public boolean isHelpVerboseEnabled() {
        return _helpVerboseEnabled;
    }
}
