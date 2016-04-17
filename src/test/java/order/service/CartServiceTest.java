package order.service;

import cart.service.CartService;
import coupon.model.Coupon;
import coupon.service.CouponService;
import deal.model.Deal;
import deal.service.DealService;
import order.model.Order;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sjshin on 2016-04-17.
 * 딜쿠폰 정상 케이스 111112,tmon,0,L|6|C1
 * 카트쿠폰
 * 111112,tmon,C2,L|6|0
 */
public class CartServiceTest {
	@Test
	public void test_01_카트쿠폰과상품쿠폰이중복적용된경우() {
		DealService dealService = new DealService();
		CouponService couponService = new CouponService();
		List<Coupon> couponList = couponService.addCoupon();
		List<Deal> dealList = dealService.addDeal();
		OrderService orderService = new OrderService();

		String param = "111115,tmon,C2,H|1|C1,L|1|C1-1";
		Order result = orderService.setParam(param);
		CartService cartService = new CartService();
		cartService.getCartId("111112", dealList, couponList);
		System.out.println("===TotalDealAmount :" + result.getTotalAmount());
		assertEquals(111113, result.getCartId());
	}
}
