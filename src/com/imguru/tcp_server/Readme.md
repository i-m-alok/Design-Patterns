# Use of TLS 
1. Data Protection:
   - TLS encrypts the data, making it unreadable to unauthorized parties who might intercept the communication. 
2. Authentication:
   - TLS ensures that the parties involved in the communication are who they claim to be, preventing man-in-the-middle attacks.
3. Data Integrity:
   - TLS provides mechanisms to detect any tampering with the data during transmission, ensuring that the data received is the same as the data sent.
# TLS Server 

1. Create a KEYSTORE 
    ```shell
    keytool -genkeypair -alias serverkey -keyalg RSA -keystore server.keystore -keysize 2048
    ```
2. Load KEYSTORE and Password
3. Initialize the **SSLContext** using key managers loaded from keystore which contains server certificates and private key
4. Create **SSLServerSocketFactory** and create SSLServerSocket to accept secure connections

# How to connect to TLS Server?
-   ```shell
    openssl s_client -connect localhost:8082
    ```
- By default,`openssl s_client` will report the certificate validation errors but will continue with the connection unless we specify otherwise.
- To force `openssl s_client` to fail and close the connection when the certificate validation errors, use `-verify_return_error` option along with `-verify` option set to 1
- ```shell
   openssl s_client -connect localhost:8082 -verify 1 -verify_return_error
   ```
- Error will look like `verify error:num=18:self signed certificate`
- When we use `nc (netcat)` to connect to a secure server (SSLServerSocket), the connection may close because `nc` does not perform the necessary TLS handshake.

# How to see the TLS handshake?
- Add java vm options `-Djavax.net.debug=ssl:handshake`

# Steps in the TLS Handshake
1. ClientHello:
   - The client sends a "ClientHello" message to the server, which includes information such as:
   - The TLS version supported by the client.
   - A list of cipher suites supported by the client.
   - Random data for use in the encryption process.
   - Any additional extensions or information necessary for the handshake.
2. ServerHello:
   - The server responds with a "ServerHello" message, which includes:
   - The TLS version selected by the server.
   - The cipher suite selected from the client's list.
   - Random data for use in the encryption process.
   - Any additional extensions or information necessary for the handshake.
3. Server Certificate:
   - The server sends its digital certificate to the client. This certificate contains the server's public key and is used by the client to authenticate the server.
4. Server Key Exchange (optional):
   - This step is required if the server's certificate does not contain all the information needed for key exchange (for example, with Diffie-Hellman key exchange). 
5. Certificate Request (optional):
   - The server may request a certificate from the client for mutual authentication.
6. ServerHelloDone:
   - The server indicates it has finished its part of the negotiation with a "ServerHelloDone" message.
7. Client Certificate (optional):
   - If the server requested a certificate, the client sends its certificate to the server.
8. Client Key Exchange:
   - The client sends the "Client Key Exchange" message, which contains the pre-master secret. This secret is encrypted with the server’s public key from the server’s certificate.
9. Certificate Verify (optional):
   - If the client sent a certificate, it sends a message to prove ownership of the private key associated with the certificate.
10. Change Cipher Spec:
    - The client sends a "Change Cipher Spec" message to indicate that it will start using the newly negotiated cipher suite and keys for encryption.
11. Client Finished:
    - The client sends a "Finished" message, which is encrypted with the new cipher and keys. This message contains a hash of the entire handshake so far.
12. Change Cipher Spec:
    - The server sends a "Change Cipher Spec" message to indicate that it will start using the newly negotiated cipher suite and keys for encryption.
13. Server Finished:
    - The server sends a "Finished" message, which is encrypted with the new cipher and keys. This message contains a hash of the entire handshake so far.
```text
Client                         Server
------                         ------
ClientHello  ----------------->
                               ServerHello
                               Certificate
                               ServerHelloDone
                     <-----------------
ClientKeyExchange  ----------------->
ChangeCipherSpec   ----------------->
Finished           ----------------->
                               ChangeCipherSpec
                     <-----------------
                               Finished
                     <-----------------
```

# Notes

* Calling ***sslSocket.startHandshake()*** prepares the server for the incoming handshake messages from client and ensures all necessary components (e.g., certificates, keys) are loaded and ready. 
* **Secure TCP Server(TLS Server)** : Any data will exchange if and only if TLS Handshake is successful.

