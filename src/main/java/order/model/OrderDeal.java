package order.model;

import java.io.Serializable;

/**
 * Created by sjshin on 2016-04-17.
 */
public class OrderDeal implements Serializable {
	int cartId;
	String dealCode;
	int dealCount;
	String dealCouponCode;

	int dealAmount;  //딜 상품금액

	int totalDealAmount; //딜가격 * 수량 금액
	int dealDiscountAmount;  //할인금액

	public int getTotalDealAmount() {
		return totalDealAmount;
	}

	public void setTotalDealAmount(int totalDealAmount) {
		this.totalDealAmount = totalDealAmount;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getDealCode() {
		return dealCode;
	}

	public void setDealCode(String dealCode) {
		this.dealCode = dealCode;
	}

	public int getDealCount() {
		return dealCount;
	}

	public void setDealCount(int dealCount) {
		this.dealCount = dealCount;
	}

	public String getDealCouponCode() {
		return dealCouponCode;
	}

	public void setDealCouponCode(String dealCouponCode) {
		this.dealCouponCode = dealCouponCode;
	}

	public int getDealDiscountAmount() {
		return dealDiscountAmount;
	}

	public void setDealDiscountAmount(int dealDiscountAmount) {
		this.dealDiscountAmount = dealDiscountAmount;
	}

	public int getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(int dealAmount) {
		this.dealAmount = dealAmount;
	}
}
