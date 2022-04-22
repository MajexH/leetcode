package bloomFilter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangminjie
 * @since 2022/4/21
 */
public class MD5HashFunction implements HashFunction {

    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hash(int seed, String val) {

        if (seed <= 0) {
            throw new RuntimeException("seed cannot be negative");
        }

        byte[] data = null;
        messageDigest.update((byte) (seed + ThreadLocalRandom.current().nextInt(seed)));
        data = messageDigest.digest(val.getBytes(StandardCharsets.UTF_8));

        int res = 0;
        for (byte b : data) {
            res = 31 * res + b;
        }
        return res;
    }

    public static void main(String[] args) {
        MD5HashFunction md5HashFunction = new MD5HashFunction();

        System.out.println(md5HashFunction.hash(1, "4512341234"));
    }
}
