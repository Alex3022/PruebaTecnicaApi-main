package co.com.projectBase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseGetAll {
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private List<ResponseDataId> data;
    @JsonProperty("message")
    private String message;
}
