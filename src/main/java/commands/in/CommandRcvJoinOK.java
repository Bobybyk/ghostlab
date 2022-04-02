package main.java.commands.in;

import java.io.IOException;
import java.io.PrintWriter;

import main.java.client.Client;
import main.java.client.ClientTCP;
import main.java.commands.Command;
import main.java.console.DebugLogger;
import main.java.console.DebugType;

/// REGOK m***

public class CommandRcvJoinOK extends Command{

    public CommandRcvJoinOK(PrintWriter pw) {
        super(pw);
    }

    @Override
    public void execute(ClientTCP client, String[] args) {

        DebugLogger.print(DebugType.CONFIRM, "Command identified : REGOK");

        byte b;
        try {
            // read " "
            b = (Integer.valueOf(client.getBufferedReader().read())).byteValue();
            // read "m" uint8
            b = (Integer.valueOf(client.getBufferedReader().read())).byteValue();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }    
        
        int uint8GameNum = b & 0xFF;
    }
    
}
