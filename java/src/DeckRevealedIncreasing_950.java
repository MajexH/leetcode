import java.util.*;

public class DeckRevealedIncreasing_950 {

    /**
     * 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
     *
     * 最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
     *
     * 现在，重复执行以下步骤，直到显示所有卡牌为止：
     *
     * 1. 从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
     * 2. 如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
     * 3. 如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
     *
     *
     * 返回能以递增顺序显示卡牌的牌组顺序。
     *
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length == 0) return new int[]{};
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        Deque<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            indexes.addLast(i);
        }
        // 遍历递增的序列
        for (int num : deck) {
            assert indexes.size() != 0;
            // 找到插入的位置
            res[indexes.pollFirst()] = num;
            indexes.addLast(indexes.pollFirst());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DeckRevealedIncreasing_950().deckRevealedIncreasing(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18})));
    }
}
