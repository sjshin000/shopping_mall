package main;

/**
 * Created by sjshin on 2016-04-13.
 */

import coupon.model.Coupon;
import coupon.service.CouponService;
import deal.model.Deal;
import deal.service.DealService;
import order.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static main.MessageCode.*;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
		DealService dealService = new DealService();
		CouponService couponService = new CouponService();

		List<Coupon> couponList = couponService.addCoupon();
		List<Deal> dealList = dealService.addDeal();


		Screen screen = new Screen();
		InputData inputData = new InputData();

		screen.printMessage(CODE_101.getMessage());  //print(CODE_101.getMessage());
		String param = inputData.inputString();

				//입력데이터 order로
		OrderService orderService  = new OrderService();
		int cartId = orderService.setParam(param);
		screen.printMessage("장바구니 아이디는 " + cartId + "입니다");

		screen.printMessage(CODE_103.getMessage());  //print(CODE_101.getMessage());
		String inputCartId = inputData.inputString();

	}

}
