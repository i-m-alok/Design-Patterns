package com.imguru.tcp_server;


import javax.net.ssl.*;
import java.io.*;
import java.net.Socket;
import java.security.KeyStore;

public class SecureTCPServer {
    private static final String KEYSTORE = "server.keystore";
    private static final String KEYSTORE_PASSWORD = "test@123";

    public static void main(String[] args) throws Exception {

        // Load the KEYSTORE
        KeyStore keyStore = loadKeyStore();

        // create a KeyManagerFactory which manages the key for secure links and initializes the keystore
        KeyManagerFactory keyManager = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManager.init(keyStore,  KEYSTORE_PASSWORD.toCharArray());

        // create a SSLContext which provides the environment for creating secure socket connections
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManager.getKeyManagers(), null, null);
        // create SSL Server Socket Factory
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

        // get the port from VM Arguments (-Dserver.port=8082)
        Integer PORT = Integer.valueOf(System.getProperty("server.port"));
        try(SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT)){
            System.out.println("Server is listening at PORT::"+ PORT);
            try {
                while (true) {
                    SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                    // check if the session is using the TLS protocol or not
                    if(sslSocket.getSession().isValid()){
                        sslSocket.startHandshake();
                        clientHandler(sslSocket);
                    } else{
                        // if it is not a valid session, close the connection
                        sendHandshakeFailureMessage(sslSocket);
                    }
                }
            } catch (SSLHandshakeException e){
                System.err.println("SSL handshake failed: " + e.getMessage());
            }
            catch (Exception ex){
                System.err.println("Failed to establish connection: " + ex.getMessage());
            }
        }


    }

    // this method throws the NoSuchAlgorithmException, KeyStoreException or IOException
    private static KeyStore loadKeyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (FileInputStream keyStoreStream = new FileInputStream(KEYSTORE)) {
            keyStore.load(keyStoreStream, KEYSTORE_PASSWORD.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return keyStore;
    }

    private static void clientHandler(Socket clientSocket) throws IOException {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStream outStream = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(outStream, true);
        String clientMessage;
        // read the input from the client
        while((clientMessage = inputStream.readLine() )!= null){
            // print it in byte format at server end
            System.out.printf("Client Message:: %s", clientMessage);
            // send it in byte format at client side
            writer.println("Server Received::"+ clientMessage);
        }
    }

    private static void sendHandshakeFailureMessage(Socket sslSocket) {
        try {
            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Handshake failed. Closing connection.");
        } catch (IOException e) {
            System.err.println("Failed to send handshake failure message: " + e.getMessage());
        } finally {
            try {
                sslSocket.close();
            } catch (IOException e) {
                System.err.println("Failed to close socket: " + e.getMessage());
            }
        }
    }
}
