package bloomFilter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author zhangminjie
 * @since 2022/4/19
 */
public class BloomFilter {

    /**
     * 存储最后的 bit 位的地方
     */
    private BitSet bitSet;

    /**
     * 当前 bitset 里面的数据大小
     */
    private int n;

    /**
     * 最大容量
     */
    private int m;

    /**
     * hash function will be called k times
     */
    private int k;

    /**
     * hash function 要怎么 hash 的方法
     */
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    /**
     * hash function
     */
    private static MessageDigest MESSAGE_DIGEST;

    /**
     * hash function seed
     */
    private static final List<Integer> SEEDS = Arrays.asList(3, 4, 5);

    private static final List<HashFunction> HASH_FUNCTIONS = Collections.singletonList(new MD5HashFunction());

    static {
        try {
            MESSAGE_DIGEST = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println("error init MESSAGE_DIGEST");
        }
    }


    public BloomFilter(int k) {
        this.m = 100000;
        this.bitSet = new BitSet(this.m);
        this.n = 0;
        this.k = k;
    }

    /**
     * (1 - e ^(-kn\m))^k
     */
    private double calculateFalsePositive() {
        return Math.pow(1 - Math.pow(Math.E, -this.k * this.n / (double) this.m), this.k);
    }

    public void add(String key) {
        int[] res = createHashesByFunction(key, this.k);
        for (int index : res) {
            bitSet.set(index % (this.m - 1), true);
        }
        this.n++;
    }

    public boolean mayContains(String key) {
        if (Objects.isNull(key)) {
            return false;
        }

        boolean res = true;
        int[] hashes = createHashesByFunction(key, this.k);

        for (int index : hashes) {
            res = res && bitSet.get(index % (this.m - 1));
        }
        return res;
    }

    /**
     * 执行 hash 数据的结果
     * 这是模拟的另外一个算法 create 的 hash
     *
     * @param data          需要 hash 的数据
     * @param hashFrequency hash 的次数
     *
     * @return hash 次数大小的 结果
     */
    private static int[] createHashes(byte[] data, int hashFrequency) {

        int[] res = new int[hashFrequency];

        int k = 0;
        byte salt = 1;
        while (k < hashFrequency) {
            byte[] digest = null;
            // 生成 hash 算法后的数字
            synchronized (MESSAGE_DIGEST) {
                MESSAGE_DIGEST.update(salt);
                salt++;
                digest = MESSAGE_DIGEST.digest(data);
            }
            // 取 hash 值 四个为一组
            for (int i = 0; i < digest.length / 4 && k < hashFrequency; i++) {
                int h = 0;
                for (int j = (i * 4); j < (i * 4) + 4; j++) {
                    h <<= 8;
                    // digest 只取 8 位
                    h |= ((int) digest[j]) & 0xFF;
                }
                res[k] = h;
                k++;
            }
        }
        return res;
    }

    private static int[] createHashesByFunction(String data, int hashFrequency) {
        int[] res = new int[hashFrequency];
        for (int i = 0; i < hashFrequency; i++) {
            res[i] = HASH_FUNCTIONS.get(i % HASH_FUNCTIONS.size()).hash(SEEDS.get(i % SEEDS.size()), data);
        }
        return res;
    }

    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter(3);
        filter.add("test");

        System.out.println(filter.mayContains("test"));
        System.out.println(filter.mayContains("412312312312312312312"));
    }
}
