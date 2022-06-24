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

    //�ֹ��ϱ�
    public void order(Server server,Customer customer) {
    	
        //��ٱ��� ��������
        cart = customer.getCart();
        
        
      
        //Exception
        if (customer.getCart().getMenus().isEmpty()) {
            System.out.println("��ٱ��ϰ� ������ϴ�.");
            return;
        }
        
        //�ش��ϴ� ������ ã��(�����׷���)
      
        for(Menu m: cart.getMenus()) {
        	int num=Integer.parseInt(m.getNo());
        	if(!stores.contains(server.getStore(Integer.toString(num/10))))
        		stores.add(server.getStore(Integer.toString(num/10)));
        }
        
        
        //���
        double totalPrice = 0, discountPrice = 0;
        for (Menu menu : cart.getMenus()) totalPrice += menu.getPrice();
        if(customer.getCoupon()!=null) {
        discountPrice = totalPrice * (100 - customer.getCoupon().getDiscountPercent()) / 100;
        System.out.println("���� ���� ���� ���� ���� : " + customer.getCoupon().getDiscountPercent() + "%");
        System.out.println("���ε� ���� : " + discountPrice + "�� �Դϴ�.");
        }else {
        	discountPrice=totalPrice;
        System.out.println("������: "+discountPrice+"�� �Դϴ�.");
        }
 


        if (discountPrice > customer.getBalance()) {
            System.out.println("�ܾ��� �����մϴ�.");
            return;
        }

        System.out.println("����Ʈ�� ����Ͻðڽ��ϱ�?[Y / N]");
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
        System.out.println("�ܾ��� " + customer.getBalance() + "��");
        System.out.println("�ܿ� ����Ʈ�� "+ customer.getPoint() + "����Ʈ");
        System.out.println("�̿��� �ּż� �����մϴ� :)");
        
        String adress=customer.getAdress();
        
        int time=0;
        switch (adress) {
		case "���ı�":
			System.out.println("��޽ð�: �� 20�� �ҿ俹��");
			time=(int)(Math.random()*10)+20;
			break;
		case "���Ǳ�":
			System.out.println("��޽ð�: �� 10�� �ҿ俹��");
			time=(int)(Math.random()*10)+10;
			break;

		case "���ʱ�":
			System.out.println("��޽ð�: �� 30�� �ҿ俹��");
			time=(int)(Math.random()*10)+30;
			break;
		}
        System.out.print(time+"*0.5��");
        System.out.println("�� ���� ����ð��Դϴ�.");
        try {
			Thread.sleep(time*500);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        System.out.println("������ �����߽��ϴ�! ���ְԵ�ʼ�");
        
        rate(server);
        
        
    }

    
   
	//���� �����
    public void rate(Server server) {
    	for(Store s:stores) {
    		System.out.println("������ �Ű��ּ��� 1~5����!!");
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
