package ru.geekbrains;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
public class HttpServer {

    private static String WWW = "C:\\Users\\svsmirnov\\Desktop\\Java_architect\\Lesson1\\src\\main\\java\\ru\\geekbrains\\www";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            log.info("Server started!");
            ClientConnection clientConnection = new ClientConnection(serverSocket, WWW);
            clientConnection.connectClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
