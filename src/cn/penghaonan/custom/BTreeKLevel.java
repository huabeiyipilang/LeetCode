package cn.penghaonan.custom;

import cn.penghaonan.ITest;
import cn.penghaonan.Logger;
import cn.penghaonan.model.binarytree.BTNode;
import cn.penghaonan.model.binarytree.BTUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Carl Li on 2017/4/13.
 * 求二叉树第K层的节点数和二叉树第K层的叶子节点数，递归方式和非递归方式
 */
public class BTreeKLevel implements ITest {

    @Override
    public void test() {
        int[][] values = new int[][]{
                {1},
                {1, 2},
                {-1, -1, 4, 5}};
        BTNode rootNode = BTUtils.createBinaryTreeByOrderTraversal(values);

        Counter kCounter = new Counter("k"), leafCounter = new Counter("leaf");
        countRecursive(rootNode, 0, 1, kCounter, leafCounter);
        Logger.log(kCounter + ", " + leafCounter);

        countNodes(rootNode, 1);
    }

    //递归方式
    private void countRecursive(BTNode node, int level, int k, Counter kNodeCounter, Counter leafNodeCounter) {
        if (node == null) {
            return;
        }
        if (level == k) {
            kNodeCounter.add();
            if (node.leftNode == null && node.rightNode == null) {
                leafNodeCounter.add();
            }
        } else if (level < k) {
            countRecursive(node.leftNode, level + 1, k, kNodeCounter, leafNodeCounter);
            countRecursive(node.rightNode, level + 1, k, kNodeCounter, leafNodeCounter);
        }
    }

    //非递归方式
    private void countNodes(BTNode node, int k) {
        List<BTNode> currentLevelNodeList = new LinkedList<>();
        List<BTNode> nextLevelNodeList = new LinkedList<>();
        int level = 0;
        currentLevelNodeList.add(node);
        while (level < k) {
            for (BTNode node1 : currentLevelNodeList) {
                if (node1.leftNode != null) {
                    nextLevelNodeList.add(node1.leftNode);
                }
                if (node1.rightNode != null) {
                    nextLevelNodeList.add(node1.rightNode);
                }
            }
            level++;
            currentLevelNodeList.clear();
            currentLevelNodeList.addAll(nextLevelNodeList);
            nextLevelNodeList.clear();
        }

        Counter kCounter = new Counter("k"), leafCounter = new Counter("leaf");
        for (BTNode node1 : currentLevelNodeList) {
            if (node1 != null) {
                kCounter.add();
                if (node1.leftNode == null && node1.rightNode == null) {
                    leafCounter.add();
                }
            }
        }
        Logger.log(kCounter + ", " + leafCounter);
    }

    private class Counter {
        int value;
        String tag;

        Counter(String tag) {
            this.tag = tag;
        }

        void add() {
            value++;
        }

        int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return tag + ":" + value;
        }
    }
}
