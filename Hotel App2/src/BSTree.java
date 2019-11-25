import javax.swing.JOptionPane;

public class BSTree {
	private Node head;
	private Node tail;
	private int count;

	// private Node root;
	public BSTree() {
		tail = new Node(0, null, 0, null, 0, null, null);
		head = new Node(-1, null, 0, null, 0, null, tail);
	}

	public int readCount() {
		return count++; 
	}

	void insert(int k, String nm, int a, String r, int pr) {
		if (searchById(k) != null) {
			JOptionPane.showMessageDialog(null, "It already exist, try different values");
		} else {
			Node p, x;
			p = head;
			x = head.right;
			while (x != tail) {
				p = x;
				x = (k < x.key) ? x.left : x.right;
			}
			x = new Node(k, nm, a, r, pr, tail, tail);
			if (k < p.key)
				p.left = x;
			else
				p.right = x;
		}
	}

	Node searchById(int k) {
		count = 0;
		Node x = head.right;
		tail.key = k;
		boolean found = false;
		while (x != tail && found == false) {
			count++;
			if (k == x.key) {
				found = true;
			} else if (k < x.key)
				x = x.left;
			else
				x = x.right;
		}
		if (x == tail)
			return null;
		else
			return x;
	}

//	Node searchByName(String name) {
//		Node x = head.right;
//		tail.name = name;
//		boolean found = false;
//		while (x != tail && found == false) {
//			if (name.equals(x.name)) {
//				found = true;
//			}
//
//			else {
//				found = false;
//			}
//		}
//		if (x == tail)
//			return null;
//		else
//			return x;
//
//	}

	Node searchByAge(int a) {
		count = 0;
		Node x = head.right;
		tail.age = a;
		boolean found = false;
		while (x != tail && found == false) {
			count++;
			if (a == x.age)
				found = true;
			else if (a < x.age)
				x = x.left;
			else
				x = x.right;
		}
		if (x == tail)
			return null;
		else
			return x;
	}

	public boolean delete(int key) {
		if (head == null) {
			System.out.println("The tree is empty!");
			return false;
		}
		Node targetParent = head;
		Node target = head;
		boolean isLeftChild = true;
		while (target.key != key) {
			if (key > target.key) {
				targetParent = target;
				target = target.right;
				isLeftChild = false;
			} else {
				targetParent = target;
				target = target.left;
				isLeftChild = true;
			}
			if (target == null)
				break;
		}
		if (target == null) {
			System.out.println("Node dosen't exist!" + "Can not delete.");
			return false;
		}

		if (target.left == null && target.right == null) {
			if (target.key == head.key) {
				head = null;
				return true;
			}
			if (isLeftChild)
				targetParent.left = null;
			else
				targetParent.right = null;
		}

		else if (target.left == null && target.right != null) {
			if (target.key == head.key) {
				head = head.right;
				return true;
			}
			if (isLeftChild)
				targetParent.left = target.right;
			else
				targetParent.right = target.right;
		}

		else if (target.left != null && target.right == null) {
			if (target.key == head.key) {
				head = head.left;
				return true;
			}
			if (isLeftChild)
				targetParent.left = target.left;
			else
				targetParent.right = target.left;
		}

		else {
			Node followingNode = this.getFollowingNode(target);
			if (target.key == head.key)
				head = followingNode;
			else if (isLeftChild)
				targetParent.left = followingNode;
			else
				targetParent.right = followingNode;
			followingNode.left = target.left;
			followingNode.right = target.right;
		}
		return true;
	}

	private Node getFollowingNode(Node node2Del) {
		Node nodeParent = node2Del;

		Node node = node2Del.right;
		while (node.left != null) {
			nodeParent = node;
			node = node.left;
		}
		if (node.key != node2Del.right.key)
			nodeParent.left = node.right;
		else
			nodeParent.right = node.right;
		return node;

	}

//	public void deleteAll() {
//		head = null;
//		tail = null;
//	}

	public String printTable() {
		Node x = head.right;
		if (head == null) {
			return null;
		} else if (head.right != null && head.left != null) {
			return head.name + " " + head.age + " " + head.room + " " + head.price + "\n";
		} else {
			return printTable();
		}

	}

}
