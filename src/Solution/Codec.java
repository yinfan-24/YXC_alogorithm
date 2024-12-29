package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public static void main(String[] args) {
        String s = "1,2,3,N,N,N,N";
        TreeNode tmp = deserialize(s);
        String decode = serialize(tmp);
        System.out.println(decode);
    }

    static int index;
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        rserialize(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
    public static void rserialize(TreeNode root, StringBuilder builder){
        if (root == null){
            builder.append("N,");
        }else {
            builder.append(String.valueOf(root.val)+",");
            rserialize(root.left, builder);
            rserialize(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;
        return rdeserialize(arr);
    }

    public static TreeNode rdeserialize(String[] arr){
        if (arr[index].equals("N")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(arr[index++]));
        root.left = rdeserialize(arr);
        root.right = rdeserialize(arr);
        return root;
    }
}
