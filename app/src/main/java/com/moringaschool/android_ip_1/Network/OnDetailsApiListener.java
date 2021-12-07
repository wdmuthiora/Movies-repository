package com.moringaschool.android_ip_1.Network;

import com.moringaschool.android_ip_1.Models.FilmEndPoint.DetailApiResponse;

public interface OnDetailsApiListener {

    void onResponse(DetailApiResponse response);

    void onError(String message);

}
