package com.hans.product.utils;

import com.hans.product.VO.ResultVO;

/**
 * @author hans
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");

        return resultVO;
    }
}
