package main.java.commands.in;

import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;

import main.java.GameInfo;
import main.java.client.ClientUDP;
import main.java.commands.CommandFormatter;
import main.java.commands.CommandUDP;
import main.java.console.DebugLogger;
import main.java.console.DebugType;

// GHOST x y+++

public class CommandRcvUdpGhostPos extends CommandUDP {

    public CommandRcvUdpGhostPos(DatagramSocket socket, InetAddress addr) {
        super(socket, addr);
    }

    @Override
    public void execute(ClientUDP clientTCP, String[] args) {
        
        DebugLogger.print(DebugType.CONFIRM, "Command identified : GHOST");

        GameInfo.fantom.x = Integer.parseInt(args[1]);
        GameInfo.fantom.y = Integer.parseInt(args[2]);

    }
    
}
