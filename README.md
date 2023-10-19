# GHOSTLAB

*This project was carried out as part of my master's studies in fundamental computer science*

This is a demonstration to test client/server communication in a multiplayer mini game. 
It is an attempted to program from scratch at various layers of the network.

## Made work

**Server Side:**
* Parsing client requests
* Processing requests
* Formatting responses for the client
* Sending responses to the client
* Managing server data structures (locks, linked lists, etc.)
* Server architecture:
   * Execution split into different phases, each enclosed within a thread
   * Project hierarchy
* Conversion of bytes to little-endian (for sending **h** and **w**)
* Creation of mazes (.lab files)
* Parsing .lab files and creating a maze in the game structure
* Receiving and processing the "GLIS?" command and sending the response to the client

**Client Side:**
* Wall detection for updating the graphical interface
* Receiving and parsing commands from the server
* Processing commands and storing information from the server
* Parsing client commands (console and graphical interface)
* Formatting and sending commands to the server
* Creating the graphical interface:
   * Login page
   * Game management page
   * Game interface
* System for storing the history of played games (the "historical" command)
* Debugging system

## Compile the Project

### Server

Run the `make` command from the `src/main/c/server` directory.

---

### Client

Run the `compile.sh` script in the `src` directory from the same location.

## Run the Project

### Server

Execute the `server` file generated during compilation with the desired port as an argument.

**Example:**

```bash
./server 12345
```

### Client
Run the launch.sh script located in the src directory (from the same directory).

OR

Execute the following command: java main.java.client.Client (from the src directory).

The following arguments are optional and can be later entered in the graphical interface:

**IP:** The server's IP to connect to
**Port:** The server port to use
**Username:** The username to use in a game. This username must be exactly 8 characters.

Example:

```java
java main.java.client.Client ghostlab-server.com 12345 USERNAME
```

```bash
./launch.sh
```

**To remove .class files (from src):**

```bash
./remove_class.sh
```

## How to Use the Client


### User Section

At launch, if the user hasn't provided connection information, they are prompted to enter the server's information.

Once connected, the "Game Manager" section becomes accessible and allows you to:

Create a game
Join a game
List existing games and their information
Leave the current game
Start the game
Once the game is started, the "game" section allows you to navigate the labyrinth with a visual representation of it. For an optimal view, consider enlarging the window.

If the player encounters a wall while moving, it is automatically added to the labyrinth map.

When the ghosts move, only the last ghost that moved is displayed on the map.

### Developer Section

We've created a debugging system to enable or disable specific feedback.
We've created commands to perform client-side actions independently of the server (help, kill, killclient, etc.).
There are commands to perform these actions from the program.

For more information: Use the "help" command (or the "help" button) in the program.

## Server Architecture

The server continuously waits for connections and delegates protocol handling to a thread. During client/server interactions, multiple threads follow one another in processing client requests, with each thread representing a phase in the lifetime of a game. The different phases are as follows:

1. The client has just connected.
2. The client has created or joined a game.
3. The game has been launched.
4. The game is completed.

Each game has:

- Its own lock to prevent concurrent modifications to the list of players.
- Its own UDP socket used for multicasting and sending private messages.
- 
The multicast IP is unique to the server, with only the port changing for each created game.

Mazes are retrieved from files following these rules:

The first line containing two integers i and j, with i representing the width and j the height.
j lines, each with i columns consisting of 1 or 0, where 1 represents a wall and 0 represents a path.
