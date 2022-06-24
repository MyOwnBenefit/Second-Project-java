package day22_project;

public class Customer {
	private String id;
	private String password;
	private String adress;
	private double point;
	private Cart cart;
	private Zzim zzim;
	private Coupon coupon;
	private double balance;

	public Customer(String id, String password, String adress, double point, double balance) {
		super();
		this.id = id;
		this.password = password;
		this.adress = adress;
		this.point = point;
		this.balance=balance;
		cart=new Cart();
		zzim=new Zzim();
	}

	
	public Zzim getZzim() {
		return zzim;
	}


	public void setZzim(Zzim zzim) {
		this.zzim = zzim;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Coupon getCoupon() {
		return coupon;
	}


	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
