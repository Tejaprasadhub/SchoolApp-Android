package com.cts.presenters;

import com.cts.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter extends BasePresenter {
    private ApiCallBack apiCallBack;
    private ApiClient apiClient;

    public UserPresenter(ApiCallBack apiCallBack) {
        this.apiCallBack = apiCallBack;
        apiClient = new ApiClient();
    }

//    public void apiSignIn(LoginRequestModel signInPost, final int type) {
//        apiClient.getClient().postSignIn(signInPost).enqueue(new Callback<BaseResponse>() {
//            @Override
//            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//                apiCallBack.onSuccessResponse(response, type);
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse> call, Throwable t) {
//                apiCallBack.onErrorResponse(t.getLocalizedMessage(), type);
//            }
//        });
//    }


}
