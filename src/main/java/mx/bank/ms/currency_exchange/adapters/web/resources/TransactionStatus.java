package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Estado actual de la transacción. Posibles valores: INITIATED, EXECUTED, CANCELLED, FAILED, etc.
 */
public enum TransactionStatus {
  INITIATED("INITIATED"),
  PENDING("PENDING"),
  EXECUTED("EXECUTED"),
  CANCELLED("CANCELLED"),
  FAILED("FAILED");

  private final String value;

  TransactionStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TransactionStatus fromValue(String text) {
    for (TransactionStatus b : TransactionStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
