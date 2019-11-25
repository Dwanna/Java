import javax.swing.JOptionPane;

class HashTable implements Container1, Iterator {
	public int hash(int id) {
		return id % 20;
	}

	private HNode[] head = new HNode[20];
	// private int index;
	private HNode node;
	public int step;
	private int index;

	public HashTable() {
		for (int i = 0; i < 20; i++)
			head[i] = null;
		index = 0;
	}

	public void insert(int k, String n, int a, String r, int p) {
		if (this.search(k) != null) {
			JOptionPane.showMessageDialog(null, "It already exist, try different values");
		} else {

			HNode temp = new HNode(k, n, a, r, p);
			int index = hash(k);
			temp.next = head[index];
			head[index] = temp;
		}
	}

	public void setIndex() {
		this.index = 0;
	}

	public int readIndex() {
		return index;
	}

	public int getStep() {
		return step;
	}

	public HNode search(int k) {
		step = 0;
		int index = hash(k);
		HNode temp = head[index];
		boolean found = false;
		while (temp != null && found == false) {
			step++;/// Counts how many steps it takes to search
			if (temp.key == k) {
				found = true;
				break;
			}
			temp = temp.next;
		}
		return temp;
	}

	public boolean delete(int k) {
		int index = hash(k);
		if (this.search(k) == null) {
			return false;
		}
		HNode temp = head[index];
		HNode remove = temp;
		if (temp.key == k) {
			head[index] = temp.next;
		} else {
			while (temp != null && temp.key != k) {
				remove = temp;
				temp = temp.next;
			}
			remove.next = temp.next;
		}
		return true;
	}

	public void printTable() {
		for (int i = 0; i < 20; i++) {
			HNode temp = head[i];

			System.out.println("\n");
			System.out.print("[ " + i + "]->");
			while (temp != null) {
				temp.print();
				temp = temp.next;
			}

			System.out.print("NULL");
		}

	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index < 20;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return head[index++];
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return this;
	}

}
