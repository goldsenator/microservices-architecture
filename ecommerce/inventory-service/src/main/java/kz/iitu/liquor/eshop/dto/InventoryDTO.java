package kz.app.cart.shopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryDTO {

    @JsonProperty("productCode")
    @ApiModelProperty(required = true, example = "1", name = "productCode")
    private String productCode;

    @JsonProperty("quantity")
    @ApiModelProperty(example = "Product quantity", name = "quantity")
    private String quantity;

}
