package com.zenithbankgroup.paymentgateway.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 4:11 PM
 * @project paymentgateway
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppResponse <T> implements Serializable {
    private T data;
    private String message;
    private int status;
    private Object error;

}
