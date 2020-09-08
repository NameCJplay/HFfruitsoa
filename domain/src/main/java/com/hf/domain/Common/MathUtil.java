package com.hf.domain.Common;

public class MathUtil {

    public static Double KeepThreePoint(double result){
        return (double)Math.round(result*1000)/1000;
    }

}
