package day22_project;

import java.util.ArrayList;

public class Server {

	private ArrayList<Store> stores;
	private ArrayList<Customer> customers;
	private Admin admin;
	
	private Store s1,s2,s3,s4;
	
	
	public Server() {
		initialize();
	}

	public void initialize() {
		stores=new ArrayList<>();
		customers=new ArrayList<>();
		admin = new Admin("zz", "zz");
		
		s1 = new Store("한월림", "111-1111","0");
		s2 = new Store("중국몽", "222-2222","1");
		s3 = new Store("일식천국", "333-3333","2");
		s4 = new Store("페스트푸드", "444-4444","3");

		s1.getMenuList().add(new Menu("불고기", 12000, "01"));
		s1.getMenuList().add(new Menu("김치찌개", 9000, "02"));
		s1.getMenuList().add(new Menu("녹두전", 6000, "03"));

		s2.getMenuList().add(new Menu("팔보채", 24000, "11"));
		s2.getMenuList().add(new Menu("유산슬", 24000, "12"));
		s2.getMenuList().add(new Menu("누룽지탕", 15000, "13"));

		s3.getMenuList().add(new Menu("돈까스", 9000, "21"));
		s3.getMenuList().add(new Menu("우동", 5000, "22"));
		s3.getMenuList().add(new Menu("회", 24000, "23"));

		s4.getMenuList().add(new Menu("피자", 24000, "31"));
		s4.getMenuList().add(new Menu("스파게티", 12000, "32"));
		s4.getMenuList().add(new Menu("햄버거", 8000, "33"));

		customers.add(new Customer("aa", "aa", "송파구", 4000,100000));
		customers.add(new Customer("bb", "bb", "서초구", 2000,200000));
		customers.add(new Customer("cc", "cc", "관악구", 3000,50000));
		
		stores.add(s1);

	}

	public int logIn(String id, String password) {
		int result = 0;
		for (int i = 0; i < customers.size(); i++) {
			if (id.equals(customers.get(i).getId()) && password.equals(customers.get(i).getPassword())) {
				result = 1;
			} else if (id.equals(admin.getId()) && password.equals(admin.getPassword())) {
				result = 2;
			}
		}
		return result;
	}

	public Customer getCustomer(String password) {
		Customer cus = null;
		for (int i = 0; i < customers.size(); i++) {
			if (password.equals(customers.get(i).getPassword()))
				cus = customers.get(i);

		}
		return cus;
	}

	public void addStore() {
		System.out.println("추가할 상점를 선택하세요");
		System.out.println("1.중국몽 2.일식천국 3.페스트푸드");
		String key = Main.sc.next();

		switch (key) {
		case "1":
			if(!stores.contains(s2)) stores.add(s2);
			break;
		case "2":
			if(!stores.contains(s3))stores.add(s3);
			break;
		case "3":
			if(!stores.contains(s4))stores.add(s4);
			break;
		}
	}
	
	public void signUp() {
        System.out.println("로그인에 실패하셨습니다.");
        System.out.print("회원가입을 하시겠습니까? [Y / N] : ");

        String checkSignUp = Main.sc.nextLine();

        if ("Y".equalsIgnoreCase(checkSignUp)) {
            System.out.println("======회원가입======");

            String id = "";
            boolean isPossible = true;

            while (isPossible) {
                isPossible = false;
                System.out.print("ID를 입력하세요 : ");
                id = Main.sc.nextLine();

                for (Customer cs : customers) {
                    if (cs.getId().equals(id)) {
                        System.out.println("이미 존재하는 ID 입니다. 다시 입력해주세요.");
                        isPossible = true;
                        break;
                    }
                }
            }
            System.out.print("Password를 입력하세요 : ");
            String password = Main.sc.nextLine();
            
            System.out.print("주소를 입력하세요 : ");
            String adress = Main.sc.nextLine();

            customers.add(new Customer(id, password,adress,0,0));
            System.out.println("회원가입이 완료되었습니다 !");
        }
    }
	
	public void show() {
		if(stores!=null) {
			for(Store s:stores) {
				s.show();
			}
			
		}else {
			System.out.println("상점이 없습니다.");
		}
		
	}
	
	public Store select() {
		Store store=null;
		System.out.println("입장할 상점번호를 선택하세요");
		String key=Main.sc.next();
		
		for(Store s:stores) {
			if(s.getNo().equals(key)) {
				store=s;
			}
		}
		return store;
	}
	
	public Store getStore(String num) {
		for(Store s:stores) {
			if(num.equals(s.getNo()))
					return s;
		}
		return null;
	}

	public ArrayList<Store> getStores() {
		return stores;
	}

	public void setStores(ArrayList<Store> stores) {
		this.stores = stores;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
}
