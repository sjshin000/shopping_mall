package coupon.model;

/**
 * Created by sjshin on 2016-04-13.
 */
public class Coupon {
	//코드, 쿠폰명, 할인금액, 사용조건 - deal, 적용수량(1개/5~10) / 일정금액이상적용가능,
	//enum  COUPONTYPE{DEAL, CART}  //상품/카트 COUPONTYPE
	//enum  DISCOUNTType{RATE, AMOUNT}  //적율/정액

	String couponType;
	String discountType;
	String code;
	String couponName;
	int discountAmount;
	int rate;

	String targetDeal;
	int targetAmount;
	int targetCountMin;  //1대만 적용가능, 5~10 가능, null 인경우
	int targetCountMax; //

	int couponCount; // 적용가능한 쿠폰의 수

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getTargetDeal() {
		return targetDeal;
	}

	public void setTargetDeal(String targetDeal) {
		this.targetDeal = targetDeal;
	}

	public int getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}

	public int getTargetCountMin() {
		return targetCountMin;
	}

	public void setTargetCountMin(int targetCountMin) {
		this.targetCountMin = targetCountMin;
	}

	public int getTargetCountMax() {
		return targetCountMax;
	}

	public void setTargetCountMax(int targetCountMax) {
		this.targetCountMax = targetCountMax;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}
