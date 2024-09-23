package assimetrica;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import static assimetrica.Simetrico.decrypt;
import static assimetrica.Simetrico.encrypt;

public class Assimetrica {


    public static void main(String[] args) throws Exception {

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512); //tamanho em bit
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String mensagem = "Vou matar o presidente ás 20:00";

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] cipherText = encryptCipher.doFinal(mensagem.getBytes());
        System.out.println("Encriptando mensagem: " + new String(cipherText));

        //Descriptografando
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] plainText = decryptCipher.doFinal(cipherText);
        System.out.println("Decriptando mensagem: " + new String(plainText));

        String voltarMensagem = "Estarei no seu aguardo, apenas mande o sinal.";

        Cipher encriptada = Cipher.getInstance("RSA");
        encriptada.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] texto = encryptCipher.doFinal(voltarMensagem.getBytes());
        System.out.println("Encriptando mensagem: " + new String(texto));

        Cipher descriptar = Cipher.getInstance("RSA");
        descriptar.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] textDescrip = decryptCipher.doFinal(texto);
        System.out.println("Decriptando mensagem: " + new String(textDescrip));




        String mensagemCifrar = "Arthur vai ter que pagar meu jogo.";
        String mensagemCifrada = encrypt(mensagemCifrar);
        String decryptedText = decrypt(mensagemCifrada);

        // Imprime os resultados
        System.out.println("Arthur: " + mensagemCifrar);
        System.out.println("Wallace: " + mensagemCifrada);
        System.out.println("Decrypted Text: " + decryptedText);

    }

}


