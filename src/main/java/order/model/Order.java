package order.model;

/**
 * Created by sjshin on 2016-04-13.
 */
public class Order {
	//입력값: 장바구니ID 숫자 6자리, 사용자 ID(alphanumberic 4~12자리), 장바구니쿠폰코드, 상품코드|수량|상품쿠폰코드

	int cartId;
	String usserId;
	String cartCouponCode;

	String dealCode;
	int dealCount;
	String dealCouponCode;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUsserId() {
		return usserId;
	}

	public void setUsserId(String usserId) {
		this.usserId = usserId;
	}

	public String getCartCouponCode() {
		return cartCouponCode;
	}

	public void setCartCouponCode(String cartCouponCode) {
		this.cartCouponCode = cartCouponCode;
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
}
