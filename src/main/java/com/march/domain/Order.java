/* https://github.com/orange1438 */
package com.march.domain;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2020/05/19 01:15
 */
public class Order implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 8676247075365554232L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private String orderNo;

    /** 
     */ 
    private String userId;

    /** 
     * 获取 test_order.id
     * @return test_order.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 test_order.id
     * @param id test_order.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 test_order.order_no
     * @return test_order.order_no
     */
    public final String getOrderNo() {
        return orderNo;
    }

    /** 
     * 设置 test_order.order_no
     * @param orderNo test_order.order_no
     */
    public final void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /** 
     * 获取 test_order.user_id
     * @return test_order.user_id
     */
    public final String getUserId() {
        return userId;
    }

    /** 
     * 设置 test_order.user_id
     * @param userId test_order.user_id
     */
    public final void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}