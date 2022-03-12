package com.jl.linkedlist;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.sql.PreparedStatement;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 单链表应用—单链表实现水浒英雄排行榜
 *               1）完成对英雄人物的增删改查操作
 *               2）添加英雄时，直接添加到链表尾部
 *               3）添加英雄时，根据排名将英雄插入到指定的位置
 * @Date: 2022/3/10
 * @Time: 9:34
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //测试
        //创捷节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        //显示
        singleLinkedList.list();

        //测试修改节点
        HeroNode newHeroBNode = new HeroNode(2, "小鹿", "玉麒麟！！！");
        singleLinkedList.update(newHeroBNode);
        System.out.println("修改后的情况~~");
        //显示
        singleLinkedList.list();

        //删除一个节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
        singleLinkedList.delete(4);
        singleLinkedList.delete(3);
        System.out.println("删除后的链表情况");
        //显示
        singleLinkedList.list();
    }
}

//定义SingleLinkedList管理我们的英雄
class SingleLinkedList{
    
    //先初始化一个头节点，头节点不动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单链表
    //1、找到当前链表的最后一个节点
    //2、将最后的一个节点的的next指向新的节点
    public void add(HeroNode heroNode){

        //因为head节点不能动， 因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到,将temp后移
            temp = temp.next;
        }
        //退出while循环时temp指向了链表的最后
        temp.next = heroNode;
    }

    //第二种方式添加英雄时，根据排名将英雄插到指定的位置
    //（如果有这个排名，则添加失败，并给出提示）
    public  void  addByOrder(HeroNode heroNode){

        //头节点不能动，通过辅助变量帮助我们找到添加的位置
        //因为单链表我们找到的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while (true){
            if (temp.next == null){//temp在链表最后
                break;
            }
            if (temp.next.no > heroNode.no){//位置找到就在temp后面插入
                break;
            }else if (temp.next.no == heroNode.no){//说明希望添加的heroNode的编号存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移
        }
        //判断flag的值
        if (flag){//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n",heroNode.no);
        }else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true){
            if (temp == null){
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号%d的节点,不能修改\n",newHeroNode.no);
        }
    }
    //删除节点
    //head不动 需要一个辅助节点找到待删除节点的前一个节点
    //比较时，是temp.next.no和需要删除的节点的no的比较
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除的节点的位置
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        if (flag){
            //删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在",no);
        }
    }

    //显示链表（遍历）
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
        }
        //因为头节点不能动，需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义一个HeroNode  每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
