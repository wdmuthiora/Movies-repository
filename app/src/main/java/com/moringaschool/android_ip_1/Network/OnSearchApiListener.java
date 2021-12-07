package com.moringaschool.android_ip_1.Network;

import com.moringaschool.android_ip_1.Models.SearchEndPoint.SearchApiResponse;

public interface OnSearchApiListener {

    void onResponse(SearchApiResponse response);
    void onError(String message);

}
