package day22_project;

import java.util.ArrayList;
import java.util.List;

public class Order{

    private Cart cart;
    private List<Store> stores;
    
    public Order() {
    	  stores=new ArrayList<>();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    //주문하기
    public void order(Server server,Customer customer) {
    	
        //장바구니 가져오기
        cart = customer.getCart();
        
        
      
        //Exception
        if (customer.getCart().getMenus().isEmpty()) {
            System.out.println("장바구니가 비었습니다.");
            return;
        }
        
        //해당하는 상점명 찾기(별점테러용)
      
        for(Menu m: cart.getMenus()) {
        	int num=Integer.parseInt(m.getNo());
        	if(!stores.contains(server.getStore(Integer.toString(num/10))))
        		stores.add(server.getStore(Integer.toString(num/10)));
        }
        
        
        //계산
        double totalPrice = 0, discountPrice = 0;
        for (Menu menu : cart.getMenus()) totalPrice += menu.getPrice();
        if(customer.getCoupon()!=null) {
        discountPrice = totalPrice * (100 - customer.getCoupon().getDiscountPercent()) / 100;
        System.out.println("현재 보유 중인 할인 쿠폰 : " + customer.getCoupon().getDiscountPercent() + "%");
        System.out.println("할인된 가격 : " + discountPrice + "원 입니다.");
        }else {
        	discountPrice=totalPrice;
        System.out.println("가격은: "+discountPrice+"원 입니다.");
        }
 


        if (discountPrice > customer.getBalance()) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        System.out.println("포인트를 사용하시겠습니까?[Y / N]");
        String check = Main.sc.next();

        if (check.equalsIgnoreCase("Y")) {
            discountPrice -= customer.getPoint();
            if (discountPrice <= 0) discountPrice = 0;
            customer.setBalance(customer.getBalance() - discountPrice);
            customer.setPoint(0);
        }
        else {
            customer.setBalance(customer.getBalance() - discountPrice);
            customer.setPoint(customer.getPoint()+(discountPrice)*0.05);
        }

        customer.getCart().getMenus().clear();
        if(customer.getCoupon()!=null) customer.getCoupon().setDiscountPercent(0);
        System.out.println("잔액은 " + customer.getBalance() + "원");
        System.out.println("잔여 포인트는 "+ customer.getPoint() + "포인트");
        System.out.println("이용해 주셔서 감사합니다 :)");
        
        String adress=customer.getAdress();
        
        int time=0;
        switch (adress) {
		case "송파구":
			System.out.println("배달시간: 약 20분 소요예정");
			time=(int)(Math.random()*10)+20;
			break;
		case "관악구":
			System.out.println("배달시간: 약 10분 소요예정");
			time=(int)(Math.random()*10)+10;
			break;

		case "서초구":
			System.out.println("배달시간: 약 30분 소요예정");
			time=(int)(Math.random()*10)+30;
			break;
		}
        System.out.print(time+"*0.5초");
        System.out.println("가 실제 진행시간입니다.");
        try {
			Thread.sleep(time*500);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        System.out.println("음식이 도착했습니다! 맛있게드십쇼");
        
        rate(server);
        
        
    }

    
   
	//평점 남기기
    public void rate(Server server) {
    	for(Store s:stores) {
    		System.out.println("평점을 매겨주세요 1~5까지!!");
    		for(Store s1:server.getStores()) {
    			if(s.equals(s1)) {
    				System.out.println(s1.getName());
    				double num=Main.sc.nextInt();
    				s1.setGrade((s1.getGrade()+num)/(s1.getGradecount()+1));
    				s1.setGradecount(s1.getGradecount()+1);
    				
    			}
    		}
    		
    	}
    }
}
