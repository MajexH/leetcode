import java.util.ArrayList;
import java.util.List;

public class KeysandRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] remember = new boolean[rooms.size()];
        dfs(0, rooms, remember);
        for (boolean flag : remember) {
            if (!flag) return false;
        }
        return true;
    }

    public void dfs(int index, List<List<Integer>> rooms, boolean[] remember) {
        List<Integer> keys = rooms.get(index);
        remember[index] = true;
        for (Integer key : keys) {
            // 没访问过得 去访问 防止成环
            if (!remember[key])
                dfs(key, rooms, remember);
        }
    }
}
