package com.example.admin.imageloader.tools;

import android.graphics.drawable.GradientDrawable;



/**
 * 功能：获取对应的圆角的drawable
 * 描述：开了多个方法，可单独设置上下左右四个角，或者使用setAllRound()同时设置四个角，可设置drawable的颜色和描边的宽度和颜色
 * Created by chenjie on 2017/12/21.
 */

public class XLRoundDrawable extends GradientDrawable {


    private XLRoundDrawable(float leftTop, float rightTop, float leftBottom, float rightBottom, int centerColor, int strokeColor, int storeWidth) {
        setColor(centerColor);
        setStroke(storeWidth, strokeColor);
        float[] cornerList = {leftTop, leftTop, rightTop, rightTop, rightBottom, rightBottom, leftBottom, leftBottom};
        setCornerRadii(cornerList);
    }

    public static class Builder {
        private float mLeftTopDp = 0f;
        private float mRightTopDp = 0f;
        private float mLeftBottomDp = 0f;
        private float mRightBottomDp = 0f;
        private int mCenterColor = 0xFFFFFFFF;
        private int mStrokeColor = 0xFFFFFFFF;
        private int mStrokeWidthDp = 0;


        public float getLeftTopDp() {
            return mLeftTopDp;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         *
         * @return
         */
        public Builder setLeftTopDp(float leftTop) {
            mLeftTopDp = leftTop;
            return this;
        }

        public float getRightTopDp() {
            return mRightTopDp;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         * @return
         */
        public Builder setRightTopDp(float rightTop) {
            mRightTopDp = rightTop;
            return this;
        }

        public float getLeftBottomDp() {
            return mLeftBottomDp;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         * @return
         */
        public Builder setLeftBottomDp(float leftBottom) {
            mLeftBottomDp = leftBottom;
            return this;
        }

        public float getRightBottomDp() {
            return mRightBottomDp;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         * @return
         */
        public Builder setRightBottomDp(float rightBottom) {
            mRightBottomDp = rightBottom;
            return this;
        }

        public int getCenterColor() {
            return mCenterColor;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         * @return
         */
        public Builder setCenterColor(int centerColor) {
            mCenterColor = centerColor;
            return this;
        }

        public int getStrokeColor() {
            return mStrokeColor;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         * @return
         */
        public Builder setStrokeColor(int strokeColor) {
            mStrokeColor = strokeColor;
            return this;
        }

        public float getStrokeWidthDp() {
            return mStrokeWidthDp;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         * @return
         */
        public Builder setStrokeWidthDp(int strokeWidth) {
            mStrokeWidthDp = strokeWidth;
            return this;
        }

        /**
         * 单位为dp，不需要使用disPlayUtils处理，在内部会进行处理
         * @return
         */
        public Builder setAllRoundDp(float round) {
            mLeftTopDp = round;
            mRightTopDp = round;
            mLeftBottomDp = round;
            mRightBottomDp = round;
            return this;
        }

        public XLRoundDrawable builder() {
            return new XLRoundDrawable(mLeftTopDp, mRightTopDp, mLeftBottomDp, mRightBottomDp, mCenterColor, mStrokeColor, mStrokeWidthDp);
        }
    }
}
