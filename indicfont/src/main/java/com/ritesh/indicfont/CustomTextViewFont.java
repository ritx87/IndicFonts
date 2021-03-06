package com.ritesh.indicfont;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class CustomTextViewFont extends TextView {
    private int position;

    public CustomTextViewFont(Context context) {
        super(context);
    }

    public CustomTextViewFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FontFamily, 0, 0);
        position = typedArray.getInt(R.styleable.FontFamily_indic_fonts, 1);
        typedArray.recycle();
        init();
    }

    private void init() {
        String[] fonts = getResources().getStringArray(R.array.fonts);
        String font = fonts[position];
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + font);
        setTypeface(typeface, 1);
    }

}
