package cn.penghaonan.problems;

import cn.penghaonan.ITest;
import cn.penghaonan.Logger;

public class AddTwoNumbers implements ITest {
    @Override
    public void test() {
        ListNode l1 = createList(98);
        ListNode l2 = createList(67);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            Logger.log(String.valueOf(res.val));
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootNode = null;//root节点
        ListNode lastNode = null;//上一个节点
        ListNode currentNode;//本次节点
        boolean add_value = false; //是否有进位
        int value;//本位运算值

        do {
            value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (add_value) {
                value++;
                add_value = false;
            }
            if (value > 9) {
                currentNode = new ListNode(value % 10);
                add_value = true;
            } else {
                currentNode = new ListNode(value);
            }
            if (rootNode == null) {
                rootNode = currentNode;
            }
            if (lastNode == null) {
                lastNode = currentNode;
            }else {
                lastNode.next = currentNode;
                lastNode = currentNode;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        } while (l1 != null || l2 != null || add_value);

        return rootNode;
    }

    private ListNode createList(int num) {
        ListNode res = null;
        if (num > 9) {
            res = new ListNode(num % 10);
            res.next = createList(num / 10);
        }else {
            res = new ListNode(num);
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
