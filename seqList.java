package cww0310;
public class seqList {
    static  class  ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteElements(ListNode head){
         ListNode newHead = new ListNode(-1);       //删除有序链表的重复节点数
         ListNode newTail = newHead;
         ListNode cur = head;
         while (cur !=null){
             if(cur.next !=null && cur.val == cur.next.val){
                 while (cur.next !=null && cur.val == cur.next.val){
                                    cur = cur.next;
                 }
                 cur =cur.next;
             }else{
                 newTail.next =new ListNode(cur.val);
                 newTail = newTail.next;
                 cur = cur.next;
             }
         }
         return  newHead.next;
    }
    public  ListNode partionNode(ListNode head,int x){
        if(head ==null){
            return  null;
        }
        if(head.next ==null){
            return  head;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode  smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        for(ListNode cur = head;cur!=null;cur = cur.next){
            if(cur.val<x){
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else{
                bigTail.next = new ListNode(cur.val);
            }
        }
        smallTail.next=bigHead.next;
        return  smallHead;
    }
//    public  ListNode boolean partList(ListNode A){
//        int size =size(A);
//        ListNode B =A;
//        int steps = size/2;
//        for (int i = 0; i < steps; i++) {
//            B = B.next;
//        }
//        ListNode pre = null;
//        ListNode cur = B;
//        while (cur!=null){
//            ListNode next = cur.next;
//            if(next ==null){
//                B = cur;
//            }
//            cur.next =pre;
//            pre =cur;
//            cur = next;
//        }
//        while(B!=null){
//            if(A.val != B.val){  //回文链表
//                return  false;
//            }
//            A = A.next;
//            B = B.next;
//        }
//        return  true;
//    }

//    public  ListNode booleanpartList(ListNode A){
//        int size =size(A);
//        ListNode B =A;
//        int steps = size/2;
//        for (int i = 0; i < steps; i++) {
//            B = B.next;
//        }
//        ListNode pre = null;
//        ListNode cur = B;
//        while (cur!=null){
//            ListNode next = cur.next;
//            if(next ==null){
//                B = cur;
//            }
//            cur.next =pre;
//            pre =cur;
//            cur = next;
//        }
//        while(B!=null){
//            if(A.val != B.val){
//                return  false;
//            }
//            A = A.next;
//            B = B.next;
//        }
//        return  true;
//    }
////    public  ListNode findSameFirstNode(ListNode A, ListNode B){
////        int size1 =size(A);
////        int size2 =size(B);
////        if(size1>size2){
////            int steps = size1 - size2;
////            for (int i = 0; i <steps ; i++) {
////                A = A.next;
////            }
////        } {
////            int steps = size2 - size1;
////            for (int i = 0; i <steps ; i++) {    返回第一个橡胶节点
////                B=B.next;
////            }
////        }
////        while (A!=null && B!=null){
////            if(A ==B){
////                return  A;
////            }
//            A= A.next;
//            B =B.next;
//        }
//        return  null;
//    }
    public   boolean hasCycle(ListNode head){
        ListNode fast =head;
        ListNode slow = head;
        while (fast!=null && fast.next !=null){           //判断链表是否有环
            fast = fast.next.next;
            slow =slow.next;
            if(slow==fast){
                return  false;
            }
        }
        return  true;
    }
        public  ListNode deleteCycle(ListNode head){
            ListNode fast =head;
            ListNode slow = head;
            while (fast!=null && fast.next !=null){           //判断链表是否有环
                fast = fast.next.next;
                slow =slow.next;
                if(slow==fast){
                    break;
                }
            }
            if(fast ==null || fast.next ==null){       //判断是否有环
                return  null;
            }
            ListNode cur1 =head;
            ListNode cur2 =fast;//一个从头结点出发，一个从想交节点出发，会走相同步数
            while (cur1!=cur2){
                cur1 = cur1.next;
                cur2 =cur2.next;
            }
            return  cur1;
        }
}
