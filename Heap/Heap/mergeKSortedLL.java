
 public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    class mergeKSortedLL{
        public ListNode mergeKLists(ListNode[] lists){
            PriorityQueue<ListNode>pq=new PriorityQueue<>(new Comparator <ListNode>(){
                public int compare(ListNode O1, ListNode O2){
                    return O1.val-O2.val;
                }
            });
            for(ListNode node: lists){
                if(node!=null){
                    pq.add(node);
                }
            }
            ListNode node=new ListNode(-1);  //pseuso head
            ListNode curr=node;
            While(!pq.isEmpty()){
                ListNode temp= pq.remove();
                curr.next=temp;
                curr=curr.next;
                if(temp.next!=null){
                    pq.add(temp.next);
                }
            }
            return node.next;
        }
    }


