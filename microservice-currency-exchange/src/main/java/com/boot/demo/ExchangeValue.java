package com.boot.demo;

public class ExchangeValue {

	private Long id;
	private Currencies from;
	private Currencies to;
	private Integer exchangeValue;

	public ExchangeValue() {

	}

	public ExchangeValue(Long id, Currencies from, Currencies to, Integer exchangeValue) {

		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeValue = exchangeValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Currencies getFrom() {
		return from;
	}

	public void setFrom(Currencies from) {
		this.from = from;
	}

	public Currencies getTo() {
		return to;
	}

	public void setTo(Currencies to) {
		this.to = to;
	}

	public Integer getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(Integer exchangeValue) {
		this.exchangeValue = exchangeValue;
	}

}
