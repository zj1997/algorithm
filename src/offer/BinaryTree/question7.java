package offer.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**重建二叉树
 * @author zhaojie
 * @date 2019\1\16 0016 - 11:58
 */

//方法一
public class question7 {
     //用来缓存中序遍历的值所对应的索引
     private Map<Integer ,Integer> indexForInOrders = new HashMap<>();

     public TreeNode reConstructBinaryTree(int[] pre , int[] in){

          for(int i = 0 ; i < in.length ; i++ ){
               indexForInOrders.put(in[i],i);
          }
          return reConstructBinaryTree(pre,0,pre.length-1,0);
     }

     private TreeNode reConstructBinaryTree(int[] pre , int preL , int preR , int inL){

          if(preL > preR){
               return null;
          }
          
          TreeNode root = new TreeNode(pre[preL]);
          int inIndex = indexForInOrders.get(root.val);
          int leftTreeSize = inIndex - inL;

          root.left = reConstructBinaryTree(pre,preL + 1,preL + leftTreeSize,inL);
          root.right = reConstructBinaryTree(pre,preL + leftTreeSize +1 ,preR,inL + leftTreeSize + 1);

          return root;
     }


     public static void main(String[] args) {

          int[] pre ={1,2,4,7,3,5,6,8};
          int[] in = {4,7,2,1,5,3,8,6};

          TreeNode root = new question7().reConstructBinaryTree(pre,in);

          System.out.println(root.val);

     }

}

//方法二(加星)
class Solution{

     public TreeNode reConstructBinaryTree(int[] pre ,int[] in){

          return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

     }

     private TreeNode reConstructBinaryTree(int[] pre ,int startPre , int endPre,
                                           int[] in,  int startIn ,int endIn){

          if(startPre > endPre || startIn > endIn){
               return null;
          }

          //通过前序遍历的首个节点 可判断其为树的根节点
          TreeNode root = new TreeNode(pre[startPre]);

          //寻找其在中序遍历序列中的索引位置
          for(int i = startIn ; i <= endPre ; i++){
               if(in[i] == pre[startPre]){
                    root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                    root.right = reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                    break;
               }
          }
          return root;
     }
}

//树的节点
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}