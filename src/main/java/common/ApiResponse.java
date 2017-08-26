/**
 * Copyright (c) 2017, TP-Link Co.,Ltd.
 * Author:  jiangdanyang <jiangdanyang@tp-link.com.cn>
 * Created: 2017-08-24
 */
package common;

import java.util.Objects;

import org.json.JSONObject;

public class ApiResponse {
    private int statusCode;
    JSONObject response;

    public ApiResponse(int statusCode, JSONObject response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiResponse that = (ApiResponse)o;
        return statusCode == that.statusCode && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, response);
    }
}
