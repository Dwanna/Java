
public class manageDetails {
	private CustomerDetails customer;
	private int price;
	private int age;

	public manageDetails(String n, int a, String r, int p) {
		customer = new CustomerDetails(n, r);
		this.price = p;
		this.age = a;

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String n) {
		customer.setName(n);
	}

	public void setRoom(String r) {
		customer.setRoomType(r);
	}

	public String readRoom() {
		return customer.getRoomType();
	}

	public String readName() {
		return customer.getName();
	}

	public void setAge(int a) {
		this.age = a;
	}

	public int readAge() {
		return age;
	}

	public String printDetails() {
		return customer.getName() + " booked " + customer.getRoomType() + " which cost " + this.price + "£";
	}

}
