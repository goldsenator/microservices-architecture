package kz.iitu.liquor.eshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartDTO {

    @JsonProperty("id")
    @ApiModelProperty(required = true, example = "1", name = "Cart id")
    private Long id;

    @JsonProperty("description")
    @ApiModelProperty(example = "Cart product Description", name = "Cart description")
    private String description;

    @JsonProperty("status")
    @ApiModelProperty(example = "SOLD", name = "Cart status")
    private String status;

    @JsonProperty("images")
    private byte[] images;

}
