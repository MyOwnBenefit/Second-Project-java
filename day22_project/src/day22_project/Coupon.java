package day22_project;

public class Coupon {

    private int discountPercent;

    public Coupon() {
        System.out.println("=====���� �̺�Ʈ=====");
        discountPercent = (int)(Math.random()*10) + 20;
        System.out.println(discountPercent + "% ���� ������ ��÷�Ǽ̽��ϴ�!");
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
}
