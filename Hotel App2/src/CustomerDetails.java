
public class CustomerDetails {
	private String name;
	private String roomType;

	public CustomerDetails(String name, String roomType) {

		this.name = name;
		this.roomType = roomType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

}
