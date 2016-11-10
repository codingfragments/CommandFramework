import com.appdynamics.ace.util.cli.api.api.CommandlineExecution;
import org.junit.Test;

/**
 * Created by stefan.marx on 25.09.15.
 */


public class CommandWrapperTest {
    @Test
    public void testCommandWrapper(){
        CommandlineExecution cle = new CommandlineExecution("GroovyCli");
        cle.setHelpVerboseEnabled(false);

        cle.addCommand(new TestCommand() );



        String [] args2 = new String[] {};

        cle.execute(args2);
    }

    @Test
    public void testCommandWrapperExplicite(){
        CommandlineExecution cle = new CommandlineExecution("GroovyCli");
        cle.setHelpVerboseEnabled(false);

        cle.addCommand(new TestCommand() );



        String [] args2 = new String[] {"TestCommand"};

        cle.execute(args2);
    }

    @Test
    public void testCommandWrapperExpliciteWrong(){
        CommandlineExecution cle = new CommandlineExecution("GroovyCli");
        cle.setHelpVerboseEnabled(false);

        cle.addCommand(new TestCommand() );



        String [] args2 = new String[] {"TestCommand_doesnt_exist"};

        cle.execute(args2);
    }
    @Test
    public void testCommandWrapperNotMain(){
        CommandlineExecution cle = new CommandlineExecution("GroovyCli");
        cle.setHelpVerboseEnabled(false);

        cle.setUseMainOnly(false);
        cle.addCommand(new TestCommand() );



        String [] args2 = new String[] {};

        cle.execute(args2);
    }

    @Test
    public void testCommandWrapperHelp(){
        CommandlineExecution cle = new CommandlineExecution("GroovyCli");
        cle.setHelpVerboseEnabled(false);

        cle.addCommand(new TestCommand() );



        String [] args2 = new String[] {"-help"};

        cle.execute(args2);
    }

    @Test
    public void testCommandWrapperMainHelp(){
        CommandlineExecution cle = new CommandlineExecution("GroovyCli");
        cle.setHelpVerboseEnabled(false);

        cle.addCommand(new TestCommand() );



        String [] args2 = new String[] {"help"};

        cle.execute(args2);
    }


    @Test
    public void testCommandWrapperMultiple(){
        CommandlineExecution cle = new CommandlineExecution("GroovyCli");
        cle.setHelpVerboseEnabled(false);

        cle.addCommand(new TestCommand() );
        cle.addCommand(new TestCommand("tser") );



        String [] args2 = new String[] {};

        cle.execute(args2);
    }
}
