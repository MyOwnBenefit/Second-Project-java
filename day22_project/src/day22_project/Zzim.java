package day22_project;

import java.util.ArrayList;

public class Zzim {
	private ArrayList<Menu> menus;

	public Zzim() {
		menus = new ArrayList<>();
	}
	
	

	public ArrayList<Menu> getMenus() {
		return menus;
	}



	public void setMenus(ArrayList<Menu> menus) {
		this.menus = menus;
	}



	public void addZzim(Store s,String no) {
		for (int i = 0; i < s.getMenuList().size(); i++) {
			String str = s.getMenuList().get(i).getNo();
			if (str.equals(no))
				menus.add(s.getMenuList().get(i));
		}

	}
	
	public void deleteZzim(String no) {
		for(Menu m:menus) {
			if(m.getNo().equals(no)) {
				menus.remove(m);
				System.out.println("성공적으로제거되었습니다");
				return;
			}
		}
	}

	public void showZzim() {
		if(menus!=null) {
		for(Menu m:menus) m.show();
		}else {
			System.out.println("목록이 없습니다.");
		}
	}
	
	
}
	