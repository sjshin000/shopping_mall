package coupon.service;

import coupon.model.Coupon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjshin on 2016-04-14.
 */
public class CouponService {
	public List<Coupon> addCoupon() {
		List<Coupon> couponList = new ArrayList<Coupon>();
		Coupon couponA = new Coupon();
		couponA.setCode("C1");
		couponA.setCouponName("알뜰 PC 할인 쿠폰");
		couponA.setCouponType("DEAL");  //CART
		couponA.setDiscountType("AMOUNT"); // DISCOUNTType{RATE, AMOUNT}  //적율/정액
		couponA.setTargetDeal("C1");
		couponA.setTargetAmount(50000);

		Coupon couponB = new Coupon();
		couponB.setCode("C1-1");
		couponB.setCouponName("알뜰 PC 할인 쿠폰2");
		couponB.setCouponType("DEAL");  //CART
		couponB.setDiscountType("AMOUNT"); // DISCOUNTType{RATE, AMOUNT}  //적율/정액
		couponB.setTargetDeal("C1");
		couponB.setTargetAmount(40000);
		couponList.add(couponB);
		return couponList;
	}

}
