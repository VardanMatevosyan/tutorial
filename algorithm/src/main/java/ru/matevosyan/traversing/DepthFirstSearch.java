package ru.matevosyan.traversing;

public class DepthFirstSearch {
    private final Tree.Entry parent;

    public DepthFirstSearch(final Tree tree) {
        this.parent = tree.getRoot();
    }

    public void preOrder() {
        traversingPreOrderHelper(this.parent);
    }
    public void inOrder() {
        traversingInOrderHelper(this.parent);
    }
    public void postOrder() {
        traversingPostOrderHelper(this.parent);
    }

    private void traversingPreOrderHelper(final Tree.Entry entry) {
        if (entry == null) {
            return;
        }
        System.out.println(entry.value);
        traversingPreOrderHelper(entry.left);
        traversingPreOrderHelper(entry.right);
    }

    private void traversingInOrderHelper(final Tree.Entry entry) {
        if (entry == null) {
            return;
        }
        traversingInOrderHelper(entry.left);
        System.out.println(entry.value);
        traversingInOrderHelper(entry.right);
    }

    private void traversingPostOrderHelper(final Tree.Entry entry) {
        if (entry == null) {
            return;
        }
        traversingPostOrderHelper(entry.left);
        traversingPostOrderHelper(entry.right);
        System.out.println(entry.value);
    }

}
