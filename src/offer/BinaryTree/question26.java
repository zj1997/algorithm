package offer.BinaryTree;

import offer.BinaryTree.TreeNode;

/**树的子结构，判断a树是否属于b树的一部分
 * @author zhaojie
 * @date 2019\1\16 0016 - 15:55
 */
public class question26 {

        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
                if(root1 == null || root2 == null){
                        return false;
                }
            /*对三种情况进行比较：
                 1.root1和root2节点的值相等
                 2.root1和root2节点的值不相等，递归比较root1的左子树
                 3.root1的左子树和root2节点的值也不相等 对root1的右子树进行递归比较，若再不相等，则不符合条件
             */
            return isSubTreeWithRoot(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }

        private boolean isSubTreeWithRoot(TreeNode root1,TreeNode root2){

                //此时root2比较完毕，并且相关的节点都吻合
                if( root2 == null){
                        return true;
                }

                //此时root2还没比较完毕，root1已经无节点，不符合
                if(root1 == null){
                        return false;
                }

                //若root1与root2其中有相关的节点不相等，也不符合

                if(root1.val!=root2.val){
                        return false;
                }
                //递归比较其所有的相关节点
                return isSubTreeWithRoot(root1.left,root2.left) && isSubTreeWithRoot(root1.right,root2.right);
        }
}
