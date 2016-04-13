package order.repository;

import order.model.Order;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by sjshin on 2016-04-14.
 */
@Repository
public class OrderRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insert(Order order) {
		System.out.println("insert");
		int cnt = sqlSession.insert("order.insert", order);
		System.out.println("insert2");
		return cnt;
	}

	public void select(Order order) {
		sqlSession.insert("order.select", order);
	}

}
