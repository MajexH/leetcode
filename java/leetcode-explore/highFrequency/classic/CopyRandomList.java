package highFrequency.classic;

import java.util.HashMap;

/**
 * @author majexh
 */
public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    // 这个方法会修改原数组
    public Node copyRandomListModifyOrigin(Node head) {
        Node moveTemp = head;
        // 首先复制的是每个节点 并把每个节点放入要复制的节点后面
        while (moveTemp != null) {
            Node next = moveTemp.next;
            moveTemp.next = new Node(moveTemp.val);
            moveTemp.next.next = next;

            moveTemp = next;
        }

        // 赋值 random 节点
        moveTemp = head;
        while (moveTemp != null) {
            if (moveTemp.random != null) {
                moveTemp.next.random = moveTemp.random.next;
            }
            moveTemp = moveTemp.next.next;
        }

        // 构建返回的Node
        moveTemp = head;
        Node res = new Node(1), move = res;
        while (moveTemp != null) {
            move.next = moveTemp.next;
            move = move.next;
            moveTemp.next = moveTemp.next.next;
            moveTemp = moveTemp.next;
        }

        return res.next;
    }


    // 这个方法不会修改原数组
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        // 先构建 next next还未连接
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        // 再构建 random next
        temp = head;
        while (temp != null) {
            if (temp.random == null) {
                temp = temp.next;
                continue;
            }
            Node copyFirst = map.get(temp);
            copyFirst.random = map.get(temp.random);
            copyFirst.next = map.get(temp.next);
            temp = temp.next;
        }

        Node res = new Node(1), move = res;
        while (head != null) {
            move.next = map.get(head);
            move = move.next;
            head = head.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.next = new Node(13);
        root.next.next = new Node(11);
        root.next.next.next = new Node(10);
        root.next.next.next.next = new Node(1);
        root.next.random = root;
        root.next.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next.next;
        root.next.next.next.next.random = root;

        System.out.println(new CopyRandomList().copyRandomListModifyOrigin(root));
        System.out.println(new CopyRandomList().copyRandomList(root));
    }
}
