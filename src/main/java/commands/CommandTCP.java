package main.java.commands;

import java.io.PrintWriter;

import main.java.client.ClientTCP;

public abstract class CommandTCP {

	private PrintWriter out;

	public CommandTCP(PrintWriter pw) {
		this.out = pw;
	}

	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}

	public abstract void execute(ClientTCP clientTCP, String[] args);
}