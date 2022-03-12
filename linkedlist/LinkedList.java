package com.jl.linkedlist;

import java.awt.*;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 常见的单链表的面试题
 * @Date: 2022/3/12
 * @Time: 16:10
 **/
public class LinkedList {

    //获取单链表的节点个数（如果是带头节点们需要不统计头节点）
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表的倒数第k个节点
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断链表为空
        if (head.next == null){
            return null;
        }
        //第一个遍历得到链表的长度（节点的个数）
        int size = getLength(head);
        //第二次遍历size-index位置，就是我们倒数的第k个节点
        //先做一个index 的校验
        if (index < 0 || index > size){
            return null;
        }
        //定义一个辅助变量，for循环倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //单链表的反转
    public static void reversetList(HeroNode head){
        //如果当前的链表为空或者只有一个节点无需反转直接返回
        if(head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助的变量 来遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null){
            next = cur.next;//暂时保存当前节点的下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead.next
         head.next = reverseHead.next;
    }

    //从尾到头打印单链表
    
}
