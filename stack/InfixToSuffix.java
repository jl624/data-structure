package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ��׺���ʽת��׺���ʽ
 * @author jinlei
 * @time 2022��3��17������9:40:11
 */
public class InfixToSuffix {

	public static void main(String[] args) {
		
		//˵��
		//1����Ϊֱ�Ӷ�str���в��������㣬��˴�����׺��Ӧ��List
		//2������1+((2+3)*4)-5��  => ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
		
		String expression = "1+((2+3)*4)-5";
		List<String> iel = toInfixExpression(expression);
		System.out.println("��׺���ʽ��Ӧ��list = "+ iel);
		
		List<String> psel = parseSuffixExpressionList(iel);
		System.out.println("��׺���ʽ��Ӧ��list = "+psel);
		
		
	}
	
	//���������õ�����׺���ʽ��list =����׺���ʽ��list
	public static List<String> parseSuffixExpressionList(List<String> ls){
		
		//��������ջ
		Stack<String> s1 = new Stack<String>();//����ջ
		//��Ϊs2������������û��pop�����������Ҫ�������Բ���ջ����list
		//Stack<String> s2 = new Stack<String>();//����м�����ջ
		List<String> s2 = new ArrayList<String>();//����м�����ջ
		
		//����ls
		for (String item : ls) {
			//�����һ��������s2
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if (item.equals("(")) {
				s1.push(item);
			}else if (item.equals(")")) {
				//��������������ε���s1ջ�����������ѹ��s2��
				//ֱ������������Ϊֹ����ʱ��һ�����Ŷ���
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//��(����s1ջ�����С����
			}else {
				//��item�����ȼ�С�ڵ���s1ջ��Ԫ�أ���s1ջ���������������ѹ��s2
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				//����Ҫ��itemѹ��ջ
				s1.push(item);
			}
		}
		//��s1��ʣ�����������μ���s2
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;//ע���Ǵ����list��˰�˳��������Ƕ�Ӧ�Ľ��
	}
	
	//����������׺���ʽת�ɶ�Ӧ��list
	public static List<String> toInfixExpression(String s){
		List<String> ls = new ArrayList<>();
		int i = 0;//ָ�����ڱ�����׺���ʽ
		String str;//��λ����ƴ��
		char c;//�������ַ�����c��
		while (i < s.length()) {
			//���c��һ�������־���Ҫ���뵽ls��
			if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			}else {//�����һ��������Ҫ���Ƕ�λ��
				str = "";//��str�ÿ�
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					//ƴ��
					str += c;
					i++;
				}
				ls.add(str);
			}
		}
		return ls;
	}

}

//�ࣺ����һ������������ȼ�
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	//дһ���������ض�Ӧ�����ȼ�����
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
			System.out.println("�����ڸ������");
			break;
		}
		return result;
	}
}
