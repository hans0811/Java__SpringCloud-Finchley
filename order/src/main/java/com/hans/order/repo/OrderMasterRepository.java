package com.hans.order.repo;

import com.hans.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hans
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
