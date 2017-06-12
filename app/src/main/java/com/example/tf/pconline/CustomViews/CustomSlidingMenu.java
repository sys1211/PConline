package com.example.tf.pconline.CustomViews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by joker on 2017/6/10.
 */

public class CustomSlidingMenu extends SlidingMenu {
    public CustomSlidingMenu(Context context) {
        super(context);
    }

    public CustomSlidingMenu(Activity activity, int slideStyle) {
        super(activity, slideStyle);
    }

    public CustomSlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSlidingMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private final String Tag = "slidingMenu";
    private View mSlidingView;
    private View mDetailView;
    private RelativeLayout bgShade;
    private int screenWidth;
    private int screenHeight;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;
    private int mTouchSlop;
    private float mLastMotionX;
    private float mLastMotionY;
    private static final int VELOCITY = 50;
    private boolean mIsBeingDragged = true;
    private boolean tCanSlideRight = false;
    private boolean hasClickRight = false;



    private void init(Context context) {

        bgShade = new RelativeLayout(context);
        mScroller = new Scroller(getContext());
        // 获得能够进行手势滑动的距离
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        WindowManager windowManager = ((Activity) context).getWindow()
                .getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();
        LayoutParams bgParams = new LayoutParams(screenWidth, screenHeight);
        bgParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        bgShade.setLayoutParams(bgParams);

    }




    public void addViews(View center, View right) {
        setRightView(right);
        setCenterView(center);
    }

    public void setRightView(View view) {
        LayoutParams behindParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.FILL_PARENT);
        behindParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        addView(view, behindParams);
        mDetailView = view;
        mDetailView.bringToFront();// 确保rightview置顶
        ViewTreeObserver vto = mDetailView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {// 调用layout或调用visibility时调用此方法

            @Override
            public void onGlobalLayout() {// 设置后rightview是叠加在centerview上面，所以需要先将rightview移动到右侧不可见区域
                mDetailView.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                Log.i(Tag, "width:" + mDetailView.getWidth());
                mDetailView.scrollTo(-mDetailView.getWidth(),
                        mDetailView.getScrollY());
            }
        });

    }

    public void setCenterView(View view) {
        LayoutParams aboveParams = new LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT);

        LayoutParams bgParams = new LayoutParams(screenWidth, screenHeight);
        bgParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        addView(bgShade, bgParams);
        addView(view, aboveParams);
        mSlidingView = view;
        // mSlidingView.bringToFront();
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        postInvalidate();
    }

    @Override
    public void computeScroll() {
        if (!mScroller.isFinished()) {
            if (mScroller.computeScrollOffset()) {
                int oldX = mDetailView.getScrollX();
                int oldY = mDetailView.getScrollY();
                int x = mScroller.getCurrX();
                int y = mScroller.getCurrY();
                if (oldX != x || oldY != y) {
                    if (mDetailView != null) {
                        mDetailView.scrollTo(x, y);
                        if (x < 0)
                            bgShade.scrollTo(x + 20, y);// 背景阴影右偏
                        else
                            bgShade.scrollTo(x - 20, y);// 背景阴影左偏
                    }
                }
                invalidate();
            }
        }
    }

    private boolean canSlideRight = true;

    // 设置是否可手动滑动
    public void setCanSliding(boolean right) {
        canSlideRight = right;
    }

    /* 拦截touch事件 */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        final int action = ev.getAction();
        final float x = ev.getX();
        final float y = ev.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionX = x;
                mLastMotionY = y;
                mIsBeingDragged = false;
                if (canSlideRight) {
                    mDetailView.setVisibility(View.VISIBLE);
                }
                break;

            case MotionEvent.ACTION_MOVE:
                final float dx = x - mLastMotionX;
                final float xDiff = Math.abs(dx);
                final float yDiff = Math.abs(y - mLastMotionY);
                if (xDiff > mTouchSlop && xDiff > yDiff) {
                    if (canSlideRight) {
                        float oldScrollX = mDetailView.getScrollX();
                        if (oldScrollX < 0) {
                            mIsBeingDragged = true;
                            mLastMotionX = x;
                        } else {
                            if (dx > 0) {
                                mIsBeingDragged = true;
                                mLastMotionX = x;
                            }
                        }
                    }

                }
                break;

        }
        return mIsBeingDragged;
    }

    /* 处理拦截后的touch事件 */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);

        final int action = ev.getAction();
        final float x = ev.getX();
        final float y = ev.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                mLastMotionX = x;
                mLastMotionY = y;

                // if (mDetailView.getScrollX() == getDetailViewWidth()
                // && mLastMotionX < getMenuViewWidth()) {
                // return false;
                // }

                break;
            case MotionEvent.ACTION_MOVE:
                if (mIsBeingDragged) {
                    final float deltaX = mLastMotionX - x;
                    mLastMotionX = x;
                    float oldScrollX = mDetailView.getScrollX();
                    float scrollX = oldScrollX + deltaX;
                    if (canSlideRight) {// 此控件为右侧的menu，活动区域应该是在初始位置右侧，也就是scroll值只能是小于等于0
                        if (scrollX > 0)
                            scrollX = 0;
                    }
                    if (deltaX < 0 && oldScrollX < 0) { // scrollX的范围值
                        final float rightBound = -getDetailViewWidth();
                        final float leftBound = 0;
                        if (scrollX > leftBound) {
                            scrollX = leftBound;
                        } else if (scrollX < rightBound) {
                            scrollX = rightBound;
                        }
                    }
                    if (mDetailView != null) {// 随手势滚动view
                        mDetailView.scrollTo((int) scrollX,
                                mDetailView.getScrollY());
                        if (scrollX < 0)
                            bgShade.scrollTo((int) scrollX + 20,
                                    mSlidingView.getScrollY());
                        else
                            bgShade.scrollTo((int) scrollX - 20,
                                    mSlidingView.getScrollY());
                    }

                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (mIsBeingDragged) {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(100);
                    float xVelocity = velocityTracker.getXVelocity();// 滑动的速度
                    int oldScrollX = mDetailView.getScrollX();
                    int dx = 0;
                    if (oldScrollX <= 0 && canSlideRight) {
                        if (xVelocity > VELOCITY) {// 向右滑动，超出指定速度时
                            dx = -getDetailViewWidth() - oldScrollX;
                        } else if (xVelocity < -VELOCITY) {// 向左滑动，超出指定速度时
                            dx = -oldScrollX;
                            // if (hasClickRight) {
                            // hasClickRight = false;
                            // setCanSliding( tCanSlideRight);
                            // }
                        } else if (oldScrollX < -getDetailViewWidth() / 2) {// 指定速度内
                            dx = -getDetailViewWidth() - oldScrollX;
                        } else if (oldScrollX >= -getDetailViewWidth() / 2) {// 指定速度内
                            dx = -oldScrollX;
                            // if (hasClickRight) {
                            // hasClickRight = false;
                            // setCanSliding( tCanSlideRight);
                            // }
                        }
                    }

                    smoothScrollTo(dx);

                }

                break;
        }

        return true;
    }
    //获得右侧视图的宽度
    private int getDetailViewWidth() {
        if (mDetailView == null) {
            return 0;
        }
        return mDetailView.getWidth();
    }

    // 自动滚动view
    void smoothScrollTo(int dx) {
        int duration = 500;
        int oldScrollX = mDetailView.getScrollX();
        mScroller.startScroll(oldScrollX, mDetailView.getScrollY(), dx,
                mDetailView.getScrollY(), duration);
        invalidate();
    }

    /* 显示右侧边的view */
    public void showRightView() {
        int menuWidth = mDetailView.getWidth();
        int oldScrollX = mDetailView.getScrollX();
        System.out.println("x : " + oldScrollX);
        if (oldScrollX == 0) {
            mDetailView.setVisibility(View.VISIBLE);
            smoothScrollTo(-menuWidth);
            tCanSlideRight = canSlideRight;
            hasClickRight = true;
            setCanSliding(true);
        } else if (oldScrollX == -menuWidth) {
            smoothScrollTo(menuWidth);
            if (hasClickRight) {
                hasClickRight = false;
                setCanSliding(tCanSlideRight);
            }
        }
    }



}
