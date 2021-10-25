package kz.iitu.liquor.eshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartProductCategoryDTO {

    @JsonProperty("id")
    @ApiModelProperty(required = true, example = "1", name = "Cart product category id")
    Long id;

    @JsonProperty("categoryName")
    @ApiModelProperty(example = "1", name = "Cart product category name")
    private String categoryName;
}
