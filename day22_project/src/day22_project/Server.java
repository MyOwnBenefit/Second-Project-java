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
		
		s1 = new Store("�ѿ���", "111-1111","0");
		s2 = new Store("�߱���", "222-2222","1");
		s3 = new Store("�Ͻ�õ��", "333-3333","2");
		s4 = new Store("�佺ƮǪ��", "444-4444","3");

		s1.getMenuList().add(new Menu("�Ұ��", 12000, "01"));
		s1.getMenuList().add(new Menu("��ġ�", 9000, "02"));
		s1.getMenuList().add(new Menu("�����", 6000, "03"));

		s2.getMenuList().add(new Menu("�Ⱥ�ä", 24000, "11"));
		s2.getMenuList().add(new Menu("���꽽", 24000, "12"));
		s2.getMenuList().add(new Menu("��������", 15000, "13"));

		s3.getMenuList().add(new Menu("���", 9000, "21"));
		s3.getMenuList().add(new Menu("�쵿", 5000, "22"));
		s3.getMenuList().add(new Menu("ȸ", 24000, "23"));

		s4.getMenuList().add(new Menu("����", 24000, "31"));
		s4.getMenuList().add(new Menu("���İ�Ƽ", 12000, "32"));
		s4.getMenuList().add(new Menu("�ܹ���", 8000, "33"));

		customers.add(new Customer("aa", "aa", "���ı�", 4000,100000));
		customers.add(new Customer("bb", "bb", "���ʱ�", 2000,200000));
		customers.add(new Customer("cc", "cc", "���Ǳ�", 3000,50000));
		
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
		System.out.println("�߰��� ������ �����ϼ���");
		System.out.println("1.�߱��� 2.�Ͻ�õ�� 3.�佺ƮǪ��");
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
        System.out.println("�α��ο� �����ϼ̽��ϴ�.");
        System.out.print("ȸ�������� �Ͻðڽ��ϱ�? [Y / N] : ");

        String checkSignUp = Main.sc.nextLine();

        if ("Y".equalsIgnoreCase(checkSignUp)) {
            System.out.println("======ȸ������======");

            String id = "";
            boolean isPossible = true;

            while (isPossible) {
                isPossible = false;
                System.out.print("ID�� �Է��ϼ��� : ");
                id = Main.sc.nextLine();

                for (Customer cs : customers) {
                    if (cs.getId().equals(id)) {
                        System.out.println("�̹� �����ϴ� ID �Դϴ�. �ٽ� �Է����ּ���.");
                        isPossible = true;
                        break;
                    }
                }
            }
            System.out.print("Password�� �Է��ϼ��� : ");
            String password = Main.sc.nextLine();
            
            System.out.print("�ּҸ� �Է��ϼ��� : ");
            String adress = Main.sc.nextLine();

            customers.add(new Customer(id, password,adress,0,0));
            System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ� !");
        }
    }
	
	public void show() {
		if(stores!=null) {
			for(Store s:stores) {
				s.show();
			}
			
		}else {
			System.out.println("������ �����ϴ�.");
		}
		
	}
	
	public Store select() {
		Store store=null;
		System.out.println("������ ������ȣ�� �����ϼ���");
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
