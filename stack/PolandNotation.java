package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �沨�����ʽ����׺���ʽ��
 * @author jinlei
 * @time 2022��3��17������6:56:15
 */
public class PolandNotation {

	public static void main(String[] args) {
		
		//����һ���沨�����ʽ
		//��30+4��*5-6  =��30 4 + 5 * 6 -
		//
		//Ϊ�˷����沨�����ʽ�����ֺͷ����ÿո����
		String suffixExpression = "30 4 + 5 * 6 -";//164
		
		//1���Ƚ�"3 4 + 5 * 6 -"�ŵ�ArrayList��
		//2����ArrayList����һ�����������ջ���
		List<String> list = getListString(suffixExpression);
		System.out.println("list = " + list);
		
		int res = calculate(list);
		System.out.println("����Ľ���� = " + res);

	}
	
	//��һ���沨�����ʽ���ν����ֺ����������ArrayList
	public static List<String> getListString(String suffixExpression){
		//��suffixExpression�ָ�
		String[] split = suffixExpression.split(" ");//����String����
		List<String> list = new ArrayList<>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}
	
	//��ɼ���
	public static int calculate(List<String> ls) {
		
		//����һ��ջ
		Stack<String> stack = new Stack<String>();
		//����ls
		for (String item : ls) {
			//ʹ��������ʽȡ����
			if(item.matches("\\d+")) {//ƥ����Ƕ�λ��
				//��ջ
				stack.push(item);
			}else {
				//pop������������������ջ
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
					throw new RuntimeException("���������");
				}
				//��res��ջ
				stack.push("" +res);
			}
		}
		//�������ջ�еľ��ǽ��
		return Integer.parseInt(stack.pop());
		
	}

}
