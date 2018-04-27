package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 网络请求地址库
 * 作者： jl
 *
 */

public interface UrlConstants {

 // String BASE_URL = "http://116.62.204.235:8080/";

 String BASE_URL = "http://192.168.50.194:8080/";//测试路径

 String REGIST = "wg/a/api/ans/login/userRegister";//请求方法名(注册)

 String VERIFY="wg/a/api/ans/login/verifyCodeGet";//请求方法名(获取验证码)

 String LOGIN = "userinfoApi/userLogin";

 String LIST="wg/a/api/ans/refund/refundApplyList";//测试（listce测试）

}
