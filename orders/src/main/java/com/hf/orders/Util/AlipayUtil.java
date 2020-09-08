package com.hf.orders.Util;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.hf.orders.Domain.AlipayBean;

public class AlipayUtil {
    //支付宝网关
    private static final String serverUrl = "https://openapi.alipaydev.com/gateway.do";
    //商户私钥
    private static final String appId = "2016093000628983";
    //返回格式
    private static final String format = "json";
    //字符编码格式
    private static final String charset = "utf-8";
    //签名方式
    private static final String signType = "RSA2";
    //应用公钥
    private static final String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRiXvsaxF0miuaFH9gyKTyGycLg8gi7V3tXqvWSDUkLzf6VcXkIUpzzkpX483j86tOmExbgc0k1wO6edJgLts3IUIKTxojYUb+g44L75C6yAW01j5wZLPlhPyR/ruoH/9SJ+GD5K8SQB4MAojDNI0Efvg2WyboziwFUQgDlAII1E++FbHMN5zRTqQEDJr9LvVanOcZm9ftHO9QV3J0hbPxneMyTtcrVuz+DkWkcNNHkIaAoauge8Tex34suvwKhxdp6nQqGhHpteXeYnkQhW7KYbMZ1BjpbsVQgJrFsnjrHqv0BiZkbH9mJSb7LOisM1T8bBpT5eAYpllyB7qzUVNBAgMBAAECggEAV/hgndFCJdciz+nf7OKbQXTELyOjD+mmwtpcyBOxe4PHNFwwV+r/k+x355RdWZJqVAGe9hkJpWEKcec9EMKB41sJDi4uQICGZ0Wh0Pkn5J8PQ/XUnB9i1jOCb8UoLUHaFRDiMdVDNaboAp5tiID1VGhjJIgIhuRIm5YVYARRDoBIwSA4wUxlQpSTizj6GUTeja/LH+zTQ09ZTkd+l/B5xd6zpLeCN/KR+7HssVkpR8muPwoHJOdS1XuwI+q2YDNeBoXjYDgIilr4NlW+kpaVINfDiWKRhQYF9gjw615sPhUDIooI9Lx2bdVmkQ+AtAKBb2mFq4eSiVsqGwCJetnSoQKBgQDtCgm72wW3WgIrs9GG74oHpLHz2GjeJi8eyJTvm/EqltDHUoDmKWGjHvnkUfDJN4YSTOKYGkvnRlde06yaNFUxr1qQ5Crhz1r5p3DCqZkLyWs2WW1CTNR1BUaU+Z528r48Lf+B3OdRC6KP99gc2uXzX+sTv7XhF7pXqNDqhvFlnQKBgQCdLba5Ed/E4GC1k/CmNFj4mkGyGlxTvsT+i3N71OB4nWzSpYGqpiLFZ3mNacdNWwYcaaqkHrVn0fZpqucnW/5JmUtcjt9TCTUMsu5se8AlsU1QKrGnWUFII1J7pI8AewmdBqELcafF5N7RcVVGoadn1COFcO8JOJcyy6PKlLUk9QKBgDnJbbAPaChX2BmhX94+fW75lqx0wLQPqQMfMTfs03FnjQRat7PkuLnUrmUcGNBlKdlCRyd/mauLOXeTsQty4KYZMsIJ7e5Y57vfNx0tzXLTKsD4MiusoUrZ+2gMJram3Pu81wJowTe/12SzrkryjoazhpKs9QEoELSYIj5aoXT9AoGBAIDyrgNq/I/CHNUax8UzEQLzWo5JPhGeYnMJ6PZgkL+jN1IhYh2kKsaUu44eh9mYoYzRy6LVZrID+Qp7oSQTPq0WzFLlC6ZN2W3PpfbuF5dUvD7Wp+TJPtt1zweM25zjU+G1PI3s8l1SBNMDDZjiqjpuOa4SFqkT+kc79eYO1gW5AoGAEQy7J82KYFKuc+TXok/SDvHJVykQLnV7bK1HEVUVQ2t9O6g1YcoL8kopIgrneihsdsms/2QazfZoY1C2VeLXru5eKJw/VlYnPYvUH1hp8snJeFE4Ka5Fi4wSUgwY8huvOYWf5znRVEmSvm4QScLgGhXb1Wf5qKz/B6HFmWDQFEg=";
    //支付宝公钥
    private static final String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAowhJubQd/1Tgb5vpuFL8KgK/C8/4RqtTN7k2gxkxvatTBWB+2z/E4QUqXI5pOyIg/6glgBSQhJBiTpMo6YrD3gcM7VqB0z8Pw+jf8h2xRKwEsjKs5ukl/towZHjfqukmv6eZ0SWLX/cG26F+9lhpLBrxZhay1Iel/cwOZHnK284vAUFH4t+iWmHtF26JXXBwTFXnzJAvrsHlJSKgpa20LsJcP34jQMbbcVPF/z2ySaOSp4iqK2bw2J1Lc3YiY/JG/6gbR2zK0qx/qb7KRMoBnU4TABX+htEvO3xjaAEWvVoeecoTqZggEIBbY6qgYZuVo7TRTYJJt0+0wtg275lbFQIDAQAB";
    //同步通知页面路径
    private static final String notifyUrl = "http://localhost:8080/Cashier";
    //异步通知页面路径
    private static final String returnUrl = "http://localhost:8080/ordersDetails/save";

    private static final String productCode = "FAST_INSTANT_TRADE_PAY";

    public static String alipay(AlipayBean alipayBean) throws AlipayApiException{
        //1、获得初始化的AlipayClient
        AlipayClient alipayClient =
                new DefaultAlipayClient(serverUrl,appId,privateKey,format,charset,alipayPublicKey, signType);
        alipayBean.setProduct_code(productCode);
        //2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
// 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
//封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
//3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }



}
