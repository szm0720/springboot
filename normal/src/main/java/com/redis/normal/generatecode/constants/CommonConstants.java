package com.redis.normal.generatecode.constants;

/**
 * @Author:
 * @Date: 2018/4/28 16:19
 * @Description:
 */
public class CommonConstants {
    public final static String RESOURCE_TYPE_MENU = "menu";
    public final static String RESOURCE_TYPE_BTN = "button";

    public final static String TOKEN_HEADER = "Authorization";

    public final static String TOKEN = "token";

    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40101;
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40301;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;

    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";

    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
    public static final String JWT_KEY_PHONE = "phone";
    public static final String JWT_KEY_ROLE = "role";
    public static final String JWT_KEY_OPENID = "openId";
    public static final String JWT_KEY_TYPE = "type";//type 表示当前token 的类型：APP，Applets，BSS TokenTypeEnum

    public static final String JWT_KEY_USERNAME = "username";
    public static final String JWT_KEY_PASSWORD = "password";
    public static final String JWT_KEY_PERMISSION = "permission";

    public static final String REDIS_PHONE_VERIFY_PREFIX = "CORE:VERIFY:PHONE:";
    public static final String REDIS_USER_PHONE_PREFIX = "CORE:DATA:USER:PHONE:";
    public static final String REDIS_USER_OPENID_PREFIX = "CORE:DATA:USER:OPENID:";

    public static final Integer DELETE_FLAG_FALSE_ZERO = 0;
    public static final Integer DELETE_FLAG_TRUE_ONE = 1;

    //开通城市字典type
    public static final String DICT_TYPE_ONLINE_CITY = "online_city";

    //user 工程中的用户同步到redis中的前缀
    public static final String REDIS_USERAPPLICATION_PREFIX = "CACHE:USER:";

}
