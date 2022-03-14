package datastructure.binarytree.com.jl;

/**
 * 二叉树的遍历
 * @author jinlei
 * @time 2022年3月14日下午4:53:20
 */
public class BinaryTree {

	public static void main(String[] args) {
		
		//创建一个二叉树
		BinaryTreeDemo binaryTree =  new BinaryTreeDemo();
		
		//节点
		HeroNode root = new HeroNode(1,"松江");
		HeroNode node2 = new HeroNode(2,"无用");
		HeroNode node3 = new HeroNode(3,"张三");
		HeroNode node4 = new HeroNode(4,"里斯");
		
		//先手动创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		binaryTree.setRoot(root);
		
		//测试
		System.out.println("前序遍历");
		binaryTree.preOrder();
		
		//测试
		System.out.println("中序遍历");
		
		
	}

}

//定义一个二叉树
class BinaryTreeDemo{
	
	private HeroNode root;
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	//前序遍历
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
}

//创建节点
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
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);//先输出父节点
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	//中序遍历
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	//后序遍历
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
