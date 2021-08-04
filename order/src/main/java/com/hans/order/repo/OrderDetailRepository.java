package com.hans.order.repo;

import com.hans.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hans
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
