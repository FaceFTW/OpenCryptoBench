package org.FaceStudios.OpenCryptoBench.Crypto.Algorithms.DiffieHellman;

public class DHKeyExchangeCryptoOps {

   public static void performDHBench(int n){

    final EndUser alice = new EndUser();
    final EndUser bob   = new EndUser();

    alice.generateKeys();
    bob.generateKeys();

    alice.receivePublicKeyFrom(bob);
    bob.receivePublicKeyFrom(alice);

    alice.generateCommonSecretKey();
    bob.generateCommonSecretKey();

    alice.encryptAndSendMessage("Bob! Guess Who I am.", bob);


    bob.whisperTheSecretMessage();

   }
}