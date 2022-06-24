package day22_project;

public class Admin {
	private String id;
	private String password;
	
	public Admin() {}

	public Admin(String id, String password) {
		super();
		this.id = id;
		this.password = password;
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
	
	public void registerStore(Server server) {
        System.out.println("=====신규업체 추가 메뉴입니다.=====");
        System.out.print("업체 명을 입력하세요 : ");
        String name = Main.sc.next();

        System.out.print("전화번호를 입력하세요 : ");
        String phoneNumber = Main.sc.next();
        
        String no=Integer.toString((int)Math.random()*20+30);

        server.getStores().add(new Store(name, phoneNumber,no));
    }

}
