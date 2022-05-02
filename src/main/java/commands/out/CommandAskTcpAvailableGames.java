package main.java.commands.out;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import main.java.client.ClientTCP;
import main.java.commands.CommandFormatter;
import main.java.commands.CommandTCP;
import main.java.console.DebugLogger;
import main.java.console.DebugType;

// GAME?***

public class CommandAskTcpAvailableGames extends CommandTCP {

    public CommandAskTcpAvailableGames(PrintWriter pw) {
        super(pw);
    }

    @Override
    public void execute(ClientTCP client, String[] args) {

        DebugLogger.print(DebugType.CONFIRM, "COMMAND : ask available game command (GAME?)");

        try {
            client.getOutputStream().write(CommandFormatter.formatForTCP(new String[] {args[0]}));
            client.getOutputStream().flush();
            DebugLogger.print(DebugType.COM, "CLIENT : " + args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void execute(ClientTCP clientTCP, LinkedList<Integer> command) {
        // TODO Auto-generated method stub
        
    }
    
}
