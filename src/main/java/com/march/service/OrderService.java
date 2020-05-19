package com.march.service;

import com.march.common.annotation.DataBase;
import com.march.common.enums.DataBaseType;
import com.march.domain.Order;
import com.march.domain.User;
import com.march.mapper.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * /**
 *
 * @description: TODO
 * @see: OrderService
 * @createTime: 2020/5/19 1:50
 * @version:1.0
 */
@Service
@DataBase(DataBaseType.SECOND)
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public void insert(Order order) {
        orderDAO.insert(order);
    }

    public Order selectOrderById(int id){
        return orderDAO.selectByPrimaryKey(id);
    }

}
