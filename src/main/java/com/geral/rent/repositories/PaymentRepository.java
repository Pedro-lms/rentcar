package com.geral.rent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.rent.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
