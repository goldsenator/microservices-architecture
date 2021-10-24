package kz.iitu.liquor.eshop.dto;

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
    @ApiModelProperty(required = true, example = "5", name = "5")
    Long id;

    @JsonProperty("code")
    @ApiModelProperty(example = "444", name = "444")
    private String code;

    @JsonProperty("name")
    @ApiModelProperty(required = true, example = "222", name = "222")
    private String name;

    @JsonProperty("detail")
    @ApiModelProperty(example = "111", name = "111")
    private String detail;

}
