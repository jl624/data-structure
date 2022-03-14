package datastructure.binarytree.com.jl;

/**
 * �������ı���
 * @author jinlei
 * @time 2022��3��14������4:53:20
 */
public class BinaryTree {

	public static void main(String[] args) {
		
		//����һ��������
		BinaryTreeDemo binaryTree =  new BinaryTreeDemo();
		
		//�ڵ�
		HeroNode root = new HeroNode(1,"�ɽ�");
		HeroNode node2 = new HeroNode(2,"����");
		HeroNode node3 = new HeroNode(3,"����");
		HeroNode node4 = new HeroNode(4,"��˹");
		
		//���ֶ�����������
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		binaryTree.setRoot(root);
		
		//����
		System.out.println("ǰ�����");
		binaryTree.preOrder();
		
		//����
		System.out.println("�������");
		
		
	}

}

//����һ��������
class BinaryTreeDemo{
	
	private HeroNode root;
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	//ǰ�����
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
}

//�����ڵ�
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	
	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	//ǰ�����
	public void preOrder() {
		System.out.println(this);//��������ڵ�
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	//�������
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	//�������
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
}
