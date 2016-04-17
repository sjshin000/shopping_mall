package main;

import order.model.Order;
import order.model.OrderDeal;

import java.util.List;

/**
 * Created by sjshin on 2016-04-13.
 */
public class Screen {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public void printMessage(String message) {
		System.out.println(ANSI_YELLOW + message + ANSI_RESET); //
	}

	public void printOrder(Order order) {

		List<OrderDeal> orderDealList = order.getOrderDealList();
		System.out.println(ANSI_YELLOW
				+ "장바구니ID: " + order.getCartId()
				+ "\n사용자 ID : " + order.getUserId()
				+ "\n장바구니쿠폰코드 : " + order.getCartCouponCode()
				+ "\n카트할인금액 : " + order.getCartDiscountAmount() + " 원"
				+ "\n총 주문금액 : " + order.getTotalAmount() + " 원"
				+ ANSI_RESET
		);
		for(OrderDeal orderDeal : orderDealList) {
			System.out.println(ANSI_YELLOW
					+ "\n상품코드|수량|상품쿠폰코드 : " + orderDeal.getDealCode()+"|"+orderDeal.getDealCount()+"|"+orderDeal.getDealCouponCode()
					+ "\n상품금액 : " + orderDeal.getDealAmount() + " 원"
					+ "\n할인금액 : " + orderDeal.getDealDiscountAmount() + " 원"
					+ ANSI_RESET);
		}

	}
}
