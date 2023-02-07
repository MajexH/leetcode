//力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大
//于等于三次，这个系统会自动发布一个 警告 。 
//
// 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡
//的时间。 
//
// 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。 
//
// 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。 
//
// 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使
//用情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], 
//keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
//输出：["daniel"]
//解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
// 
//
// 示例 2： 
//
// 
//输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12
//:01","12:00","18:00","21:00","21:20","21:30","23:00"]
//输出：["bob"]
//解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
// 
//
// 示例 3： 
//
// 
//输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], 
//keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
//输出：["clare","leslie"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= keyName.length, keyTime.length <= 10⁵ 
// keyName.length == keyTime.length 
// keyTime 格式为 "HH:MM" 。 
// 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。 
// 1 <= keyName[i].length <= 10 
// keyName[i] 只包含小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 30 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod1604 {
    public static void main(String[] args) {
        Solution solution = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod1604().new Solution();
        System.out.println(solution.alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
        System.out.println(solution.alertNames(new String[]{"a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b"},
                new String[]{"23:27", "03:14", "12:57", "13:35", "13:18", "21:58", "22:39", "10:49", "19:37", "14:14", "10:41"}));
        System.out.println(solution.alertNames(new String[]{"a", "a", "a", "a", "b", "b", "b", "b", "b", "b", "c", "c", "c", "c"}, new String[]{"01:35", "08:43", "20:49", "00:01", "17:44", "02:50", "18:48", "22:27", "14:12", "18:00", "12:38", "20:40", "03:59", "22:24"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> alertNames(String[] keyName, String[] keyTime) {

            Map<String, List<String>> memo = new HashMap<>();

            for (int i = 0; i < keyName.length; i++) {
                memo.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(keyTime[i]);
            }

            Set<String> res = new HashSet<>();

            for (Map.Entry<String, List<String>> entry : memo.entrySet()) {
                List<String> values = entry
                        .getValue()
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());

                for (int i = 2; i < values.size(); i++) {

                    if (this.inOneHour(values.get(i - 2), values.get(i - 1), values.get(i))) {
                        res.add(entry.getKey());
                        break;
                    }

                }

            }

            return res.stream().sorted().collect(Collectors.toList());
        }

        // 两两都在一个小时以内
        private boolean inOneHour(String first, String second, String third) {
            // second && third 不用比较了
            return this.inOneHour(first, second) && this.inOneHour(first, third);
        }

        private boolean inOneHour(String pre, String cur) {

            String[] preSplit = pre.split(":");
            String[] curSplit = cur.split(":");

            // 当前时间
            int preTime = Integer.parseInt(preSplit[0]);
            int preMinutes = Integer.parseInt(preSplit[1]);
            // 新时间
            int curTime = Integer.parseInt(curSplit[0]);
            int curMinutes = Integer.parseInt(curSplit[1]);

            return curTime - preTime < 1 || (curTime - preTime == 1 && curMinutes <= preMinutes);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}