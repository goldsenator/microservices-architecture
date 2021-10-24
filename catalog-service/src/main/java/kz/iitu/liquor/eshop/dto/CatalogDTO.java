package kz.iitu.liquor.eshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogDTO {

    @JsonProperty("id")
    @ApiModelProperty(example = "1", name = "Customer id")
    private Long id;

    @JsonProperty("catalogCode")
    @ApiModelProperty(example = "1", name = "catalogCode")
    private String customerCode;

    @JsonProperty("customerName")
    @ApiModelProperty(required = true, example = "clients", name = "Customer name")
    private String customerName;

}
