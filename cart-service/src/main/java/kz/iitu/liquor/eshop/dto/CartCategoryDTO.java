package kz.iitu.liquor.eshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartCategoryDTO {

    @JsonProperty("id")
    @ApiModelProperty(required = true, example = "1", name = "Cart category id")
    Long id;

    @JsonProperty("categoryName")
    @ApiModelProperty(required = true, example = "2", name = "Cart category name")
    private String categoryName;

}

