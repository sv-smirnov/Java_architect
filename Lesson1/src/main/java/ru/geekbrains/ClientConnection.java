package ru.geekbrains;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class ClientConnection {
    ServerSocket serverSocket;
    String WWW;

    public ClientConnection(ServerSocket serverSocket, String WWW) {
        this.serverSocket = serverSocket;
        this.WWW = WWW;
    }

    public void connectClients() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            log.info("New client connected!");
            ClientHandler clientHandler = new ClientHandler(socket, WWW);
            new Thread(clientHandler::handleRequest).start();
        }
    }
}
