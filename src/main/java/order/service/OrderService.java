package order.service;

import main.Screen;
import order.model.Order;
import order.model.OrderDeal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjshin on 2016-04-13.
 * // "장바구니ID 숫자 6자리, 사용자 ID(alphanumberic 4~12자리), 장바구니쿠폰코드, 상품코드|수량|상품쿠폰코드 입력하세요. "
 //	+ "\n 입력값예시: 123456, tmon, C3, H|1|C2")
 */
public class OrderService {
	public Order setParam(String param) { //, List<Deal> dealList, List<Coupon> couponList
		Order order = new Order();
		String[] dataOrder = param.split(",");

		List<OrderDeal> orderDealList = new ArrayList<OrderDeal>();

		order.setCartId(Integer.parseInt(dataOrder[0]));
		order.setUserId(dataOrder[1]);
		order.setCartCouponCode(dataOrder[2]);

		for(int index = 3; dataOrder.length > index; index++) {
			OrderDeal orderDeal = new OrderDeal();  //딜리스트
			String[] dataDeal = dataOrder[index].split("\\|");

			orderDeal.setCartId(Integer.parseInt(dataOrder[0]));
			orderDeal.setDealCode(dataDeal[0]);
			orderDeal.setDealCount(Integer.parseInt(dataDeal[1]));
			orderDeal.setDealCouponCode(dataDeal[2]);

			orderDealList.add(orderDeal);
		}
		order.setOrderDealList(orderDealList);

		//orderDeal List 찍어보기
		System.out.println("orderDealList size : " + orderDealList.size());
		System.out.println(Screen.ANSI_YELLOW
				+ "카트아이디 : " + order.getCartId()
				+ " 유저아이디 : " + order.getUserId()
				+ " 카트쿠폰코드 : " + order.getCartCouponCode()
				+ Screen.ANSI_RESET);
		for(OrderDeal orderDeal1 : orderDealList) {
			System.out.println(Screen.ANSI_YELLOW
					+ "카트아이디 " + orderDeal1.getCartId()
					+ " 딜코드 " + orderDeal1.getDealCode()
					+ " 딜수량 " + orderDeal1.getDealCount()
					+ " 딜쿠폰코드 " + orderDeal1.getDealCouponCode()
			+ Screen.ANSI_RESET);
		}
		saveFile(order);
		return order;
	}

	private void saveFile(Order order) {
		try {
			FileOutputStream fs = new FileOutputStream("c:\\work_2_study\\shopping_mall\\" + order.getCartId() + ".ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(order);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
