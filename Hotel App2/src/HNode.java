
class HNode {
	int key;
	String name;
	int age;
	String roomType;
	int price;
	HNode next;

	HNode(int k, String n, int a, String rt, int p) {
		key = k;
		name = n;
		age = a;
		roomType = rt;
		price = p;
		next = null;
	}

	public int readKey() {
		return key;
	}

	public String readRoomType() {
		return roomType;
	}

	public int readPrice() {
		return price;
	}

	public String readName() {
		return name;
	}

	public int readAge() {
		return age;
	}

	public String print() {
		return "[" + key + ":" + name + ":" + age + ":" + roomType + " " + price + "]-->";
	}
}
