import java.util.*;
import java.util.stream.Collectors;

public class DisplayTable_1418 {
    private static class Pair {
        public String table;
        public String dish;

        public Pair(String table, String dish) {
            this.table = table;
            this.dish = dish;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(table, pair.table) && Objects.equals(dish, pair.dish);
        }

        @Override
        public int hashCode() {
            return Objects.hash(table, dish);
        }
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();

        // table 得到菜品
        Set<String> tablesSet = new HashSet<>();
        Set<String> dishesSet = new HashSet<>();
        // table 和 dish 定位一个 数量
        Map<Pair, Integer> counters = new HashMap<>();

        for (List<String> order : orders) {
            String table = order.get(1), dish = order.get(2);
            dishesSet.add(dish);
            tablesSet.add(table);
            Pair p = new Pair(table, dish);
            counters.put(p, counters.getOrDefault(p, 0) + 1);
        }

        List<String> tables = new ArrayList<>(tablesSet).stream().sorted(Comparator.comparingInt(Integer::parseInt)).collect(Collectors.toList());
        List<String> dishes = new ArrayList<>(dishesSet).stream().sorted().collect(Collectors.toList());

        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(dishes);
        res.add(firstRow);

        for (String table : tables) {
            List<String> tmp = new ArrayList<>(dishes.size());
            tmp.add(table);
            for (String dish : dishes) {
                tmp.add(String.valueOf(counters.getOrDefault(new Pair(table, dish), 0)));
            }
            res.add(tmp);
        }
        return res;
    }
}
