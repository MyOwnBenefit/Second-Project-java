package day22_project;

public class Coupon {

    private int discountPercent;

    public Coupon() {
        System.out.println("=====ÄíÆù ÀÌº¥Æ®=====");
        discountPercent = (int)(Math.random()*10) + 20;
        System.out.println(discountPercent + "% ÇÒÀÎ ÄíÆù¿¡ ´çÃ·µÇ¼Ì½À´Ï´Ù!");
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
}
