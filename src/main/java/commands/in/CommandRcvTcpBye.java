package main.java.commands.in;

import java.io.PrintWriter;
import java.util.LinkedList;

import main.java.GameInfo;
import main.java.client.ClientTCP;
import main.java.commands.CommandTCP;
import main.java.console.DebugLogger;
import main.java.console.DebugType;

// GOBYE***

public class CommandRcvTcpBye extends CommandTCP {

    public CommandRcvTcpBye(PrintWriter pw) {
        super(pw);
    }

    @Override
    public void execute(ClientTCP clientTCP, LinkedList<Integer> command) {
        DebugLogger.print(DebugType.CONFIRM, "COMMAND : GOBYE");

        DebugLogger.print(DebugType.COM, "SERVER : GOBYE");
        
        GameInfo.clear();
    }

    @Override
    public void execute(ClientTCP clientTCP, String[] args) {
        // TODO Auto-generated method stub
        
    }
    
    
}
