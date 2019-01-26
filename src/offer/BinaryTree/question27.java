package offer.BinaryTree;

/**二叉树的镜像
 * @author zhaojie
 * @date 2019\1\16 0016 - 19:13
 */
public class question27 {

    public void Mirror(TreeNode root) {

        if(root == null){
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private  void swap(TreeNode root){
        TreeNode t =root.left;
        root.left = root.right;
        root.right = t;
    }
}
