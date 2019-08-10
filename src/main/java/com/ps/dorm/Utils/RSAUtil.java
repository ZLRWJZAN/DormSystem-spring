package com.ps.dorm.Utils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {
   public static void main(String[] args) throws Exception {
      // 生成密钥对
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
      keyPairGenerator.initialize(512);
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
      RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
      // 格式化私钥
      PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

      Cipher cipher = Cipher.getInstance("RSA");  // 确定算法
      cipher.init(Cipher.ENCRYPT_MODE, privateKey);  // 确定加密密钥
      byte[] result = cipher.doFinal("哈哈哈哈哈".getBytes());  // 加密
      System.out.println(Base64.getEncoder().encode(result));

      // 格式化公钥
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
      keyFactory = KeyFactory.getInstance("RSA");
      PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

      cipher = Cipher.getInstance("RSA"); // 确定算法
      cipher.init(Cipher.DECRYPT_MODE, publicKey);  // 确定公钥
      System.out.println("解密： " + new String(cipher.doFinal(result))); // 解密
   }
}