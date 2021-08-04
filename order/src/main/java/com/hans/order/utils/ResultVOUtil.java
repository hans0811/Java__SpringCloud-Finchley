package com.hans.order.utils;

import com.hans.order.VO.ResultVO;

/**
 * @author hans
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("SUCCESS");
        resultVO.setData(object);
        return resultVO;
    }
}
