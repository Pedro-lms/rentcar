package com.geral.rent.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String brand;
	private Double pricePerDay;
	private Instant PickedDay;
	private Instant RecivedDay;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_carro_categoria", joinColumns = @JoinColumn(name = "id_dos_carros"), inverseJoinColumns = @JoinColumn(name = "categories"))
	private Set<Category> categories = new HashSet<>();
	
	public Product() {
	}

		public Product(Long id, String name, String brand, Double pricePerDay, Instant pickedDay, Instant recivedDay,
			String imgUrl) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.pricePerDay = pricePerDay;
		PickedDay = pickedDay;
		RecivedDay = recivedDay;
		this.imgUrl = imgUrl;
	
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return brand;
	}

	public void setDescription(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return pricePerDay;
	}

	public void setPrice(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Instant getPickedDay() {
		return PickedDay;
	}

	public void setPickedDay(Instant pickedDay) {
		PickedDay = pickedDay;
	}

	public Instant getRecivedDay() {
		return RecivedDay;
	}

	public void setRecivedDay(Instant recivedDay) {
		RecivedDay = recivedDay;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pricePerDay == null) ? 0 : pricePerDay.hashCode());
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
		Product other = (Product) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pricePerDay == null) {
			if (other.pricePerDay != null)
				return false;
		} else if (!pricePerDay.equals(other.pricePerDay))
			return false;
		return true;
	}

}
