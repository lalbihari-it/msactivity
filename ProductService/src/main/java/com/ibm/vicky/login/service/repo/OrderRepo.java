/**
 * 
 */
package com.ibm.vicky.login.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo  extends JpaRepository<OrderData, String> {

	OrderData findByTransactionToken(String txnToken);


}
