package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式（后缀表达式）
 * @author jinlei
 * @time 2022年3月17日下午6:56:15
 */
public class PolandNotation {

	public static void main(String[] args) {
		
		//定义一个逆波兰表达式
		//（30+4）*5-6  =》30 4 + 5 * 6 -
		//
		//为了方便逆波兰表达式的数字和符号用空格隔开
		String suffixExpression = "30 4 + 5 * 6 -";//164
		
		//1、先将"3 4 + 5 * 6 -"放到ArrayList中
		//2、将ArrayList传递一个方法，配合栈完成
		List<String> list = getListString(suffixExpression);
		System.out.println("list = " + list);
		
		int res = calculate(list);
		System.out.println("计算的结果是 = " + res);

	}
	
	//将一个逆波兰表达式依次将数字和运算符放入ArrayList
	public static List<String> getListString(String suffixExpression){
		//将suffixExpression分割
		String[] split = suffixExpression.split(" ");//返回String数组
		List<String> list = new ArrayList<>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}
	
	//完成计算
	public static int calculate(List<String> ls) {
		
		//创建一个栈
		Stack<String> stack = new Stack<String>();
		//遍历ls
		for (String item : ls) {
			//使用正则表达式取出数
			if(item.matches("\\d+")) {//匹配的是多位数
				//入栈
				stack.push(item);
			}else {
				//pop出两个数并运算在入栈
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if(item.equals("+")) {
					res = num1 + num2;
				}else if(item.equals("-")) {
					res = num1 - num2;
				}else if(item.equals("*")){
					res = num1 * num2;
				}else if (item.equals("/")) {
					res = num1 / num2;
				}else {
					throw new RuntimeException("运算符有误");
				}
				//把res入栈
				stack.push("" +res);
			}
		}
		//最后留在栈中的就是结果
		return Integer.parseInt(stack.pop());
		
	}

}
