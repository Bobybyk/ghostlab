package main.java.commands.out;

import java.io.PrintWriter;

import main.java.client.Client;
import main.java.client.ClientTCP;
import main.java.commands.Command;

// UNREG***

public class CommandAskUnregister extends Command{

    public CommandAskUnregister(PrintWriter pw) {
        super(pw);
    }

    @Override
    public void execute(ClientTCP client, String[] args) {
        
    }
    
}