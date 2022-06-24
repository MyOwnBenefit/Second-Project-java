package day22_project;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Menu> menus;

	public Cart() {
		menus = new ArrayList<>();
	}
	
	

	public ArrayList<Menu> getMenus() {
		return menus;
	}



	public void setMenus(ArrayList<Menu> menus) {
		this.menus = menus;
	}



	public void addCart(Store s,String no) {
		for (int i = 0; i < s.getMenuList().size(); i++) {
			String str = s.getMenuList().get(i).getNo();
			if (str.equals(no))
				menus.add(s.getMenuList().get(i));
		}

	}
	
	public void deleteCart(String no) {
		for(Menu m:menus) {
			if(m.getNo().equals(no)) {
				menus.remove(m);
				System.out.println("성공적으로제거되었습니다");
				return;
			}
		}
	}

	public void showCart() {
		if(menus!=null) {
		for(Menu m:menus) m.show();
		}else {
			System.out.println("목록이 없습니다.");
		}
	}

	public double showPrice() {
		double price = 0;
		Menu m;
		for (int i = 0; i < menus.size(); i++) {
			m = menus.get(i);

			price += m.getPrice();
		}
		return price;
	}
	
	public void plusCart(Menu m) {
		menus.add(m);
	}

}
