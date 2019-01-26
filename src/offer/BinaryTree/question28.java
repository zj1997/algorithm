package offer.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**对称的二叉树
 * @author zhaojie
 * @date 2019\1\16 0016 - 19:47
 */
public class question28 {

    boolean isSymmetrical(TreeNode pRoot)
    {
         if(pRoot == null){
             return true;
         }
         return isSymmetrical(pRoot.left,pRoot.right);
    }

    boolean isSymmetrical(TreeNode t1 ,TreeNode t2){

        if(t1 == null && t2 == null){
            return true;
        }

        if(t1 == null || t2 == null){
            return false;
        }

        if(t1.val!=t2.val){
            return false;
        }

        return isSymmetrical(t1.left,t2.right) && isSymmetrical(t1.right,t2.left);
    }

}
