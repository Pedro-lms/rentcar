package com.geral.rent.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pagamento")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private Double dayPrice;
	private Integer days;
	private Integer overDays;
	private Double ticketPenalty;

	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;

	public Payment() {
	}

	public Payment(Long id, Instant moment, Double dayPrice, Integer days, Integer overDays, Double ticketPenalty) {
		this.id = id;
		this.moment = moment;
		this.dayPrice = dayPrice;
		this.days = days;
		this.overDays = overDays;
		this.ticketPenalty = ticketPenalty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Double getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	public Integer getOverDays() {
		return overDays;
	}

	public void setOverDays(Integer overDays) {
		this.overDays = overDays;
	}

	public Double getTicketPenalty() {
		return overDays * dayPrice;
	}

	public Double getTotal() {
		return dayPrice * days + ticketPenalty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
