package cart.service;

import cart.model.Cart;
import coupon.model.Coupon;
import coupon.service.CouponService;
import deal.model.Deal;
import main.Screen;
import order.model.Order;
import order.model.OrderDeal;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by sjshin on 2016-04-13.
 */
public class CartService {
	public Order getCartId(String inputCartId, List<Deal> dealList, List<Coupon> couponList) {
		Order order = new Order();
		try {
			FileInputStream fis = new FileInputStream("c:\\work_2_study\\shopping_mall\\" + inputCartId + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			order = (Order)ois.readObject();
			ois.close();
			System.out.println("=================order " + order.getCartId());

			//order 정보 set
			orderAmountSet(order, dealList, couponList);

			CouponService couponService = new CouponService();

			//쿠폰 중복 사용 검증
			Cart couponValid = couponService.couponValid(order, couponList);
			System.out.println("=======Cart couponValid ==" + couponValid.getCouponResult());
			System.out.println("=======Cart couponValid.getOrder() ==" + couponValid.getOrder());
			System.out.println("=======Cart couponValid.getOrder().getCartCouponCode() ==" + couponValid.getOrder().getCartCouponCode() + couponValid.getCouponResult());

			//카트 쿠폰 검증
			Cart cartCouponValid = couponService.cartCouponValid(order, couponList);
			System.out.println("=======Cart cartCouponValid ==" + cartCouponValid.getCouponResult());
			System.out.println("=======Cart cartCouponValid.getOrder() ==" + cartCouponValid.getOrder());
			System.out.println("=======Cart cartCouponValid.getOrder().getCartCouponCode() ==" + cartCouponValid.getOrder().getCartCouponCode() + cartCouponValid.getCouponResult());

			//딜 쿠폰 검증
			Cart dealCouponValid = couponService.dealCouponValid(order, couponList);
			System.out.println("=======Cart dealCouponValid ==" + dealCouponValid.getCouponResult());
			System.out.println("=======Cart dealCouponValid.getOrder() ==" + dealCouponValid.getOrder());
			System.out.println("=======Cart dealCouponValid.getOrder().getCartCouponCode() ==" + dealCouponValid.getOrder().getCartCouponCode() + dealCouponValid.getCouponResult());


			if(null != order.getCartCouponCode() && !"0".equals(order.getCartCouponCode())) {
				if(couponValid.getCouponResult() == true && cartCouponValid.getCouponResult() == true) {
					Screen screen = new Screen();
					screen.printOrder(order);
				} else if(couponValid.getCouponResult() == false) {
					System.out.println(cartCouponValid.getOrder().getCartCouponCode() + " 쿠폰이 중복 사용 되었습니다.");
				} else if(cartCouponValid.getCouponResult() == false) {
					System.out.println(cartCouponValid.getOrder() + " 쿠폰 사용이 불가능 합니다. 1");
				}
			} else if(dealCouponValid.getCouponResult() == true) {
				Screen screen = new Screen();
				screen.printOrder(order);
			} else if(dealCouponValid.getCouponResult() == false) {
				System.out.println(dealCouponValid.getOrder().getCartCouponCode() + "쿠폰  사용이 불가능 합니다. 2 ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}



	/**
	 int totalDealAmount; //딜가격 * 수량 금액
	 int cartAmount; //카트의 총금액
	 int dealDiscountAmount; //딜의 할인 금액
	 int cartDiscountAmount; //카트의 할인 금액
	 int totalAmount; //딜,카트 할인 후 실제 결제할 금액
	 *
	 * @param order
	 */
	public void orderAmountSet(Order order, List<Deal> dealList, List<Coupon> couponList) {
		List<OrderDeal> orderDealList = order.getOrderDealList();
		//딜가격 * 수량 : orderDeal속성
		for(OrderDeal orderDeal : orderDealList) {
			System.out.println("딜코드 " + orderDeal.getDealCode());
			for(Deal deal : dealList) {
				if(orderDeal.getDealCode().equals(deal.getDealCode())) {
					orderDeal.setDealAmount(deal.getPrice());
					System.out.println("===딜 deal.getPrice() " +deal.getDealCode()+ " : "+ deal.getPrice());
				}
			}
			orderDeal.setTotalDealAmount(orderDeal.getDealAmount() * orderDeal.getDealCount());
			System.out.println("상품금액 getDealAmount " + orderDeal.getDealAmount());
			System.out.println("상품금액 getTotalDealAmount " + orderDeal.getTotalDealAmount());
		}


		//카트의 총금액 set cartAmount
		for(OrderDeal orderDeal : orderDealList) {
			order.setCartAmount(order.getCartAmount() + orderDeal.getTotalDealAmount());
		}
		System.out.println("카트 getCartAmount " + order.getCartAmount());
	}


}
