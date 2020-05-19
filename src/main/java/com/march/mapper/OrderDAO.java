/* https://github.com/orange1438 */
package com.march.mapper;

import com.march.common.annotation.DataBase;
import com.march.common.enums.DataBaseType;
import com.march.domain.Order;
import com.march.domain.OrderCriteria;
import org.springframework.stereotype.Repository;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438
 * date:2020/05/19 01:15
 */
@Repository

public interface OrderDAO extends IMapper<Order, OrderCriteria, Integer> {
}