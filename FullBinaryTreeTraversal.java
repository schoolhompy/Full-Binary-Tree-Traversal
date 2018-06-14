/**
 * Full Binary Tree Traversal
 * <pre>
 * <b>History:</b>
 *    2018.06.11, 0.1, KIM TAE HO
 * </pre>
 *
 * @author 　KIM TAE HO
 * @version 0.1, 2018.06.11 
 * @see    None
 */
package project;

import java.util.*;
import java.io.*;

class Node {
    public Node leftLeaf, rightLeaf;
    public int data;
    public Node(int data)
    {
        this.data = data;
        leftLeaf = rightLeaf = null;
    }
}

public class Main {
    
    /**
     * Print nodes data from Specified level
     * @param root tree's root node
     * @param wantLevel  Specified level for print
     */
    static void levelOrderPrint(Node root, int wantLevel)
    {
        int nowOrder = 0;

        Queue<Node> queue = new LinkedList();
        queue.add(root);


        while (!queue.isEmpty())
        {
            nowOrder++;
            
            Node current = queue.remove();
            
            if (validLevel(nowOrder, wantLevel)) 
            {
                System.out.print("(" + current.data+") ");
            }
            
            if (current.leftLeaf != null) queue.add(current.leftLeaf);
            if (current.rightLeaf != null) queue.add(current.rightLeaf);
        }
    }
    
    /**
     * Print nodes data from Specified level
     * @param nowOrder sequence leaf number
     * @param wantLevel level of node
     * @return bool that Node in wantlevel
     */
    static boolean validLevel(int nowOrder, int wantLevel) 
    {
        
        int EndLeafOfLevel   = (int)(Math.pow(2, wantLevel)  - 1);
        int StartLeafOfLevel = (int)(Math.pow(2, wantLevel-1)  - 1);
        
        return (nowOrder > StartLeafOfLevel && nowOrder <= EndLeafOfLevel) ;
    }


    
    /**
     * Insert node process, less than is right, more than is left
     * @param root Must needed root Node
     * @param data value of node
     * @return first level's node
     */
    static Node insertNode(Node root,int data)
    {
        if (root == null)
        {
            return new Node(data);
        }
        else
        {
            Node cur;
            if (data <= root.data)
            {
                cur = insertNode(root.leftLeaf,data);
                root.leftLeaf=cur;
            }
            else
            {
                cur = insertNode(root.rightLeaf,data);
                root.rightLeaf=cur;
            }
            return root;
        }
    } 
   
    public static void main(String[] args){
  
        int[] initNums = {2,1,3,0,7,9,1};
        
        Node root = null;
        for (int insertNum : initNums) 
        {
            root = insertNode(root,insertNum);
        }
        levelOrderPrint(root, 3);
    }

}
