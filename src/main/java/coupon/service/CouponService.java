package coupon.service;

import cart.model.Cart;
import coupon.model.Coupon;
import order.model.Order;
import order.model.OrderDeal;

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
		couponA.setTargetDeal("L");
		couponA.setCouponCount(0);
		couponA.setDiscountAmount(50000);
		couponList.add(couponA);

		Coupon couponB = new Coupon();
		couponB.setCode("C1-1");
		couponB.setCouponName("알뜰 PC 할인 쿠폰2");
		couponB.setCouponType("DEAL");  //CART
		couponB.setDiscountType("AMOUNT"); // DISCOUNTType{RATE, AMOUNT}  //적율/정액
		couponB.setTargetDeal("L");
		couponB.setTargetCountMax(10);
		couponB.setTargetCountMin(5);
		couponB.setDiscountAmount(40000);
		couponB.setCouponCount(0);
		couponList.add(couponB);

		Coupon couponC = new Coupon();
		couponC.setCode("C2");
		couponC.setCouponName("장바구니쿠폰");
		couponC.setCouponType("CART");  //CART
		couponC.setDiscountType("RATE"); // DISCOUNTType{RATE, AMOUNT}  //적율/정액
		couponC.setTargetDeal("ALL");
		couponC.setTargetAmount(3000000);
		couponC.setRate(10);
		couponC.setCouponCount(0);
		couponList.add(couponC);

		Coupon couponD = new Coupon();
		couponD.setCode("C1-1");
		couponD.setCouponName("선착순 할인 쿠폰");
		couponD.setCouponType("CART");  //CART
		couponD.setDiscountType("RATE"); // DISCOUNTType{RATE, AMOUNT}  //적율/정액
		couponD.setTargetDeal("ALL");
		couponD.setRate(20);
		couponD.setCouponCount(10);
		couponList.add(couponD);

		return couponList;
	}


	public Cart couponValid(Order order, List<Coupon> couponList) {
		Cart cart = new Cart();
		List<OrderDeal> orderDealList = order.getOrderDealList();

		for(OrderDeal orderDeal : orderDealList) {
			if(null != orderDeal.getDealCouponCode() && !"0".equals(orderDeal.getDealCouponCode()) && null != order.getCartCouponCode() && !"0".equals(order.getCartCouponCode())) {
				cart.setCouponResult(false);
				cart.setOrder(order);
				System.out.println("========쿠폰 중복 사용===");
			}
			cart.setCouponResult(true);
			cart.setOrder(order);
		}
		return cart;
	}

	public Cart cartCouponValid(Order order, List<Coupon> couponList) {
		Cart cart = new Cart();
		System.out.println("cartCouponValid " + order.getCartCouponCode());


		//카트쿠폰의 딜대상/쿠폰대상 target 검증
		for(Coupon coupon : couponList) {
			if(coupon.getCode() == order.getCartCouponCode() && coupon.getCouponType() == "CART" && order.getCartAmount() >= coupon.getTargetAmount()) {
				System.out.println("카트쿠폰 검증 ");
				order.setCartDiscountAmount((order.getCartAmount() * coupon.getRate() / 100));
				cart.setCouponResult(true);
				cart.setOrder(order);
			} else {
				cart.setCouponResult(true);
				cart.setOrder(order);
			}

		}
		return cart;
	}

	public Cart dealCouponValid(Order order, List<Coupon> couponList) {
		Cart cart = new Cart();
		List<OrderDeal> orderDealList = order.getOrderDealList();
		Boolean result = false;

		for(OrderDeal orderDeal : orderDealList) {
			for(Coupon coupon : couponList) {
				System.out.println(" 딜 코드들 : " + orderDeal.getDealCouponCode()+coupon.getCode()+ orderDeal.getDealCode()+coupon.getTargetDeal());
				if(orderDeal.getDealCouponCode().equals(coupon.getCode()) && orderDeal.getDealCode().equals(coupon.getTargetDeal())) {
					System.out.println("====2 " + orderDeal.getDealDiscountAmount());
					if(coupon.getTargetCountMin() <= orderDeal.getDealCount() && orderDeal.getDealCount() >= coupon.getTargetCountMax()) {

						orderDeal.setDealDiscountAmount(coupon.getDiscountAmount());

						result = true;

						System.out.println("====딜쿠폰 : " );
					}
				}
			}
		}
		cart.setCouponResult(result);
		order.setOrderDealList(orderDealList);
		cart.setOrder(order);
		return cart;
	}
}
