package kz.iitu.liquor.eshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

    @JsonProperty("id")
    @ApiModelProperty(required = true, example = "1", name = "Order id")
    private Long id;

    @JsonProperty("reference_no")
    @ApiModelProperty(example = "1", name = "reference_no")
    private int reference_no;

    @JsonProperty("customerId")
    @ApiModelProperty(example = "1", name = "customer_id")
    private Long customerId;

    @JsonProperty("cartId")
    @ApiModelProperty(name = "cart id")
    private List<Long> cartId;

    @JsonProperty("orderDate")
    @ApiModelProperty(example = "12-12-2020", name = "Order date")
    private Date orderDate;

    @JsonProperty("expectedDeliveryDate")
    @ApiModelProperty(example = "12-12-2020", name = "Expected delivery date")
    private Date expectedDeliveryDate;

    @JsonProperty("numberOfItems")
    @ApiModelProperty(example = "10", name = "Number of items")
    private int numberOfItems;

    @JsonProperty("totalAmount")
    @ApiModelProperty(example = "10", name = "Total amount")
    private int totalAmount;

    @JsonProperty("orderDetailDTO")
    private OrderDetailDTO orderDetailDTO;
}
