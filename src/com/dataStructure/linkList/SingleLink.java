package com.dataStructure.linkList;

public class SingleLink {
    public static void main(String[] args) {
        LinkNode node = new LinkNode();
        LinkNode temp = node;
        for (int i = 1; i < 7; i++) {
            temp.value = i*2;
            temp.next = new LinkNode();
            temp = temp.next;

        }
//        soutNode(node);
//        soutNode(reverseNode(node));

        LinkNode n1 = new LinkNode(1);
        n1.next = new LinkNode(2);
        n1.next.next = new LinkNode(3);
        soutNode(reverseNode(n1));
    }
    public static void soutNode(LinkNode node){
        while (node.next!=null){
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }
    public static LinkNode insertNode(LinkNode node,LinkNode insertNode,int loc){
        LinkNode temp = node;
        LinkNode head = null;
        LinkNode cur = null;
        if(loc < 0 || loc > getLength(node)){
            System.out.println("索引值不合法");
            return temp;
        }
        if(loc == 0){
            head = insertNode;
            head.next = temp;
            return head;
        }
        int count = 0;
        while (count < loc - 1){
            temp = temp.next;
            count += 1;
        }
        insertNode.next = temp.next ;
        temp.next = insertNode;
        return node;
    }
    public static LinkNode reverseNode(LinkNode node){
        LinkNode pre = null;
        LinkNode next = null;
        while(node!= null){
           next = node.next;
           node.next = pre;
           pre = node;
           node = next;
        }
        return pre;

    }
    public static int getLength(LinkNode node){
        LinkNode temp = node;
        int l = 0;
        while (temp.next != null){
            temp = temp.next;
            l+=1;
        }
    return l;
    }
}
class LinkNode{
    LinkNode next;
    Integer value;
    public LinkNode(){}
    public LinkNode(Integer value){
        this.value = value;
    }

}


