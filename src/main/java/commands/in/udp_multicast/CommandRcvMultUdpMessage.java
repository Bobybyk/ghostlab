package main.java.commands.in.udp_multicast;

import java.net.DatagramSocket;
import java.net.InetAddress;

import main.java.GameInfo;
import main.java.client.ClientUDP;
import main.java.commands.CommandUDP;
import main.java.console.DebugLogger;
import main.java.console.DebugType;

// MESSA id mess+++

public class CommandRcvMultUdpMessage extends CommandUDP {

    @Override
    public void execute(String[] args) {

        DebugLogger.print(DebugType.CONFIRM, "COMMAND : MESSA");

        System.out.println(args[1] + " : " + args[2]);

        if (args.length < 3) {
            DebugLogger.print(DebugType.WARNING, "[CommandRcvUdpMessage/WARNING] : les informations données par le serveur sont incomplétes, cette commande sera ignorée");
            return;
        }

        DebugLogger.print(DebugType.MESSAGE, "SERVER_" + args[1] + " : " + args[2]);

        GameInfo.messagesHistory.add(args[1] + " : " + args[2]);

    }
    
}
