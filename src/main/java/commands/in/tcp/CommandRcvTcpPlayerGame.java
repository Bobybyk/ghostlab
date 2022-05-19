package main.java.commands.in.tcp;

import java.io.PrintWriter;
import java.util.LinkedList;

import main.java.client.ClientTCP;
import main.java.commands.CommandTCP;
import main.java.console.DebugLogger;
import main.java.console.DebugType;
import main.java.game.GameInfo;
import main.java.game.Games;

// LIST! m s***

public class CommandRcvTcpPlayerGame extends CommandTCP {

    public CommandRcvTcpPlayerGame(PrintWriter pw) {
        super(pw);
    }

    @Override
    public void execute(ClientTCP client, LinkedList<Integer> command) {

        DebugLogger.print(DebugType.CONFIRM, "COMMAND : LIST!");

        if (command.size() < 12) {
            DebugLogger.print(DebugType.WARNING, "[CommandRcvTcpPlayerGame/WARNING] : les informations données par le serveur sont incomplétes, cette commande sera ignorée");
            return;
        }

        // read "m" uint8
        int gameId = command.get(6);
        // read "s" uint8
        int nbrPlayers = command.get(8);

        int width = -1;
        int height = -1;

        try {
            width = GameInfo.games.get(gameId).getWidth();
            height = GameInfo.games.get(gameId).getHeight();
            GameInfo.games.add(gameId, new Games(nbrPlayers, height, width));
        } catch (IndexOutOfBoundsException e) {
            GameInfo.games.add(gameId, new Games(nbrPlayers, height, width));
            return;
        }

        DebugLogger.print(DebugType.COM, "SERVER : LIST! " + gameId + " " + nbrPlayers);
        
    }

    @Override
    public void execute(ClientTCP clientTCP, String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
