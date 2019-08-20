package zh.learn;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class EncryptionTest {
    @Test
    public void testEncryption() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keyGenerator.generateKey();

            System.out.println(myDesKey.getEncoded().length);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
