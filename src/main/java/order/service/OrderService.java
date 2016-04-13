package order.service;

import order.model.Order;
import order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by sjshin on 2016-04-13.
 * // "장바구니ID 숫자 6자리, 사용자 ID(alphanumberic 4~12자리), 장바구니쿠폰코드, 상품코드|수량|상품쿠폰코드 입력하세요. "
 //	+ "\n 입력값예시: 123456, tmon, C3, H|1|C2")
 */
@Service
public class OrderService implements Serializable{
	@Autowired
	OrderRepository orderRepository;

	public int setParam(String param) {
		Order order = new Order();

		String[] data = param.split(",");
		String data2 = data[3];
		String[] dataDeal = data2.split("|");

		try {
			order.setCartId(Integer.parseInt(data[0]));
			order.setUsserId(data[1]);
			order.setCartCouponCode(data[2]);
			order.setDealCode(dataDeal[0]);
			order.setDealCount(Integer.parseInt(dataDeal[2]));
			order.setCartCouponCode(dataDeal[4]);
			System.out.println("성공1");
			int count= orderRepository.insert(order);

			System.out.println("성공2" + count);
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
		}
		return order.getCartId();
	}

//	private void saveFile(Order order) {
//		try {
//			System.out.println("=================saveFile");
////			FileOutputStream fs = new FileOutputStream("c:\\work_2_study\\shopping_mall\\test1.ser");
////			System.out.println("=================saveFile1");
////			ObjectOutputStream os = new ObjectOutputStream(fs);
////			System.out.println("=================saveFile2");
////			os.writeObject(order);
////			System.out.println("=================saveFile3");
////			os.close();
////			System.out.println("=================saveFile4");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
