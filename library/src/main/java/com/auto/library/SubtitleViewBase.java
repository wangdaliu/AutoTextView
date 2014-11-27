package com.auto.library;

public interface SubtitleViewBase {
    public void setAnimationSetupCallback(SubtitleViewHelper.AnimationSetupCallback callback);

    public void setShine(boolean isShining);

    public void setSubtitle(String subtitle);

    public void toggle();
}
