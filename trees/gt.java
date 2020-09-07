import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
//import java.util.Collections.reverse();
public class gt{
    // 10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
    
    public static void main(String[]args){
        gt tree=new gt();
        //tree.display();
        //System.out.println(tree.size2());
        //System.out.println(tree.max());
        //System.out.println(tree.find(120));
        //System.out.println(tree.height());
       // tree.preo();
       // System.out.println();
       // tree.posto();
      // tree.levelo();
     // tree.levelolw();
     //tree.levelolwdelimiter();
    // tree.mirror();
   // tree.removeLeaves();
   //tree.linearize();
     tree.display();
     //System.out.println(tree.isSymmetric());
     //tree.multisolver(120);
     //tree.predSucc(120);
     //tree.justLarger(83);
     System.out.println(tree.kthSmallest(3));
    }
    private class Node{
        int data;
        ArrayList<Node>children=new ArrayList<>();
    }
    private int size;
    private Node root;
    public gt(){
        this.root=construct(new Scanner(System.in),null,0);
        // i has no meaning ,root has no parent
    }
    // EXPECTATION-to create ith child of parent node
    private Node construct(Scanner scn,Node parent,int i){
        if (parent==null){
            System.out.println("enter data for root");
        } else{
            System.out.println("enter the data for"+i+"th child"+"of"+parent.data);
        }
        int cdata=scn.nextInt();
        Node child=new Node();
        this.size++;
        child.data=cdata;
        System.out.println("enter the number of children for"+child.data);
        int numgc=scn.nextInt(); // gc=grand children
        for(int j=0;j<numgc;j++){
            Node gc=construct(scn,child ,j); //faith
            child.children.add(gc);
        }
        return child;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void display(){
         display(root);
    }
    private void display(Node node){
        String str=node.data +"->";
        for(Node child : node.children){
            str+=child.data+",";
        }
        str+=".";
        System.out.println(str);
        for(Node child : node.children){
            display(child);
        }
    }
    public int size2(){
         return size2(root);
    }
    private int size2(Node node){
        int size=0;
        for(Node child : node.children){
            int csize=size2(child);
            size+=csize;
        }
        size+=1; //for node itself
        return size;
    }
    public int max(){
        return this.max(root);
    }
    private int max(Node node){
        int rv=node.data; //rv=return value
        for(Node child : node.children){
            int cmax=max(child);
            rv=Math.max(rv,cmax);
        }
        return rv;
    }
    public boolean find(int data){
         return find(root,data);
    }
    private boolean find(Node node,int data){
        if(node.data==data){
            return true;
        }
        for(Node child : node.children){
            boolean fic=find(child,data);
            if(fic){
                return true;
            }
        }
        return false;
    }
    public int height(){
        return height(root);
    }
    private int height(Node node){
        int cmaxht=-1;
        for(Node child : node.children){
         int cht=height(child);
         cmaxht=Math.max(cht,cmaxht);
        }
        return cmaxht+1;
    }
    public void preo(){
        preo(root);
    }
    // rule-> node>child 
    private void preo(Node node){
   System.out.print(node.data +" ");
   for(Node child : node.children){
   preo(child);//faith is child and family will get printed honoring the rules
   }
    }
    public void posto(){
        posto(root);
    }
    private void posto(Node node){
        for(Node child :node.children){
            posto(child); //same faith
        }
        System.out.print(node.data +" ");
    }
    // pre post summary
    //pre is= node>child,while going deeper in recursion,euler path left side
    //post is=child>node ,while getting out of recursion,euler path right side
    public void levelo(){
        LinkedList<Node> queue=new LinkedList<>();
        queue.addLast(root);
        while(queue.isEmpty()==false){
            Node rem=queue.removeFirst();
            System.out.print(rem.data +" ");
            for(Node child : rem.children){
          queue.addLast(child);
            }
        }
        System.out.println(".");
    }
    private class Pair{
        Node node;
        int level;
    }
    public void levelolw(){
        LinkedList<Pair> queue=new LinkedList<>();
        Pair rootpair=new Pair();
        rootpair.node=root;
        rootpair.level=0;

        queue.addLast(rootpair);
        Pair prev=null;
        while(queue.size()>0){
            Pair curr=queue.removeFirst();
            if(prev!=null && prev.level!=curr.level){
                System.out.println();
            }
            System.out.print(curr.node.data+" ");
            for(Node child : curr.node.children){
                Pair cpair=new Pair();
                cpair.node=child;
                cpair.level=curr.level+1;
                queue.addLast(cpair);
            }
            prev=curr;
        }
    }
    public void levelolwdelimiter(){
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size()>0){
            Node rem=queue.removeFirst();
            if(rem!=null){
                System.out.print(rem.data +" ");
            
            for(Node child : rem.children){
                queue.addLast(child);
            }
            }
            else {
                System.out.println();
            
            if (queue.size()>0){
                queue.add(null);
            }
            }
        }
        }
        public void mirror(){
            mirror(root);
        }
        private void mirror(Node node){
            for(Node child : node.children){
                mirror(child);
            }
            //Collections.reverse(node.children);
        }
        public void removeLeaves(){
            removeLeaves(root);
        }
        private void removeLeaves(Node node){
            for(int i=node.children.size()-1;i>=0;i--){
                Node child=node.children.get(i);
                if(child.children.size()==0){
              node.children.remove(child);
                }
                else{
                    removeLeaves(child);
                }
            }
        }
        public void linearize(){
            linearize(root);
        }
        private void linearize(Node node){
            for(Node child : node.children){
                linearize(child);
            }
            while(node.children.size()>1){
                Node sl=node.children.get(node.children.size()-2);
                Node l=node.children.remove(node.children.size()-1);

                Node slkitail=getTail(sl);
                slkitail.children.add(l);
            }
        }
        private Node getTail(Node node){
            Node tail=node;
            while(tail.children.size()==1){
                tail=tail.children.get(0);
            }
            return tail;
        }
public boolean isIsomorphic(gt other){
    return this.isIsomorphic(this.root,other.root);
}
private boolean isIsomorphic(Node tnode,Node onode){   //tnode-this node  onode=other node
if(tnode.children.size()==onode.children.size()){
    for(int i=0;i<tnode.children.size();i++){
        Node tchild=tnode.children.get(i);
        Node ochild=onode.children.get(i);
        boolean isCIsomorphic=isIsomorphic(tchild,ochild);
        if(isCIsomorphic==false){
            return false;
        }
    }
    return true;
}
else{
    return false;
}
}
public boolean isMirror(gt other){
    return this.isMirror(this.root,other.root);
}
private boolean isMirror(Node tnode,Node onode){     //0node-other node
if(tnode.children.size()!=onode.children.size()){
    return false;
}
int left=0;
int right=tnode.children.size()-1;
while(left<tnode.children.size()){
    Node tlchild=tnode.children.get(left); //tlchild=this left child
    Node orchild=onode.children.get(right); // other right child
    boolean isCMirror=isMirror(tlchild,orchild);
    if(isCMirror==false)
{
    return false;
}
left++;
right--;
}
return true;
}
public boolean isSymmetric(){
    return isMirror(this.root,this.root);
}
// to find multiple properties using single transversal
private class Heapmover{
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    int size=0;
    int height=0;
    boolean find=false;

    Node prev=null;
    Node curr=null;
    Node pred=null;
    Node succ=null;
    Node jl=null;  //jl=justLarger
}
public void multisolver(int data){
    Heapmover mover=new Heapmover();
   multisolver(root,mover,data,0);
   System.out.println("size="+mover.size);
   System.out.println("min="+mover.min);
   System.out.println("max="+mover.max);
   System.out.println("height="+mover.height);
   System.out.println("find="+mover.find);
}
private void multisolver(Node node,Heapmover mover,int data,int depth){
    mover.size++;
    mover.min=Math.min(node.data,mover.min);
    mover.max=Math.max(node.data,mover.max);
    mover.height=Math.max(depth,mover.height);
    mover.find=mover.find || node.data==data;
    for(Node child : node.children){
        multisolver(child,mover,data,depth+1);
    }
}
public void predSucc(int data){
    Heapmover mover=new Heapmover();
    predSucc(root,mover,data);
    System.out.println("pred="+mover.pred==null?"null":mover.pred.data);
    System.out.println("succ="+mover.succ==null?"null":mover.succ.data);
}
private void predSucc(Node node,Heapmover mover,int data){
    mover.curr=node;
    if(mover.curr.data==data){
  mover.pred=mover.prev;
}
else if(mover.prev!=null && mover.prev.data==data){
    mover.succ=mover.curr;
}
mover.prev=mover.curr;
for(Node child : node.children){
    predSucc(child,mover,data);
}
}

public void justLarger(int data){
    Heapmover mover=new Heapmover();
    justLarger(root,mover,data);
    System.out.println("JustLarger="+ mover.jl==null?"null":mover.jl.data);
}
private void justLarger(Node node,Heapmover mover,int data){
    if(node.data>data){
        if(mover.jl==null || node.data<mover.jl.data)
        {
            mover.jl=node;
        }
    }
    for(Node child : node.children){
        justLarger(child,mover,data);
    }
}
public int kthSmallest(int k){
    Heapmover mover=new Heapmover();
    int data=Integer.MIN_VALUE;
    for(int i=0;i<k;i++){
        justLarger(root,mover,data);
        data=mover.jl.data;
        mover.jl=null;
    }
    return data;
}
}