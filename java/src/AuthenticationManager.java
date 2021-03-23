import java.util.*;

public class AuthenticationManager {

    private int timeToLive;
    private TreeMap<Integer, String> queue;
    private Map<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.queue = new TreeMap<>();
        this.tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        this.queue.put(currentTime + this.timeToLive, tokenId);
        this.tokens.put(tokenId, currentTime + this.timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        // 没有这个
        if (!this.tokens.containsKey(tokenId)) return;
        // 未过期的才更新
        int expire = this.tokens.get(tokenId);
        if (expire <= currentTime) return;

        this.queue.remove(this.tokens.get(tokenId), tokenId);
        this.queue.put(currentTime + this.timeToLive, tokenId);
        this.tokens.put(tokenId, currentTime + this.timeToLive);
    }

    // 过期事件优于其他事件
    public int countUnexpiredTokens(int currentTime) {
        return this.queue.tailMap(currentTime, false).size();
    }
}
