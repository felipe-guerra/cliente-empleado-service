package org.miproyecto.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CifradoAESUtil {

    private static final String ALGORITMO = "AES/ECB/PKCS5Padding";
    private static final String TIPO_CLAVE = "AES";

    /**
     * Cifra un texto con AES y lo devuelve en Base64.
     *
     * @param texto Texto plano a cifrar.
     * @param clave Clave secreta de 16 caracteres.
     * @return Texto cifrado en Base64.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    public static String cifrar(String texto, String clave) throws Exception {
        validarClave(clave);

        SecretKeySpec keySpec = new SecretKeySpec(clave.getBytes("UTF-8"), TIPO_CLAVE);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        byte[] textoCifrado = cipher.doFinal(texto.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    /**
     * Descifra un texto cifrado en Base64 con AES.
     *
     * @param textoCifrado Texto cifrado en Base64.
     * @param clave        Clave secreta de 16 caracteres.
     * @return Texto original descifrado.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    public static String descifrar(String textoCifrado, String clave) throws Exception {
        validarClave(clave);

        SecretKeySpec keySpec = new SecretKeySpec(clave.getBytes("UTF-8"), TIPO_CLAVE);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);

        byte[] bytesDescifrados = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(bytesDescifrados, "UTF-8");
    }

    /**
     * Valida que la clave tenga 16 caracteres.
     */
    private static void validarClave(String clave) {
        if (clave == null || clave.length() != 16) {
            throw new IllegalArgumentException("La clave debe tener exactamente 16 caracteres.");
        }
    }



}
