package main;

/**
 * Created by sjshin on 2016-04-13.
 */
public enum MessageCode {
	CODE_100(100, "메뉴를 숫자로 입력하세요. \n 주문 1  \n 장바구니 2 "),
	CODE_101(101, "장바구니ID 숫자 6자리, 사용자 ID(alphanumberic 4~12자리), 장바구니쿠폰코드, 상품코드|수량|상품쿠폰코드 입력하세요. "
			+ "\n 입력값예시: 123456,tmon,C3,H|1|C2"),
//	CODE_102(102, String.format("장바구니 아이디는 : %s," + "입니다"))
	CODE_103(103, "장바구니 아이디를 입력해 주세요.(숫자6자리)")
	;

	private int code;
	private String message;

	MessageCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
