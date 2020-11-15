package main;

import java.util.ArrayList;
import java.util.List;

public class MaxDepthTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(50);
        TreeNode<Integer> c1 = new TreeNode<>(100);
        TreeNode<Integer> c2= new TreeNode<>(10);
        TreeNode<Integer> c3 = new TreeNode<>(-5);
        TreeNode<Integer> c4 = new TreeNode<>(0);
        TreeNode<Integer> c5 = new TreeNode<>(33);
        TreeNode<Integer> c6 = new TreeNode<>(1);
        TreeNode<Integer> c7 = new TreeNode<>(2);
        TreeNode<Integer> c8 = new TreeNode<>(3);
        TreeNode<Integer> c9 = new TreeNode<>(300);
        TreeNode<Integer> c10 = new TreeNode<>(350);

        root.addChild(c1);
        root.addChild(c2);

        c2.addChild(c3);
        c3.addChild(c4);
        c3.addChild(c5);
        c3.addChild(c6);
        c3.addChild(c7);
        c3.addChild(c8);

        c1.addChild(c9);
        c1.addChild(c10);

        System.out.println("Height of tree: " + root.getHeight(root));
    }

    public static class TreeNode<T> {
        private final List<TreeNode<T>> children = new ArrayList<>();
        private final T data;

        public TreeNode(T data){
            this.data = data;
        }

        public List<TreeNode<T>> getChildren(){
            return children;
        }

        public void addChild(TreeNode<T> children){
            this.children.add(children);
        }

        public int getHeight(TreeNode<T> node) {
            if(node == null) {
                return 0;
            }

            int height = 0;

            for(TreeNode<T> child : node.getChildren()) {
                height = Math.max(height, getHeight(child));
            }

            return height + 1;
        }
    }
}
