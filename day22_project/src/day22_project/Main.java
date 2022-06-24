package day22_project;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Main m = new Main();
	static Server server = new Server();

	public static void main(String[] args) {

		Customer cs;
		Admin ad;

		while (true) {
			System.out.println("�ȳ��ϼ��� ��޾��Դϴ�. ���������͵帱���");
			System.out.println("press any key:����  2:����");
			String num = sc.nextLine();

			if (num.equals("2"))
				break;
			System.out.println("�α����� �����մϴ� ID, Password�� �Է��ϼ���");
			System.out.print("ID:");
			String ID = sc.nextLine();
			System.out.print("password:");
			String password = sc.nextLine();

			int verify = server.logIn(ID, password);

			switch (verify) {
			case 1: // customer
				cs = server.getCustomer(password);
				m.customerManual(cs);
				break;
			case 2: // manager
				ad=server.getAdmin();
				m.adminManual(ad);
				break;
			case 0: // non
				server.signUp();
				break;
			}

		}

	}

	public void customerManual(Customer cs) {
		while (true) {
			System.out.println("1.����  2.��ٱ��ϰ��� 3.����� 4.�����ޱ� 5.����");
			String verify = sc.next();

			switch (verify) {
			case "1":
				server.show();
				Store s = server.select();
				storeManual(cs, s);
				break;
			case "2":
				cartManual(cs);
				break;
			case "3":
				zzimManual(cs);
				break;
			case "4":
				Coupon coupon=new Coupon();
				cs.setCoupon(coupon);
				break;
			case "5":
				return;
			}

		}

	}

	public void adminManual(Admin ad) {
		while(true) {
			System.out.println("1.��ü�߰� 2.�ű��߰� 3.��� 4.����");
			String key=sc.next();
			switch (key) {
			case "1":
				server.addStore();
				break;
			case "2":
				ad.registerStore(server);
				break;
			case "3":
				for(Store s:server.getStores()) s.show();
				break;
			case "4":
				return;
			}
		}
	

	}

	public void storeManual(Customer cs, Store s) {
		if(s==null) return;
		while (true) {
			System.out.println("1.�ֹ����� 2.����");
			String key = Main.sc.next();
			if (key.equals("2")) {
				break;
			}

			System.out.println("�ֹ��Ͻ� ������ ������");

			for (Menu m : s.getMenuList())
				m.show();
			String orderNo = Main.sc.next();
			
			System.out.println("1.��ٱ��Ͽ��߰� 2.���Ͽ��߰�");
			String num=Main.sc.next();
			if(num.equals("1")) {
			for (Menu m : s.getMenuList()) {
				if (m.getNo().equals(orderNo))
					cs.getCart().addCart(s, orderNo); // ��ٱ��Ͽ� �߰�
			}
			}else if(num.equals("2")) {
				for (Menu m : s.getMenuList()) {
					if (m.getNo().equals(orderNo))
						cs.getZzim().addZzim(s, orderNo); // ���Ͽ� �߰�
				}
			}else {
				System.out.println("�ֹ�����ҵǾ����ϴ�.");
			}

		}
	}

	public void cartManual(Customer cs) {

		while (true) {
			System.out.println("1.īƮȮ��  2.������� 3.���� 4.����");
			String key = Main.sc.next();
			switch (key) {
			case "1":
				cs.getCart().showCart();
				break;
			case "2":
				System.out.println("������ ��ǰ��ȣ�� �Է��Ͻÿ�");
				String no = Main.sc.next();
				cs.getCart().deleteCart(no);
				break;
			case "3":
				Order order=new Order();
				order.order(server,cs);
				break;
			case "4":
				return;
			}
		}
	}
	
	
	public void zzimManual(Customer cs) {

		while (true) {
			System.out.println("1.����Ȯ��  2.������� 3.īƮ������ 4.����");
			String key = Main.sc.next();
			switch (key) {
			case "1":
				cs.getZzim().showZzim();
				break;
			case "2":
				System.out.println("������ ��ǰ��ȣ�� �Է��Ͻÿ�");
				String no = Main.sc.next();
				cs.getZzim().deleteZzim(no);
				break;
			case "3":
				cs.getZzim().showZzim();
				System.out.println("īƮ�� ������ ��ǰ��ȣ�� �Է��ϼ���");
				String str=Main.sc.next();
				for(Menu m: cs.getZzim().getMenus()) {
					if(m.getNo().equals(str)) {
						cs.getCart().plusCart(m);
						cs.getZzim().deleteZzim(str);
						break;
					}
				}
			case "4":
				return;
			}
		}
	}
}

