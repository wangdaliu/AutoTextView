package com.auto.library;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class SubtitleTextView extends TextView implements SubtitleViewBase {

    private SubtitleViewHelper mSubtitleViewHelper;

    public SubtitleTextView(Context context) {
        super(context);
        mSubtitleViewHelper = new SubtitleViewHelper();
    }

    public SubtitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSubtitleViewHelper = new SubtitleViewHelper();
    }

    public SubtitleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mSubtitleViewHelper = new SubtitleViewHelper();
    }


    @Override
    public void setAnimationSetupCallback(SubtitleViewHelper.AnimationSetupCallback callback) {
        mSubtitleViewHelper.setAnimationSetupCallback(callback);
    }

    @Override
    public void setShine(boolean isShining) {
        mSubtitleViewHelper.setShine(isShining);
    }

    @Override
    public void setSubtitle(String subtitle) {
        mSubtitleViewHelper.setSubtitle(subtitle);
    }

    @Override
    public void toggle() {
        setText(mSubtitleViewHelper.toggle());
    }

}
