package com.phantom.onetapvideodownload;

import android.net.Uri;

public class Url {
    private String mUrl, mMetadata;

    public Url(String url, String metadata) {
        this.mUrl= url;
        this.mMetadata = metadata;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getMetadata() {
        return mMetadata;
    }

    public String getFilename() {
        Uri uri = Uri.parse(mUrl);
        return uri.getLastPathSegment();
    }

    @Override
    public boolean equals(Object urlObj) {
        if (urlObj == null) {
            return false;
        }

        Url otherUrl = (Url) urlObj;
        if (mUrl.equals(otherUrl.getUrl()) && mMetadata.equals(otherUrl.getMetadata())) {
            return true;
        }
        return false;
    }

}