package com.rent.entities.enums;

public enum OrderStatus {

	AGUARDANDO_SER_PAGO(1),
	PAGO(2),
	PAGO_COM_ATRASO(3),
	ALUGADO(4),
	ALUGADO_COM_ATRASO(5),
	DEVOLVIDO(6),
	DEVOLVIDO_COM_ATRASO(7);

	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}			
		}
		throw new IllegalArgumentException("Código invalido para o Status do pedido");
	}
}
