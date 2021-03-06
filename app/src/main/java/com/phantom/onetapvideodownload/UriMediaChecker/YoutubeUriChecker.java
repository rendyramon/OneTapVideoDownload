package com.phantom.onetapvideodownload.UriMediaChecker;

import android.content.Context;
import android.net.Uri;

import com.phantom.onetapvideodownload.Video.Video;
import com.phantom.onetapvideodownload.Video.YoutubeVideo;

public class YoutubeUriChecker implements AbstractUriChecker {
    private Context mContext;

    public YoutubeUriChecker(Context context) {
        mContext = context;
    }
    @Override
    public Video checkUrl(String url) {
        if (!url.contains("youtube.com/watch")) {
            return null;
        }

        try {
            Uri uri = Uri.parse(url);
            String videoId = uri.getQueryParameter("v");
            if (videoId == null) {
                return null;
            }
            return new YoutubeVideo(mContext, "", videoId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
