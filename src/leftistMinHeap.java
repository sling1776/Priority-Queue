public class leftistMinHeap <E extends Comparable> {
    private Item<E> root;

    public leftistMinHeap(){}

    private class Item<E extends Comparable>{
        private Item<E> left;
        private Item<E> right;
        private E value;
        private int distanceToNull;

        private Item(E v){
            value = v;
            distanceToNull = 0;
        }

    }

    public E removeMin(){
        if(root == null)return null;
        E deleted = root.value;
        root = merge(root.left, root.right);
        return deleted;
    }

    public Item<E> Insert(E n){
        Item<E> node = new Item<>(n);
        root = merge(root, node);
        return root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private Item<E> merge(Item<E> tree1, Item<E> tree2){
        if(tree1 == null) return tree2;
        if(tree2 ==  null) return tree1;

        Item<E> node = null;

        if(tree1.value.compareTo(tree2.value)<=0){
            node = tree1;
            node.right = merge(tree1.right, tree2);
        }else{
            node = tree2;
            node.right = merge(tree2.right, tree1);
        }
        updateDistance(node);
        if(getNullDistance(node.left) < getNullDistance(node.right)){
            Item<E> temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return node;
    }

    private void updateDistance(Item<E> node){
        if (node == null) return;
        if(node.left == null || node.right == null){
            node.distanceToNull = 0;
        }else {
            node.distanceToNull = Math.min(node.left.distanceToNull, node.right.distanceToNull);
        }
    }

    private int getNullDistance(Item<E> node){
        if(node == null)
            return -1;
        else return node.distanceToNull;
    }
}
