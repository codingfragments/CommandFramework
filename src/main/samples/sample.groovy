#!/usr/bin/env groovy

@Grab(group='com.appdynamics.ace.cli', module='CommandFramework', version='1.6')
import com.appdynamics.ace.util.cli.api.api.CommandlineExecution
import com.appdynamics.ace.util.cli.api.groovy.CommandWrapper

println("READY")   ;
CommandlineExecution cle = new CommandlineExecution("GroovyCli");
cle.setHelpVerboseEnabled(false);

cle.addCommand(new CommandWrapper("test","TEST",
        [ string: [desc:"string to print",args:true,opt:false]], {p ->

    println "Hello $p.string"
}));

cle.execute(args);