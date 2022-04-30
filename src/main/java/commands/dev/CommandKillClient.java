package main.java.commands.dev;

import java.io.PrintWriter;

import main.java.client.ClientTCP;
import main.java.commands.CommandTCP;
import main.java.console.DebugLogger;
import main.java.console.DebugType;

public class CommandKillClient extends CommandTCP {

    public CommandKillClient(PrintWriter pw) {
        super(pw);
    }

    @Override
    public void execute(ClientTCP clientTCP, String[] args) {
        DebugLogger.print(DebugType.CONFIRM, "kill command");
        clientTCP.closeSocket();
    }
    
}