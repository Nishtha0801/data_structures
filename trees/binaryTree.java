import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
public class binaryTree{
    public static void main(String[]args){
        binaryTree tree=new binaryTree();
        //System.out.println(tree.size());
       // tree.display();
        //System.out.println(tree.size2());
        //System.out.println(tree.max());
        //System.out.println(tree.height());
        //System.out.println(tree.find(120));
        //tree.preo();
        //tree.posto();
        //tree.ino();
        tree.printSingleChild();
        tree.removeLeaf();
        tree.display();
        tree.printRootToLeafPath(150);
        System.out.println(tree.diameter());
        System.out.println(tree.diameter2());
    }

    private class Node{
        int data;
        Node left;
        Node right;
    }
    private Node root;
    private int size;
    public binaryTree(){
        this.root=this.construct(new Scanner(System.in),null,false);
    }
    private Node construct(Scanner scn,Node parent,boolean ilc){  
          //ilc=is left child
          if(parent==null){
              System.out.println("enter the data for root");
          }else{
   if(ilc){
       System.out.println("Enter the data for left child="+parent.data);
   }else{
       System.out.println("Enter the data for right child="+parent.data);
   }
          }
   int cdata=scn.nextInt();
   Node child=new Node();
   child.data=cdata;
   this.size++;

   System.out.println("do you have a left child for"+child.data);
   boolean hlc=scn.nextBoolean();
   if(hlc){
       child.left=construct(scn, child,true);
   }
   System.out.println("do you have a right child for="+child.data);
   boolean hrc=scn.nextBoolean();
   if(hrc){
       child.right=construct(scn,child,false);
   }
   return child;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
   return this.size()==0;
    }
    public void display(){
        display(root);
    }
    private void display(Node node){
        if(node==null){
            return;
        }
        String str="";
        str+=node.left!=null?node.left.data:".";
        str+="->"+node.data+"<-";
        str+=node.right!=null?node.right.data:".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public int size2(){
        return size2(root);
    }
    private int size2(Node node){
        if(node==null){
            return 0;
        }
        int lsize=size2(node.left);
        int rsize=size2(node.right);
        return lsize+rsize+1;
    }
    public int max(){
        return this.max(root);
    }
    private int max(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int lmax=max(node.left);
        int rmax=max(node.right);
        return Math.max(node.data,Math.max(lmax,rmax));
    }
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return -1;
        }
        int lh=height(node.left);
        int rh=height(node.right);
        int ht=Math.max(lh,rh)+1;
        return ht;
    }
    public boolean find(int data){
        return find(root,data);
    }
    private boolean find(Node node,int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        boolean filc=find(node.left,data);
        if(filc){
            return true;
        }
        boolean firc=find(node.right,data);
        if(firc){
            return true;
        }
        return false;
    }
    public void preo(){
        preo(root);
        System.out.println(".");
    }
    private void preo(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data +" ");
        preo(node.left);
        preo(node.right);
    }
    public void posto(){
        posto(root);
        System.out.println(".");
    }
    private void posto(Node node){
        if(node==null){
            return;
        }
        
        preo(node.left);
        preo(node.right);
        System.out.print(node.data +" ");
    }
     public void ino(){
        ino(root);
        System.out.println(".");
    }
    private void ino(Node node){
        if(node==null){
            return;
        }
        
        preo(node.left);
        System.out.print(node.data +" ");
        preo(node.right);
        
    }
    public void levelo(){
        LinkedList<Node>queue=new LinkedList<>();
        queue.addLast(root);
        while(queue.isEmpty()==false){
            Node rn=queue.removeFirst();
            System.out.print(rn.data+" ");
            if(rn.left!=null){
                queue.addLast(rn.left);
            }
            if(rn.right!=null){
                queue.addLast(rn.right);
            }
        }
        System.out.println(".");
    }
    public void printSingleChild(){
        printSingleChild(root,root.left);
        printSingleChild(root,root.right);
    }
    private void printSingleChild(Node parent,Node child){
        if(child==null){
            return;
        }
        if((parent.left==child && parent.right==null)|| (parent.right==child && parent.left==null)){
            System.out.print(child.data+" ");
        }
        printSingleChild(child,child.left);
        printSingleChild(child,child.right);
    }
    public void removeLeaf(){
        removeLeaf(root,root.left);
        removeLeaf(root,root.right);
    }
    private void removeLeaf(Node parent,Node child){
        if(child==null){
            return;
        }
        if(child.left==null && child.right==null){
            //leaf
            if(parent.left==child){
                parent.left=null;
            }
            else{
                parent.right=null;
            }
            return;
        }
        removeLeaf(child,child.left);
        removeLeaf(child,child.right);
    }
    public void printRootToLeafPath(int tar){
        printRootToLeafPath(root,0," ",tar);
    }
    private void printRootToLeafPath(Node node,int ssf,String psf,int tar){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            if(ssf+node.data<tar){
                System.out.println(psf+" "+node.data);
            }
            return;
        }
        printRootToLeafPath(node.left,ssf+node.data,psf+" "+node.data,tar);
        printRootToLeafPath(node.right,ssf+node.data,psf+" "+node.data,tar);
    }
    public int diameter(){
        return diameter(root);
    }
    private int diameter(Node node){
         if(node==null){
             return 0;
         }
         int ld=diameter(node.left);//distance between farthest nodes in left subtree
         int rd=diameter(node.right);//distance between farthest nodes in right subtree
         int lh=height(node.left);//distance of left's deepest from left
         int rh=height(node.right);//distance  of right's deepest from right
         int factor=lh+rh+2;//distance of left's deepest from right's deepest
         return Math.max(factor,Math.max(ld,rd));
    }
    private class DiaPair{
        int height;
        int diameter;
    }
    public int diameter2(){
        DiaPair dp=diameter2(root);
         return dp.diameter;
    }
    private DiaPair diameter2(Node node){
        if(node==null){
            DiaPair bp=new DiaPair();
            bp.height=-1;
            bp.diameter=0;
            return bp;
        }
        DiaPair lp=diameter2(node.left);
        DiaPair rp=diameter2(node.right);

        DiaPair mp=new DiaPair();
        mp.height=Math.max(lp.height,rp.height)+1;
        mp.diameter=Math.max(lp.height+rp.height+2,Math.max(lp.diameter,rp.diameter));
   return mp;
    }
}