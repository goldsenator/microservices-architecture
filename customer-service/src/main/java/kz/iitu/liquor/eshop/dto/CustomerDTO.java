package kz.app.cart.shopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @ApiModelProperty(required = true, example = "Assel", name = "Customer name")
    private String customerName;

    @JsonProperty("avatar")
    @ApiModelProperty(example = "Assel", name = "Customer name")
    private byte[] avatar;

    @JsonProperty("emailAddress")
    @ApiModelProperty(required = true, example = "aselek.m.s@gmail.com", name = "Customer email")
    private String emailAddress;

    @JsonProperty("contactNumber")
    @ApiModelProperty(example = "+77072001521", name = "Customer contact number")
    private String contactNumber;

    @JsonProperty("completeAddress")
    @ApiModelProperty(example = "Almaty, Manas 66", name = "Customer address")
    private String completeAddress;

    @JsonProperty("username")
    @ApiModelProperty(required = true, example = "AsselSultan", name = "Customer username")
    private String username;

    @JsonProperty("password")
    @ApiModelProperty(required = true, example = "hello", name = "Customer password")
    private String password;

}
