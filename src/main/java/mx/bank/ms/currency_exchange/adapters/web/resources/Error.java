package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Error
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Error   {
  @JsonProperty("statusCode")
  private String statusCode = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("message")
  private String message = null;
}
