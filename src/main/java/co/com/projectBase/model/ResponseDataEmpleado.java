package co.com.projectBase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDataEmpleado {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("message")
    private String message;
}
