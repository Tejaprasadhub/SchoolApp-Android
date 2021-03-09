package com.cts.network;

public class ApiConstants {

    static String CONSUMER_KEY = "ConsumerKey";
    static String CONSUMER_SECRER = "ConsumerSecret";
    static String CONTENT_TYPE = "Content-Type";

    //Stage Creds
  /*  static String BASE_URL = "http://webapibusyeetickets.i2space.co.in/";
    static String CONSUMER_KEY_VALUE = "9C727A510886A9913F85A72EB8BA8DCE2F9C32FC";
    static String CONSUMER_SECRER_VALUE = "FF546758EE1C73BD4550A3E3F5DDE9C6EEB99FA7";*/
    //Prod Creds
    static String BASE_URL = "https://pro.thefarmerplace.com/api/";
    static String CONSUMER_KEY_VALUE = "5F434281387440B93A70DA565C49542CD6F9579A";
    static String CONSUMER_SECRER_VALUE = "FF546758EE1C73BD4550A3E3F5DDE9C6EEB99FA7";


    //check if it is client or agent
   /* static int id = DataHelper.getUserLoginResponse(BaseApplication.getmContext()).getUserType();
    public static String LOGIN_URL = id == 6 ? EndPoints.ENDPOINT_SIGN_IN : AgentEndPoints.ENDPOINT_AGENT_LOGIN;
    public static String DETAILS_URL = id == 6 ? EndPoints.ENDPOINT_CLIENT_DETAILS : AgentEndPoints.ENDPOINT_AGENT_DETAILS;*/

    static String CONTENT_TYPE_VALUE = "application/json";

    public class EndPoints {

        static final String ENDPOINT_SIGN_IN = "login";
        static final String ENDPOINT_ADD_CROP = "crop";
        static final String ENDPOINT_GET_CROPS = "get/crop";
        static final String ENDPOINT_GET_LANGUAGES = "languages";
        static final String ENDPOINT_TRANSLATED_DATA = "language/translate";


    }

    public static class Constants {
        public static final int API_USER_SIGNIN = 101;
        public static final int API_VALIDATE_OTP = 102;
        public static final int API_ADD_CROP = 103;
        public static final int API_GET_CROPS = 104;
        public static final int API_GET_LANGUAGES = 105;
        public static final int API_TRANSLATED_DATA = 106;
        public static final int API_GENERATE_OTP = 107;
        public static final int API_UPDATE_CROP_STATUS = 108;

    }
}
