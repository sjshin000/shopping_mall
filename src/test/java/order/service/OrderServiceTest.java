package order.service;

import coupon.model.Coupon;
import coupon.service.CouponService;
import deal.model.Deal;
import deal.service.DealService;
import order.model.Order;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sjshin on 2016-04-13.
 */
public class OrderServiceTest {
	@Test
	public void test_01_상품쿠폰_사용가능1개(){
		DealService dealService = new DealService();
		CouponService couponService = new CouponService();
		List<Coupon> couponList = couponService.addCoupon();
		List<Deal> dealList = dealService.addDeal();


		OrderService orderService = new OrderService();
		String param = "123456,tmon,C2,H|1|C2";
		Order result = orderService.setParam(param);
		assertEquals(123456, result.getCartId());
	}

	@Test
	public void test_02_상품쿠폰_사용가능2개(){
		DealService dealService = new DealService();
		CouponService couponService = new CouponService();
		List<Coupon> couponList = couponService.addCoupon();
		List<Deal> dealList = dealService.addDeal();


		OrderService orderService = new OrderService();
		String param = "123456,tmon,C2,H|1|C1,H|1|C2";
		Order result = orderService.setParam(param);
		assertEquals(123456, result.getCartId());
	}

	@Test
	public void test_03_상품쿠폰_사용가능상품2(){
		DealService dealService = new DealService();
		CouponService couponService = new CouponService();
		List<Coupon> couponList = couponService.addCoupon();
		List<Deal> dealList = dealService.addDeal();


		OrderService orderService = new OrderService();
		String param = "123456,tmon,0,H|1|C1,L|1|C1-1";
		orderService.setParam(param);
	}


}
