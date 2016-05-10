import com.appdynamics.ace.util.cli.api.api.CommandlineExecution;

/**
 * Created by stefan.marx on 25.09.15.
 */
public class CommandWrapperTest {
    public void testCommandWrapper(){
        CommandlineExecution cle = new CommandlineExecution("Test");


        cle.execute(new String[] {});
    }

}
