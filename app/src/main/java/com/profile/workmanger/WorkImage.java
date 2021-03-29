package com.profile.workmanger;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class WorkImage extends Worker {
    public WorkImage(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
MediaPlayer mediaPlayer;
    @NonNull
    @Override
    public Result doWork() {
        uploaddata();
        return Result.success();
    }
    public void uploaddata(){

    }
}
