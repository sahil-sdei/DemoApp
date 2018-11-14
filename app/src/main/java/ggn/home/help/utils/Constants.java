package ggn.home.help.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Constants
{
    @interface Extras
    {
        String DATA                     = "data";
        String TRANSITION_NAME_1        = "name";
        String TRANSITION_NAME_2        = "name2";
        String CROP_TYPE                = "crop_type";
        String SEARCH_DATA              = "search_data";
        String CROP_ID                  = "crop_id";
        String TITLE                    = "title";
        String USER_ID                  = "user_id";
        String IS_ADD_CROP              = "is_add_crop";
        String BID_ID                   = "bid_id";
        String IS_SESSION_EXPIRED       = "is_session_expired";
        String QUALITY_DATA             = "quality_data";
        String IS_UPDATE_BID            = "is_update_bid";
        String IS_ADD                   = "is_add";
        String IS_BILLING               = "is_billing";
        String POSITION                 = "position";
        String DISTANCE                 = "distance";
        String DELIVERY_PREFERENCE      = "delivery_preference";
        String ORDER_CODE               = "order_code";
        String ORDER_ID                 = "order_id";
        String ORDER_TYPE               = "order_type";
        String PAYMENT_TYPE             = "payment_type";
        String DATA_CART                = "data_cart";
        String MONEY_TYPE               = "money_type";
        String TAB                      = "tab";
    }

    @interface RequestCode
    {
        int SIGN_IN                      = 101;
        int SIGN_UP                      = 102;
        int FILTER_SEARCH                = 103;
        int SEARCH_CROP                  = 104;
        int PICK_GIF                     = 105;
        int EDIT_PROFILE                 = 106;
        int NOTIIFCATIONS                = 107;
        int PLACE_BID                    = 108;
        int NO_CONNECTION                = 109;
        int POP                          = 110;
        int UPDATE_BILLING_ADDRESS       = 111;
        int UPDATE_SHIPPING_ADDRESS      = 112;
        int ADD_ADDRESS                  = 113;

    }

    @interface Keys
    {
        int CROP_FEATURED                      = 1;
        int CROP_BEST_SELLING                  = 2;
        int CROP_MOST_VIEWED                   = 3;
        int ACTIVE                             = 4;
        int DELIVERED                          = 5;
        int FAILED                             = 6;
        int EXPIRED                            = 7;
        int MONEY_BIDS                         = 8;
        int MONEY_ORDERS                       = 9;
    }
}
