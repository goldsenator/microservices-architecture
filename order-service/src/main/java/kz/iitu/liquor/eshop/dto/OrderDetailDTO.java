package kz.iitu.liquor.eshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailDTO {

    @JsonProperty("id")
    @ApiModelProperty(required = true, example = "1", name = "Order detail id")
    private Long id;

    @JsonProperty("reference")
    @ApiModelProperty(example = "1", name = "reference_no")
    private int referenceNo;

    @JsonProperty("orderId")
    @ApiModelProperty(example = "1", name = "Order id")
    private Long orderId;

    @JsonProperty("productId")
    @ApiModelProperty(example = "1", name = "Card product id")
    private Long productId;

    @JsonProperty("quantity")
    @ApiModelProperty(example = "10", name = "Quantity")
    private int quantity;

    @JsonProperty("quantityPrice")
    @ApiModelProperty(example = "10", name = "Quantity price")
    private int quantityPrice;

    @JsonProperty("status")
    @ApiModelProperty(example = "EXAMPLE", name = "Status")
    private String status;

    @JsonProperty("remarks")
    @ApiModelProperty(example = "EXAMPLE", name = "Remarks")
    private String remarks;

    @JsonProperty("vendorId")
    @ApiModelProperty(example = "1", name = "Vendor id")
    private Long vendorId;


}
