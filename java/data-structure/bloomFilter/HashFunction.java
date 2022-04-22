package bloomFilter;

/**
 * @author zhangminjie
 * @since 2022/4/21
 */
public interface HashFunction {

    int hash(int seed, String val);
}
