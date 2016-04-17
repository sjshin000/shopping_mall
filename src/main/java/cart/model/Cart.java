package cart.model;

import coupon.model.Coupon;
import order.model.Order;

/**
 * Created by sjshin on 2016-04-13.
 * 장바구니 id를 입력 시 전체 상품목록이 노출
 * 상품은 판매금액과 쿠폰적용 후 할인금액과 적용된 쿠폰명이 노출되어야 한다.
 * 만약 유효하지 않은 쿠폰의 경우 경고 메시지를 노출
 * 전체 상품에 대한 총합산 금액과 실제 총할인 금액이 노출(상품별로 적용된 쿠폰 할인금액 + 장바구니 전체에 적용된 쿠폰할인 금액)
 */
public class Cart {
	String cartId;  //숫자 6자리

	Order order;
	Boolean couponResult = false;
	Coupon coupon;

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Boolean getCouponResult() {
		return couponResult;
	}

	public void setCouponResult(Boolean couponResult) {
		this.couponResult = couponResult;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
}
