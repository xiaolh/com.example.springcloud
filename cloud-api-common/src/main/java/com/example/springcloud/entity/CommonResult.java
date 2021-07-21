package com.example.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther xiaolh
 * @create 2021-7-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {

    private String code;

    private String message;

    private Object data;

    public static CommonResult fail(String code,String message){
        return new CommonResult(code,message,null);
    };

    public static CommonResult success(Object data){
        return new CommonResult("200","SUCCESS",data);
    }

}
