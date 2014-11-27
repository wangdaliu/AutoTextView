package com.auto.library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;

public class Subtitle {
    private ValueAnimator animator;
    private long interval;
    private String text;

    public Subtitle(long interval, String text) {
        this.interval = interval;
        this.text = text;
    }

    public boolean isAnimating() {
        return animator != null && animator.isRunning();
    }

    public <V extends View & SubtitleViewBase> void start(final V subtitleView) {

        if (isAnimating()) {
            return;
        }

        final Runnable animate = new Runnable() {
            @Override
            public void run() {
                subtitleView.setShine(true);
                subtitleView.setSubtitle(text);
                animator = ValueAnimator.ofFloat(0.0f, 2.0f);
                animator.setDuration(interval);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        subtitleView.setShine(false);
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                            subtitleView.postInvalidate();
                        } else {
                            subtitleView.postInvalidateOnAnimation();
                        }

                        animator = null;
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        subtitleView.toggle();
                    }
                });
                animator.start();
            }
        };
        subtitleView.setAnimationSetupCallback(new SubtitleViewHelper.AnimationSetupCallback() {
            @Override
            public void endAnimation() {
                cancel();
            }
        });
        animate.run();
    }

    public void cancel() {
        if (animator != null) {
            animator.cancel();
        }
    }
}
