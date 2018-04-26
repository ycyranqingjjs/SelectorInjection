package kale.utils;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import kale.injection.R;

/**
 * @author Kale
 * @date 2016/9/6
 */
public class AppCompatTextViewHelper {

    private static final int DEFAULT_COLOR = -1;

    private TextView mView;

    AppCompatTextViewHelper(TextView view) {
        mView = view;
    }

    public void loadFromAttributes(AttributeSet attrs, int defStyleAttr) {
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(mView.getContext(), attrs,
                R.styleable.SelectorInjection, defStyleAttr, 0);

        Drawable[] drawables = mView.getCompoundDrawables();

        int[] colors = {
                a.getColor(R.styleable.SelectorInjection_drawableLeftTint, DEFAULT_COLOR),
                a.getColor(R.styleable.SelectorInjection_drawableTopTint, DEFAULT_COLOR),
                a.getColor(R.styleable.SelectorInjection_drawableRightTint, DEFAULT_COLOR),
                a.getColor(R.styleable.SelectorInjection_drawableBottomTint, DEFAULT_COLOR)};

        tintDrawables(drawables, colors);

        a.recycle();
    }

    private static void tintDrawables(Drawable[] drawables, int[] colors) {
        Drawable drawable;

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != DEFAULT_COLOR && (drawable = drawables[i]) != null) {
                SelectorUtils.tintDrawable(drawable, colors[i]);
            }
        }
    }

}
