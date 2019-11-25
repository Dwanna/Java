
class Node {
	int key;
	String name;
	int age;
	String room;
	int price;
	Node left;
	Node right;

	Node(int k, String nm, int a, String r, int p, Node ll, Node rr) {
		key = k;
		name = nm;
		age = a;
		room = r;
		price = p;
		left = ll;
		right = rr;
	}

	public int readKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String readName() {
		return name;
	}

	public int readAge() {
		return age;
	}

	public String readRoom() {
		return room;
	}

	public int readPrice() {
		return price;
	}
}