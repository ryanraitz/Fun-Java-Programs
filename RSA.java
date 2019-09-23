//Created by Ryan Raitz on 23 April 2018
//Private and public key generator, encrypter and decrypter

import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;

public class RSA 
{
 public static void main(String[]args) throws Exception 
 {
   KeyPair kp = buildKeyPair();
   PublicKey pubK = keyPair.getPublic();
   PrivateKey privK = keyPair.getPrivate();
        
   byte [] encrypted = encrypt(privK, "Keep your secrets");     
   System.out.println(new String(encrypted));     //encrypted message
        
   byte[] decrypted = decrypt(pubK, encrypted);                                 
   System.out.println(new String(decrypted));     //decrypted message
 }

 public static KeyPair buildKeyPair() throws NoSuchAlgorithmException 
 {
   final int size = 2048;
   KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
   generator.initialize(size);
         
   return generator.genKeyPair();
 }

 public static byte[] encrypt(PrivateKey pvK, String s) throws Exception 
 {
    Cipher c = Cipher.getInstance("RSA");  
    c.init(Cipher.ENCRYPT_MODE, pvK);  

    return c.doFinal(s.getBytes());  
 }
    
 public static byte[] decrypt(PublicKey pbK, byte[]encrypted) throws Exception 
 {
    Cipher c = Cipher.getInstance("RSA");  
    c.init(Cipher.DECRYPT_MODE, pbK);
        
    return c.doFinal(encrypted);
 }
}