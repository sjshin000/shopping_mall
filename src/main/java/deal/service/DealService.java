package deal.service;

import deal.model.Deal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjshin on 2016-04-14.
 */
public class DealService {

	public List<Deal> addDeal() {
		List<Deal> dealList = new ArrayList<Deal>();

		Deal dealH = new Deal();
		dealH.setDealCode("H");
		dealH.setPrice(900000);
		dealH.setDealName("고급 게이밍 PC");
		dealH.setDescription("고사양 고급 PC");
		dealList.add(dealH);

		Deal dealM = new Deal();
		dealM.setDealCode("M");
		dealM.setPrice(550000);
		dealM.setDealName("중급 게이밍 PC");
		dealM.setDescription("가격대 성능비 좋은 PC");
		dealList.add(dealM);

		Deal dealL = new Deal();
		dealL.setDealCode("L");
		dealL.setPrice(300000);
		dealL.setDealName("알뜰 PC");
		dealL.setDescription("최소 구동환경 제공");
		dealList.add(dealL);
		return dealList;
	}
}
