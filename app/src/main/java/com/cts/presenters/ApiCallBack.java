package com.cts.presenters;

import retrofit2.Response;

public interface ApiCallBack {
    void onSuccessResponse(Response response, int requestType);

    void onErrorResponse(String message, int requestType);
}