package cn.penghaonan.model.binarytree;

public class BTUtils {

    public static BTNode createBinaryTreeByOrderTraversal(int[][] values) {
        return readNode(values, 0, 0);
    }

    private static BTNode readNode(int[][] values, int level, int index) {
        int value = values[level][index];
        if (value == -1) {
            return null;
        } else {
            BTNode node = new BTNode();
            node.value = value;
            if (level < values.length - 1) {
                node.leftNode = readNode(values, level + 1, index * 2);
                node.rightNode = readNode(values, level + 1, index * 2 + 1);
            }
            return node;
        }
    }
}
