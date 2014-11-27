package com.auto.library;


public class SubtitleViewHelper {
    private AnimationSetupCallback callback;
    private String subtitle;
    private long index = 0;
    private boolean isShining;

    public void setAnimationSetupCallback(AnimationSetupCallback callback) {
        this.callback = callback;
    }

    public interface AnimationSetupCallback {
        void endAnimation();
    }

    public void setShine(boolean isShining) {
        this.isShining = isShining;
        if (!isShining) {
            index = 0;
        }
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String toggle() {
        if (isShining) {
            index++;
            if (subtitle.length() >= index) {
                return subtitle.substring(0, (int) index);
            } else {
                if (callback != null) {
                    callback.endAnimation();
                }
                return subtitle;
            }
        }
        return null;
    }
}
