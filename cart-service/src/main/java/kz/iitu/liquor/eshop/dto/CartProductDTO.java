package kz.app.cart.shopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartProductDTO {

    @JsonProperty("id")
    @ApiModelProperty(required = true, example = "1", name = "Cart product id")
    Long id;

    @JsonProperty("code")
    @ApiModelProperty(example = "DHN", name = "Code product")
    private String code;

    @JsonProperty("name")
    @ApiModelProperty(required = true, example = "T-shift", name = "Name of product")
    private String name;

    @JsonProperty("detail")
    @ApiModelProperty(example = "good", name = "detail product")
    private String detail;

}
