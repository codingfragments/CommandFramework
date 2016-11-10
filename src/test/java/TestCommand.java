import com.appdynamics.ace.util.cli.api.api.AbstractCommand;
import com.appdynamics.ace.util.cli.api.api.Command;
import com.appdynamics.ace.util.cli.api.api.CommandException;
import com.appdynamics.ace.util.cli.api.api.OptionWrapper;
import org.apache.commons.cli.Option;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan.marx on 10.11.16.
 */


public class TestCommand extends AbstractCommand {
    private String _tser;

    public TestCommand(String tser) {


        _tser = tser;
    }

    public TestCommand() {
        this("TestCommand");

    }

    @Override
    protected List<Option> getCLIOptionsImpl() {

            List<Option> opts = new ArrayList<>();
            opts.add(new Option("test",true,"SimpleDescription"));
            return opts ;
    }


    @Override
    protected int executeImpl(OptionWrapper options) throws CommandException {
        System.out.println("TEST Command Executed");
        System.out.println("Additional Parameter :");
        for (String a : options.getArgs()) {
            System.out.println("  :"+a);
        }
        return 0;
    }

    @Override
    public String getName() {
        return _tser;
    }



    @Override
    public String getDescription() {
        return "BAsic Command description, nothing weird";
    }


}
