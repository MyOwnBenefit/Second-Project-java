package day22_project;

public class Menu {

	private String name;
	private double price;
	private String no;


	public Menu() {
	}

	public Menu(String name, double price, String no) {
		super();
		this.name = name;
		this.price = price;
		this.no = no;
	
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + ", no=" + no + "]";
	}

	public void show() {
		System.out.println("��ǰ��ȣ:"+no);
		System.out.println("���ĸ�:" + name);
		System.out.println("����:" + price);
	}

}
