package com.fadi.insightwarehouse.rest.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "fx_deals")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FXDeal {

	@Id
	private Long id;
	@Column(name = "from_currency_iso_code")
	private String fromCurrencyISOCode;
	@Column(name = "to_currency_iso_code")
	private String toCurrencyISOCode;
	@Column(name = "time_stamp")
	private LocalDateTime dealTimestamp;
	@Column(name = "amount")
	private BigDecimal dealAmount;

	

}
