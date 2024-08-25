package com.imguru.tcp_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        // this server is capable of establishing a single connection
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(12345);
            System.out.println("SERVER STARTED@ PORT:12345");
            while(true){
                Socket clientSocket = serverSocket.accept();
                clientHandler(clientSocket);
            }
        } catch(Exception e){

        }
    }

    private static void clientHandler(Socket clientSocket) throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outStream = clientSocket.getOutputStream();
        int byteRead;
        // read the input from the client
        while((byteRead = inputStream.read())!=-1){
            // print it in byte format at server end
            System.out.printf("%02X ", byteRead);
            // send it in byte format at client side
            outStream.write(byteRead);
        }
    }
}
