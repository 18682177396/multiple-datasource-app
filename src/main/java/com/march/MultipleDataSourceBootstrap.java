package com.march;

import com.march.common.annotation.EnableMultipartsDataSource;
import com.march.domain.Order;
import com.march.domain.User;
import com.march.service.OrderService;
import com.march.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

/**
 *@description: 多數據源配置
 *@see: MultipleDataSourceBootstrap
 *@createTime: 2020/5/19 0:08
 *@version:1.0
 */
@SpringBootApplication
@MapperScan("com.march")
@EnableMultipartsDataSource
public class MultipleDataSourceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(MultipleDataSourceBootstrap.class)
                .web(WebApplicationType.NONE).run(args);

        OrderService orderServe = context.getBean(OrderService.class);

        Order order = new Order();
        order.setOrderNo(UUID.randomUUID().toString().replaceAll("-",""));
        order.setUserId(UUID.randomUUID().toString().replaceAll("-",""));
        orderServe.insert(order);

        Order order1 = orderServe.selectOrderById(order.getId());
        System.out.println("order1.getOrderNo() = " + order1.getOrderNo());

        Thread thread = new Thread(()->{
            User user = new User();
            user.setAge(15);
            user.setName("test");
            UserService userService = context.getBean(UserService.class);
            userService.insert(user);

            User user1 = userService.selectUserById(user.getId());
            System.out.println("user1.getName() = " + user1.getName());
        });
        thread.start();
    }

}
