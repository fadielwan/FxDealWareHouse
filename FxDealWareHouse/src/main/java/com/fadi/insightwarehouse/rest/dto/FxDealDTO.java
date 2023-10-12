package com.fadi.insightwarehouse.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class FxDealDTO {
	@NotNull(message = "The id is required.")

	private Long id;

	@Pattern(regexp = "^[A-Z]{3}$", message = "Invalid from currency ISO code. Please provide a valid 3-letter ISO currency code.")

	private String fromCurrencyISOCode;

	@Pattern(regexp = "^[A-Z]{3}$", message = "Invalid to currency ISO code. Please provide a valid 3-letter ISO currency code.")

	private String toCurrencyISOCode;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dealTimestamp;
	@NotNull(message = "The dealAmount is required.")

	private BigDecimal dealAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCurrencyISOCode() {
		return fromCurrencyISOCode;
	}

	public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
		this.fromCurrencyISOCode = fromCurrencyISOCode;
	}

	public String getToCurrencyISOCode() {
		return toCurrencyISOCode;
	}

	public void setToCurrencyISOCode(String toCurrencyISOCode) {
		this.toCurrencyISOCode = toCurrencyISOCode;
	}

	public LocalDateTime getDealTimestamp() {
		return dealTimestamp;
	}

	public void setDealTimestamp(LocalDateTime dealTimestamp) {
		this.dealTimestamp = dealTimestamp;
	}

	public BigDecimal getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(BigDecimal dealAmount) {
		this.dealAmount = dealAmount;
	}

}
