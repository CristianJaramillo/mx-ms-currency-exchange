package mx.bank.ms.currency_exchange.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "currency_exchange")
@AllArgsConstructor
@Builder
public class CurrencyExchangeTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String status;

    @Column(name = "original_amount", precision = 19, scale = 4, nullable = false)
    private BigDecimal originalAmount;

    @Column(name = "source_currency", length = 3, nullable = false)
    private String sourceCurrency;

    @Column(name = "target_currency", length = 3, nullable = false)
    private String targetCurrency;

    @Column(name = "buy_amount", precision = 19, scale = 4)
    private BigDecimal buyAmount;

    @Column(name = "buy_currency", length = 3)
    private String buyCurrency;

    @Column(name = "sell_amount", precision = 19, scale = 4)
    private BigDecimal sellAmount;

    @Column(name = "sell_currency", length = 3)
    private String sellCurrency;

    @Column(name = "resulting_amount", precision = 19, scale = 4)
    private BigDecimal resultingAmount;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public CurrencyExchangeTransactionEntity() {
    }

}