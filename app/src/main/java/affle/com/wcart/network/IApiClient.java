package affle.com.wcart.network;

import affle.com.wcart.models.request.ReqAddToCart;
import affle.com.wcart.models.request.ReqAddUserAddress;
import affle.com.wcart.models.request.ReqBase;
import affle.com.wcart.models.request.ReqCancelOrder;
import affle.com.wcart.models.request.ReqCancellationDetails;
import affle.com.wcart.models.request.ReqCashbackHistory;
import affle.com.wcart.models.request.ReqChangePassword;
import affle.com.wcart.models.request.ReqConnectDisconnectApps;
import affle.com.wcart.models.request.ReqContests;
import affle.com.wcart.models.request.ReqCoupons;
import affle.com.wcart.models.request.ReqCouponsDetail;
import affle.com.wcart.models.request.ReqCouponsList;
import affle.com.wcart.models.request.ReqDeleteAllNotification;
import affle.com.wcart.models.request.ReqDeleteUserAddresses;
import affle.com.wcart.models.request.ReqDeliveryStatus;
import affle.com.wcart.models.request.ReqFavouriteCoupons;
import affle.com.wcart.models.request.ReqFavouriteProducts;
import affle.com.wcart.models.request.ReqFitbitToken;
import affle.com.wcart.models.request.ReqForgotPassword;
import affle.com.wcart.models.request.ReqFsPoints;
import affle.com.wcart.models.request.ReqFsStore;
import affle.com.wcart.models.request.ReqFsStoreProductsList;
import affle.com.wcart.models.request.ReqGetContestDetails;
import affle.com.wcart.models.request.ReqGetFilters;
import affle.com.wcart.models.request.ReqGetOrderDetail;
import affle.com.wcart.models.request.ReqGetPushNotification;
import affle.com.wcart.models.request.ReqGetUserDetails;
import affle.com.wcart.models.request.ReqGetUserPointsByTime;
import affle.com.wcart.models.request.ReqJoinChallenge;
import affle.com.wcart.models.request.ReqLeaveChallenge;
import affle.com.wcart.models.request.ReqLogin;
import affle.com.wcart.models.request.ReqMyCart;
import affle.com.wcart.models.request.ReqMyOrders;
import affle.com.wcart.models.request.ReqMyWallet;
import affle.com.wcart.models.request.ReqPlaceOrder;
import affle.com.wcart.models.request.ReqPrizeMoneyDetails;
import affle.com.wcart.models.request.ReqProceed;
import affle.com.wcart.models.request.ReqProductDetail;
import affle.com.wcart.models.request.ReqProductsCategory;
import affle.com.wcart.models.request.ReqProductsList;
import affle.com.wcart.models.request.ReqRedeemPointsAffiliate;
import affle.com.wcart.models.request.ReqRemoveCart;
import affle.com.wcart.models.request.ReqRepeatOrder;
import affle.com.wcart.models.request.ReqRunkeeperToken;
import affle.com.wcart.models.request.ReqSendToBank;
import affle.com.wcart.models.request.ReqSetFavouriteCoupon;
import affle.com.wcart.models.request.ReqSetFavouriteProduct;
import affle.com.wcart.models.request.ReqShareAndInvite;
import affle.com.wcart.models.request.ReqSignUp;
import affle.com.wcart.models.request.ReqTrendingCoupons;
import affle.com.wcart.models.request.ReqTrendingProducts;
import affle.com.wcart.models.request.ReqUnFavouriteCoupon;
import affle.com.wcart.models.request.ReqUnFavouriteProduct;
import affle.com.wcart.models.request.ReqUpdateCart;
import affle.com.wcart.models.request.ReqUserCalorieDistance;
import affle.com.wcart.models.request.ReqWalletHistory;
import affle.com.wcart.models.response.ResAddUserAddress;
import affle.com.wcart.models.response.ResBase;
import affle.com.wcart.models.response.ResCancellationDetails;
import affle.com.wcart.models.response.ResCashBackHistory;
import affle.com.wcart.models.response.ResContactUs;
import affle.com.wcart.models.response.ResCouponsDetail;
import affle.com.wcart.models.response.ResDeliveryStatus;
import affle.com.wcart.models.response.ResForgotPassword;
import affle.com.wcart.models.response.ResFsStore;
import affle.com.wcart.models.response.ResFsStoreProductsList;
import affle.com.wcart.models.response.ResGetContestDetails;
import affle.com.wcart.models.response.ResGetContests;
import affle.com.wcart.models.response.ResGetCouponData;
import affle.com.wcart.models.response.ResGetCouponList;
import affle.com.wcart.models.response.ResGetFavouriteCoupons;
import affle.com.wcart.models.response.ResGetFavouriteProducts;
import affle.com.wcart.models.response.ResGetFilters;
import affle.com.wcart.models.response.ResGetFsPoints;
import affle.com.wcart.models.response.ResGetOrderDetail;
import affle.com.wcart.models.response.ResGetProductDetail;
import affle.com.wcart.models.response.ResGetProductsCategories;
import affle.com.wcart.models.response.ResGetProductsList;
import affle.com.wcart.models.response.ResGetTrendingCoupons;
import affle.com.wcart.models.response.ResGetTrendingProducts;
import affle.com.wcart.models.response.ResGetUserAddresses;
import affle.com.wcart.models.response.ResGetUserDetails;
import affle.com.wcart.models.response.ResGetUserPointsByTime;
import affle.com.wcart.models.response.ResLeaveContest;
import affle.com.wcart.models.response.ResLoginSignUpSocial;
import affle.com.wcart.models.response.ResMyCart;
import affle.com.wcart.models.response.ResMyOrders;
import affle.com.wcart.models.response.ResMyWallet;
import affle.com.wcart.models.response.ResPlaceOrder;
import affle.com.wcart.models.response.ResPrizeMoneyDetails;
import affle.com.wcart.models.response.ResPushNotification;
import affle.com.wcart.models.response.ResRunkeeperData;
import affle.com.wcart.models.response.ResShareAndInvite;
import affle.com.wcart.models.response.ResSignUp;
import affle.com.wcart.models.response.ResUpdateProfile;
import affle.com.wcart.models.response.ResUserCalorieDistance;
import affle.com.wcart.models.response.ResWalletHistoryPaid;
import affle.com.wcart.models.response.ResWalletHistoryReceived;
import affle.com.wcart.ui.fragments.ResGetAllProductsDatas;
import affle.com.wcart.utils.Banners;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by root on 6/14/16.
 */
public interface IApiClient {

    @POST("indexm")
    Call<ResSignUp> signup(@Body ReqSignUp reqSignUp);

    @POST("indexm")
    Call<ResLoginSignUpSocial> signupFb(@Body ReqSignUp reqSignUp);

    @POST("indexm")
    Call<ResLoginSignUpSocial> login(@Body ReqLogin reqLogin);

    @POST("indexm")
    Call<ResForgotPassword> forgotPassword(@Body ReqForgotPassword reqForgotPassword);

    @POST("indexm")
    Call<ResGetUserDetails> getUserDetails(@Body ReqGetUserDetails reqGetUserDetails);

    @POST("indexm")
    Call<ResAddUserAddress> addUserAddress(@Body ReqAddUserAddress reqAddUserAddress);

    @POST("indexm")
    Call<ResBase> changePassword(@Body ReqChangePassword reqChangePassword);

    @POST("indexm")
    Call<ResGetCouponData> getCoupons(@Body ReqCoupons reqCoupons);

    @POST("indexm")
    Call<ResGetFavouriteProducts> getFavouriteProducts(@Body ReqFavouriteProducts reqFavouriteProducts);

    @POST("indexm")
    Call<ResGetUserAddresses> getUserAddresses(@Body ReqGetUserDetails reqAddress);

    @POST("indexm")
    Call<ResBase> deleteUserAddresses(@Body ReqDeleteUserAddresses reqDeleteUserAddresses);

    @POST("indexm")
    Call<ResGetFavouriteCoupons> getFavouriteCoupons(@Body ReqFavouriteCoupons reqFavouriteCoupons);

    @POST("indexm")
    Call<ResBase> setFavouriteCoupon(@Body ReqSetFavouriteCoupon reqSetFavouriteCoupon);

    @POST("indexm")
    Call<ResBase> setFavouriteProduct(@Body ReqSetFavouriteProduct reqSetFavouriteProduct);

    @POST("indexm")
    Call<ResBase> unFavouriteCoupon(@Body ReqUnFavouriteCoupon reqUnFavouriteCoupon);

    @POST("indexm")
    Call<ResBase> unFavouriteProduct(@Body ReqUnFavouriteProduct reqUnFavouriteProduct);

    @POST("indexm")
    Call<ResGetCouponList> getCouponsList(@Body ReqCouponsList reqCoupons);

    @POST("indexm")
    Call<ResGetProductsCategories> getProductsCategory(@Body ReqProductsCategory reqProductsCategory);

    @POST("indexm")
    Call<ResGetAllProductsDatas> getAllProductsData(@Body ReqProductsCategory reqProductsCategory);

    //new one banners

    @FormUrlEncoded
    @POST("indexm")
    Call<Banners> getBanners(@Field("userID") String userID,
                             @Field("method") String method,
                             @Field("service_key") String service_key,
                             @Field("search") String search,
                             @Field("page") String page);


/*    @FormUrlEncoded
    @POST("indexm")
    Call<Products> getAllProCat(@Field("userID") String userID,
                                @Field("method") String method,
                                @Field("service_key") String service_key,
                                @Field("search") String search,
                                @Field("page") String page);*/

    @POST("indexm")
    Call<ResGetTrendingProducts> getTrendingProducts(@Body ReqTrendingProducts reqTrendingProducts);

    @POST("indexm")
    Call<ResGetTrendingProducts> banner(@Body ReqTrendingProducts reqTrendingProducts);

    @POST("indexm")
    Call<ResGetTrendingCoupons> getTrendingCoupons(@Body ReqTrendingCoupons reqTrendingCoupons);

    @POST("indexm")
    Call<ResGetProductsList> getProductsList(@Body ReqProductsList reqProductsList);

    @POST("indexm")
    Call<ResGetProductDetail> getProductDetail(@Body ReqProductDetail reqProductDetail);

    @POST("indexm")
    Call<ResGetFilters> getFilters(@Body ReqGetFilters reqGetFilters);

    @POST("indexm")
    Call<ResCouponsDetail> getCouponDetail(@Body ReqCouponsDetail ReqCouponsDetail);

    @POST("indexm")
    Call<ResShareAndInvite> shareAndInvite(@Body ReqShareAndInvite reqShareAndInvite);

    @POST("indexm")
    Call<ResGetContests> getContests(@Body ReqContests reqContests);

    @POST("indexm")
    Call<ResGetContests> joinChallenge(@Body ReqJoinChallenge reqJoinChallenge);

    @POST("indexm")
    Call<ResLeaveContest> joinChallengeFromDetail(@Body ReqJoinChallenge reqJoinChallenge);

    @POST("indexm")
    Call<ResLeaveContest> leaveChallenge(@Body ReqLeaveChallenge reqLeaveChallenge);

    @POST("indexm")
    Call<ResGetContestDetails> getContestDetails(@Body ReqGetContestDetails reqGetContestDetails);

    @POST("indexm")
    Call<ResFsStoreProductsList> getFsStoreProductsList(@Body ReqFsStoreProductsList reqFsStoreProductsList);

    @POST("indexm")
    Call<ResFsStore> getFsStore(@Body ReqFsStore reqFsStore);

    @POST("indexm")
    Call<ResGetFsPoints> getFsStorePoints(@Body ReqFsPoints reqFsPoints);

    @POST("indexm")
    Call<ResUserCalorieDistance> getUserCalorieDistance(@Body ReqUserCalorieDistance reqUserCalorieDistance);

    @POST("indexm")
    Call<ResDeliveryStatus> getDeliveryStatus(@Body ReqDeliveryStatus reqDeliveryStatus);

    @POST("indexm")
    Call<ResMyCart> getCartDetails(@Body ReqMyCart reqMyCart);

    @POST("indexm")
    Call<ResBase> removeCart(@Body ReqRemoveCart reqRemoveCart);

    @POST("indexm")
    Call<ResBase> addCart(@Body ReqAddToCart reqAddToCart);

    @POST("indexm")
    Call<ResPlaceOrder> placeOrder(@Body ReqPlaceOrder reqPlaceOrder);

    @POST("indexm")
    Call<ResMyOrders> getMyOrders(@Body ReqMyOrders reqMyOrders);

    @POST("indexm")
    Call<ResGetOrderDetail> getOrderDetail(@Body ReqGetOrderDetail reqGetOrderDetail);

    @POST("indexm")
    Call<ResBase> cancelOrder(@Body ReqCancelOrder reqCancelOrder);

    @POST("indexm")
    Call<ResBase> proceedOrder(@Body ReqProceed reqProceed);

    @POST("indexm")
    Call<ResBase> repeatOrder(@Body ReqRepeatOrder reqRepeatOrder);

    @POST("indexm")
    Call<ResContactUs> conatctUs(@Body ReqBase reqBase);

    @POST("indexm")
    Call<ResMyWallet> myWallet(@Body ReqMyWallet reqMyWallet);

    @POST("indexm")
    Call<ResBase> sendToBank(@Body ReqSendToBank reqSendToBank);

    @POST("indexm")
    Call<ResWalletHistoryReceived> getWalletHistoryReceived(@Body ReqWalletHistory reqWalletHistory);

    @POST("indexm")
    Call<ResWalletHistoryPaid> getWalletHistoryPaid(@Body ReqWalletHistory reqWalletHistory);

    @POST("indexm")
    Call<ResCashBackHistory> getCashbackHistory(@Body ReqCashbackHistory reqCashbackHistory);

    @POST("indexm")
    Call<ResCancellationDetails> getCancellationDetails(@Body ReqCancellationDetails reqCancellationDetails);

    @POST("indexm")
    Call<ResPrizeMoneyDetails> getPrizeMoneyDetails(@Body ReqPrizeMoneyDetails reqPrizeMoneyDetails);

    @POST("indexm")
    Call<ResRunkeeperData> getRunkeeperData(@Body ReqRunkeeperToken reqRunkeeperToken);

    @POST("indexm")
    Call<ResRunkeeperData> getFitbitData(@Body ReqFitbitToken reqFitbitToken);

    @POST("indexm")
    Call<ResPushNotification> getPushNotification(@Body ReqGetPushNotification reqGetPushNotification);

    @POST("indexm")
    Call<ResGetUserPointsByTime> getUserPointsByTime(@Body ReqGetUserPointsByTime reqGetUserPointsByTime);

    @POST("indexm")
    Call<ResBase> deleteAllNotification(@Body ReqDeleteAllNotification reqDeleteAllNotification);

    @POST("indexm")
    Call<ResBase> connectDisconnectApp(@Body ReqConnectDisconnectApps reqConnectDisconnectApps);

    @POST("indexm")
    Call<ResBase> redeemPointsAffiliate(@Body ReqRedeemPointsAffiliate reqRedeemPointsAffiliate);

    @POST("indexm")
    Call<ResBase> updateCartDetails(@Body ReqUpdateCart reqUpdateCart);

    @Multipart
    @POST("indexm")
    Call<ResUpdateProfile> updateProfile(@Part("method") RequestBody method,
                                         @Part("service_key") RequestBody serviceKey,
                                         @Part("userID") RequestBody userID,
                                         @Part("name") RequestBody name,
                                         @Part("phone") RequestBody phone,
                                         @Part("dob") RequestBody dob,
                                         @Part("locationName") RequestBody locationName,
                                         @Part("height") RequestBody height,
                                         @Part("weight") RequestBody weight,
                                         @Part MultipartBody.Part image);

    @Multipart
    @POST("indexm")
    Call<ResUpdateProfile> updateProfileWithoutImage(@Part("method") RequestBody method,
                                                     @Part("service_key") RequestBody serviceKey,
                                                     @Part("userID") RequestBody userID,
                                                     @Part("name") RequestBody name,
                                                     @Part("phone") RequestBody phone,
                                                     @Part("dob") RequestBody dob,
                                                     @Part("locationName") RequestBody locationName,
                                                     @Part("height") RequestBody height,
                                                     @Part("weight") RequestBody weight,
                                                     @Part("image") RequestBody image);

    @Multipart
    @POST("indexm")
    Call<ResUpdateProfile> updateSettings(@Part("method") RequestBody method,
                                          @Part("service_key") RequestBody serviceKey,
                                          @Part("userID") RequestBody userID,
                                          @Part("unit") RequestBody unit,
                                          @Part("notification") RequestBody notification,
                                          @Part("resetImage") RequestBody resetImage,
                                          @Part MultipartBody.Part homeScreen);

    @Multipart
    @POST("indexm")
    Call<ResUpdateProfile> updateSettingsWithoutImage(@Part("method") RequestBody method,
                                                      @Part("service_key") RequestBody serviceKey,
                                                      @Part("userID") RequestBody userID,
                                                      @Part("unit") RequestBody unit,
                                                      @Part("notification") RequestBody notification,
                                                      @Part("resetImage") RequestBody resetImage,
                                                      @Part("homeScreen") RequestBody homeScreen);

    @POST("indexm")
    Call<ResBase> setFavouriteCouponDetail(@Body ReqCouponsDetail reqCouponsDetail);

    @GET("http://api.runkeeper.com/records")
    Call<ResponseBody> getTotalDistance(@Header("Authorization") String authorization,
                                        @Header("Accept") String accept);

    @POST("https://runkeeper.com/apps/token")
    Call<ResponseBody> getAccessToken(@Query("grant_type") String grantKey,
                                      @Query("code") String code,
                                      @Query("client_id") String clientId,
                                      @Query("client_secret") String clientSecret,
                                      @Query("redirect_uri") String redirectUri);
}
