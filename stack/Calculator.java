package stack;

import java.util.Stack;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 用栈实现计算器
 * @Date: 2022/3/16
 * @Time: 16:27
 **/
public class Calculator {
    public static void main(String[] args) {

        //根据思路完成表达式的运算
        String exp = "7+2*6-4";
        //创建两个栈 数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存在ch
        String keepNum = "";
        //开始while循环扫描exp
        while (true){
            //依次得到exp的每一个字符
            ch = exp.substring(index,index+1).charAt(0);
            //判断ch是什么然后做相应的处理
            if (operStack.isOper(ch)){//如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()){
                    //处理
                    //如果符号栈有操作符,就进行比较如果当前的操作符的优先级小于或者等于栈中的操作符就需要从数栈中pop出两个数
                    //在从符号栈中pop出一个符号,进行运算,将得到结果,入数栈,然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        //如果当前的操作符优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }
            }else {//如果是数
                //numStack.push(ch - 48);//'1'=>1
                //处理多位数时，需要向exp表达式的index后再看一位，如果是数字就进行扫描，如果是符号才入栈
                //需要定义一个变量字符串用于拼接
                keepNum += ch;
                //如果ch是最后一位
                if (index == exp.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是不是数字，如果是就继续扫描，否则入栈
                    if (operStack.isOper(exp.substring(index+1,index+2).charAt(0))) {
                        //如果后一位是运算符，则入栈keepNum = “ 1”或者“ 123”
                        numStack.push(Integer.parseInt(keepNum));
                        //keepNum清空
                        keepNum = "";
                    }
                }
            }
            //index+1并判断是否扫描到exp最后
            index++;
            if (index >= exp.length()){
                break;
            }
        }
        //表达式扫描完毕，就顺序的从数栈和符号栈中pop相应的数和符号 并运行
        while (true){
            //如果符号栈为空则计算到最后的结果，数栈中只有数字（结果）
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);//入栈
        }
        //将数栈最后的数pop就是结果
        System.out.printf("表达式%s = %d",exp,numStack.pop());
    }
}

//创建栈
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据放在该数组中
    private int top = -1;//top表示栈顶

    //构造器
    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //返回当前栈顶的值，不是真正的pop
    public int peek(){
        return stack[top];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况(遍历栈)
    public void list(){
        if (isEmpty()){
            System.out.println("栈空没有数据");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
    //返回运算符的优先级，优先级使用数字表示，数字越大，优先级越高
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;//假定目前的表达式只有加减乘除
        }
    }
    //判断是否是运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//res用于存放计算结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}