package offer.BinaryTree;

/**二叉树的下一个节点
 * @author zhaojie
 * @date 2019\1\16 0016 - 14:42
 */
public class question8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //当右节点不为空，就需要一直寻找右子树的最左的那个节点
        if(pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }else{
            while(pNode.next!=null){
                TreeLinkNode parent = pNode.next;
                if(parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}