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
			System.out.println("안녕하세요 배달앱입니다. 무엇을도와드릴까요");
			System.out.println("press any key:진행  2:종료");
			String num = sc.nextLine();

			if (num.equals("2"))
				break;
			System.out.println("로그인을 진행합니다 ID, Password를 입력하세요");
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
			System.out.println("1.상점  2.장바구니관리 3.찜관리 4.쿠폰받기 5.상위");
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
			System.out.println("1.업체추가 2.신규추가 3.목록 4.종료");
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
			System.out.println("1.주문진행 2.종료");
			String key = Main.sc.next();
			if (key.equals("2")) {
				break;
			}

			System.out.println("주문하실 음식을 고르세요");

			for (Menu m : s.getMenuList())
				m.show();
			String orderNo = Main.sc.next();
			
			System.out.println("1.장바구니에추가 2.찜목록에추가");
			String num=Main.sc.next();
			if(num.equals("1")) {
			for (Menu m : s.getMenuList()) {
				if (m.getNo().equals(orderNo))
					cs.getCart().addCart(s, orderNo); // 장바구니에 추가
			}
			}else if(num.equals("2")) {
				for (Menu m : s.getMenuList()) {
					if (m.getNo().equals(orderNo))
						cs.getZzim().addZzim(s, orderNo); // 찜목록에 추가
				}
			}else {
				System.out.println("주문이취소되었습니다.");
			}

		}
	}

	public void cartManual(Customer cs) {

		while (true) {
			System.out.println("1.카트확인  2.목록제거 3.결제 4.상위");
			String key = Main.sc.next();
			switch (key) {
			case "1":
				cs.getCart().showCart();
				break;
			case "2":
				System.out.println("제거할 상품번호을 입력하시오");
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
			System.out.println("1.찜목록확인  2.목록제거 3.카트에전송 4.상위");
			String key = Main.sc.next();
			switch (key) {
			case "1":
				cs.getZzim().showZzim();
				break;
			case "2":
				System.out.println("제거할 상품번호을 입력하시오");
				String no = Main.sc.next();
				cs.getZzim().deleteZzim(no);
				break;
			case "3":
				cs.getZzim().showZzim();
				System.out.println("카트에 전송할 상품번호를 입력하세요");
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

