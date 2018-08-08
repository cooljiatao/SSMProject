package me.jiatao.ssm.mybatis.C_Relationship;


import me.jiatao.ssm.mybatis.Order;

public interface OrderMapper {

	public Order queryOrderAndUserLazy(String orderNumber);
	
	/**
	 * 查询订单信息，并且查询出下单人的信息 , 根据订单id查询
	 * select * from tb_order o LEFT JOIN tb_user u ON u.id = o.user_id where o.order_number = '20140921001';
	 */
	public Order queryOrderAndUserByOrderNumber(String orderNumber);
	
	/**
	 * 查询订单，查询出下单人信息并且查询出订单详情
	 */
	public Order queryOrderAndUserAndDetailByOrderNumber(String orderNumber);
	/**
	 * 查询订单，查询出下单人信息并且查询出订单详情中的商品数据。
	 * @param orderNumber
	 * @return
	 */
	public Order queryOrderAndUserAndDetailAndItemByOrderNumber(String orderNumber);
}
