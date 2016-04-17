package main;

/**
 * Created by sjshin on 2016-04-13.
 */

import cart.service.CartService;
import coupon.model.Coupon;
import coupon.service.CouponService;
import deal.model.Deal;
import deal.service.DealService;
import order.model.Order;
import order.service.OrderService;

import java.util.List;

import static main.MessageCode.CODE_101;
import static main.MessageCode.CODE_103;

public class Main {
	public static void main(String[] args) {
		DealService dealService = new DealService();
		CouponService couponService = new CouponService();

		List<Coupon> couponList = couponService.addCoupon();
		List<Deal> dealList = dealService.addDeal();

		Screen screen = new Screen();
		InputData inputData = new InputData();

		screen.printMessage(CODE_101.getMessage());  //print(CODE_101.getMessage());
		String param = inputData.inputString();

		//입력데이터 order 모델로 리턴, 장바구니 아이디를 출력
		OrderService orderService  = new OrderService();
		Order order = orderService.setParam(param);
		screen.printMessage("장바구니 아이디는 " + order.getCartId() + "입니다");

		screen.printMessage(CODE_103.getMessage());  //print(CODE_101.getMessage());
		String inputCartId = inputData.inputString();

		CartService cartService = new CartService();
		cartService.getCartId(inputCartId, dealList, couponList);

	}

}
