package order.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sjshin on 2016-04-13.
 */
public class Order implements Serializable {
	//입력값: 장바구니ID 숫자 6자리, 사용자 ID(alphanumberic 4~12자리), 장바구니쿠폰코드, 상품코드|수량|상품쿠폰코드

	int cartId;
	String userId;
	String cartCouponCode;

	List<OrderDeal> orderDealList;


	int cartAmount; //카트의 총금액
	int cartDiscountAmount; //카트의 할인 금액
	int totalAmount; //딜,카트 할인 후 실제 결제할 금액


	public int getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}


	public int getCartDiscountAmount() {
		return cartDiscountAmount;
	}

	public void setCartDiscountAmount(int cartDiscountAmount) {
		this.cartDiscountAmount = cartDiscountAmount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderDeal> getOrderDealList() {
		return orderDealList;
	}

	public void setOrderDealList(List<OrderDeal> orderDealList) {
		this.orderDealList = orderDealList;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCartCouponCode() {
		return cartCouponCode;
	}

	public void setCartCouponCode(String cartCouponCode) {
		this.cartCouponCode = cartCouponCode;
	}


}
