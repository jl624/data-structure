package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 * @author jinlei
 * @time 2022年3月17日下午9:40:11
 */
public class InfixToSuffix {

	public static void main(String[] args) {
		
		//说明
		//1、因为直接对str进行操作不方便，因此创建中缀对应的List
		//2、即“1+((2+3)*4)-5”  => ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
		
		String expression = "1+((2+3)*4)-5";
		List<String> iel = toInfixExpression(expression);
		System.out.println("中缀表达式对应的list = "+ iel);
		
		List<String> psel = parseSuffixExpressionList(iel);
		System.out.println("后缀表达式对应的list = "+psel);
		
		
	}
	
	//方法：将得到的中缀表达式的list =》后缀表达式的list
	public static List<String> parseSuffixExpressionList(List<String> ls){
		
		//创建两个栈
		Stack<String> s1 = new Stack<String>();//符号栈
		//因为s2在整个过程中没有pop操作，最后需要逆序，所以不用栈换成list
		//Stack<String> s2 = new Stack<String>();//存放中间结果的栈
		List<String> s2 = new ArrayList<String>();//存放中间结果的栈
		
		//遍历ls
		for (String item : ls) {
			//如果是一个数加入s2
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if (item.equals("(")) {
				s1.push(item);
			}else if (item.equals(")")) {
				//如果是右括号依次弹出s1栈顶的运算符并压入s2，
				//直到遇到左括号为止，此时将一对括号丢弃
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//将(弹出s1栈，清除小括号
			}else {
				//当item的优先级小于等于s1栈顶元素，将s1栈顶的运算符弹出并压入s2
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				//还需要将item压入栈
				s1.push(item);
			}
		}
		//将s1中剩余的运算符依次加入s2
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;//注意是存放再list因此按顺序输出就是对应的结果
	}
	
	//方法：将中缀表达式转成对应的list
	public static List<String> toInfixExpression(String s){
		List<String> ls = new ArrayList<>();
		int i = 0;//指针用于遍历中缀表达式
		String str;//多位数的拼接
		char c;//遍历到字符放入c中
		while (i < s.length()) {
			//如果c是一个非数字就需要加入到ls中
			if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			}else {//如果是一个数，需要考虑多位数
				str = "";//将str置空
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					//拼接
					str += c;
					i++;
				}
				ls.add(str);
			}
		}
		return ls;
	}

}

//类：返回一个运算符的优先级
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	//写一个方法返回对应的优先级数字
	public static int getValue(String opertion) {
		int result = 0;
		switch (opertion) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("不存在该运算符");
			break;
		}
		return result;
	}
}
