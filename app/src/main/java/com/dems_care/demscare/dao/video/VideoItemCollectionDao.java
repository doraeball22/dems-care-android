package com.dems_care.demscare.dao.video;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bon on 18/9/2560.
 */

public class VideoItemCollectionDao {

    @SerializedName("success")
    private boolean success;
    @SerializedName("videos")
    private List<VideoItemDao> videos;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<VideoItemDao> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoItemDao> videos) {
        this.videos = videos;
    }
}
