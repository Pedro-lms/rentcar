package com.geral.rent.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_usuario") // Retira a confusão com o nome do SQL de user
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // Aqui declara-se o objeto id, como o principal objeto relacional ao banco de
		// dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identificando a chave primária
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String cpf;

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	public User() {
	}

	public User(Long id, String name, String email, String phone, String cpf) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getcpf() {
		return cpf;
	}

	public void setcpf(String cpf) {

		this.cpf = cpf;
	}
	
	 public static boolean iscpf(String cpf) {
	        // considera-se erro cpf's formados por uma sequencia de numeros iguais
	        if (cpf.equals("00000000000") ||
	            cpf.equals("11111111111") ||
	            cpf.equals("22222222222") || cpf.equals("33333333333") ||
	            cpf.equals("44444444444") || cpf.equals("55555555555") ||
	            cpf.equals("66666666666") || cpf.equals("77777777777") ||
	            cpf.equals("88888888888") || cpf.equals("99999999999") ||
	            (cpf.length() != 11))
	            return(false);

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	        try {
	        // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	        // converte o i-esimo caractere do cpf em um numero:
	        // por exemplo, transforma o caractere '0' no inteiro 0
	        // (48 eh a posicao de '0' na tabela ASCII)
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

	        // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);

	        // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
	                 return(true);
	            else return(false);
	                } catch (InputMismatchException erro) {
	                return(false);
	            }
	        }

	        public static String imprimecpf(String cpf) {
	            return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
	            cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
	        }
		
	public List<Order> getOrders() {
		return orders;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
