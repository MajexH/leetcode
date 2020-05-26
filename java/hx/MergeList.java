import java.util.ArrayList;

public class MergeList {

    public String mergeList(String list1, String list2) {
        ArrayList<String> res = new ArrayList<>();

        String[] list1Str = list1.split("->");
        String[] list2Str = list2.split("->");
        int indexList1 = 0, indexList2 = 0;

        while (indexList1 < list1Str.length && indexList2 < list2Str.length) {
            if (list1Str[indexList1].compareTo(list2Str[indexList2]) > 0) {
                res.add(list2Str[indexList2]);
                indexList2++;
            } else if (list1Str[indexList1].compareTo(list2Str[indexList2]) < 0) {
                res.add(list1Str[indexList1]);
                indexList1++;
            } else {
                res.add(list1Str[indexList1]);
                indexList1++;
                indexList2++;
            }
        }

        while (indexList1 < list1Str.length) {
            res.add(list1Str[indexList1]);
            indexList1++;
        }

        while (indexList2 < list2Str.length) {
            res.add(list1Str[indexList2]);
            indexList2++;
        }

        return String.join("->", res);
    }

    public static void main(String[] args) {
        System.out.println(new MergeList().mergeList("1->2->5", "2->4"));
    }
}
