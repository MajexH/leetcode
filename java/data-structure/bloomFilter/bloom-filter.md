# 布隆过滤器

布隆过滤器实际上是一个 bit 数组，将每个入参做 K 次 hash，得到 K 个位置，如果之前映射过这 K 个位置的数据的话，说明现在加入的数据可能在布隆器中，
反之，则一定不在布隆过滤器中

因为，不同的数据可能在 K 次 hash 的时候，同时映射到一个 bit 位上，所以可能存在误判率。


## java bitSet 实现

java bitSet 使用 long 来保存 64 位的 bit 位，使用 long[] 来模拟一个 bitSet

查询时通过 bitIndex 转换到 `long[]` 的真实位置，再对该位置的 `long` 数据进行位操作

1. 数据存储

```java
// 保存的 bit 位数据
private long[] words;
```

2. 数据映射

- 数据偏移

```java
/**
 * bit set 使用的映射转换数据
 * 因为 一个 long 是 64 位 
 * 其转换成二进制是一个 6 位数 如最大的 63 00111111
 * 当需要通过 bitSet 的 bitIndex 找到 long[] words 的 wordIndex 时
 * 需要无符号右移 6 即可
 */
private static final int ADDRESS_BITS_PER_WORD = 6;
```

- 定位数据

```java
/**
 * bitIndex 转换成 wordIndex
 */
private static int wordIndex(int bitIndex) {
    return bitIndex >> ADDRESS_BITS_PER_WORD;
}
```

- set 数据

```java
public void set(int bitIndex) {
    if (bitIndex < 0)
        throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
    
    // 1. 转换成 wordIndex
    int wordIndex = wordIndex(bitIndex);
    expandTo(wordIndex);

    // 2. 设置该位数值
    words[wordIndex] |= (1L << bitIndex); // Restores invariants

    checkInvariants();
}
```

