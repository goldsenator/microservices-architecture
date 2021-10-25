package kz.iitu.liquor.eshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    @JsonProperty("id")
    @ApiModelProperty(example = "1", name = "Customer id")
    private Long id;

    @JsonProperty("customerCode")
    @ApiModelProperty(example = "1", name = "Customer code")
    private String customerCode;

    @JsonProperty("customerName")
    @ApiModelProperty(required = true, example = "Adilet", name = "Customer name")
    private String customerName;

    @JsonProperty("photo")
    @ApiModelProperty(example = "Adilet", name = "Customer name")
    private byte[] avatar;

    @JsonProperty("emailAddress")
    @ApiModelProperty(required = true, example = "customer@icloud.com", name = "Customer email")
    private String emailAddress;

    @JsonProperty("contacting")
    @ApiModelProperty(example = "87005200051", name = "Customer contact number")
    private String contactNumber;

    @JsonProperty("completeAddress")
    @ApiModelProperty(example = "Astana", name = "Customer address")
    private String completeAddress;

    @JsonProperty("password")
    @ApiModelProperty(required = true, example = "password", name = "Customer password")
    private String password;

}