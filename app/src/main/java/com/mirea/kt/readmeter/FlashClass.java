package com.mirea.kt.readmeter;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class FlashClass  {
    private boolean flash_status = false;
    public Context context;

    public FlashClass(Context context) {
        this.context = context;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void flashOn(){
        CameraManager cameraManager  = (CameraManager ) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flash_status = true;

        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }


    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void flashOff (){
        CameraManager cameraManager  = (CameraManager ) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false );
            flash_status = false;

        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isFlash_status() {
        return flash_status;
    }
}
