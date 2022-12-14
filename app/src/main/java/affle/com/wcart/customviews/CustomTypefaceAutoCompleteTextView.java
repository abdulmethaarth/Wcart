package affle.com.wcart.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import affle.com.wcart.R;
import affle.com.wcart.utils.Logger;

/**
 * This class is a custom EditText that is used to set the typeface through xml
 *
 * @author Affle Appstudioz
 */
public class CustomTypefaceAutoCompleteTextView extends AutoCompleteTextView {
    private static final String TAG = "CustomTypefaceAutoCompleteTextView";
    private Typeface mTypeface;

    public CustomTypefaceAutoCompleteTextView(Context context) {
        super(context);
        setCustomFont(context, null);
    }

    public CustomTypefaceAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public CustomTypefaceAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray fontTypedArray = ctx.obtainStyledAttributes(attrs, R.styleable.CustomTypefaceTextView);
            String textStyle = fontTypedArray.getString(R.styleable.CustomTypefaceTextView_font_name_with_asset_path);
            try {
                if (textStyle == null) {
                    mTypeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/Roboto-Regular.ttf");
                } else {
                    mTypeface = Typeface.createFromAsset(ctx.getAssets(), textStyle);
                }
            } catch (Exception e) {
                Logger.e(TAG + "Could not get typeface: " + textStyle + "&&" + e.getMessage() + " " + this.getId());
            }
            setTypeface(mTypeface);
            fontTypedArray.recycle();
        } else {
            try {
                mTypeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/Roboto-Regular.ttf");
            } catch (Exception e) {
                Logger.e(TAG + "Could not get typeface: fonts/Roboto-Regular.ttf &&" + e.getMessage() + " " + this.getId());
            }
            setTypeface(mTypeface, 0);
        }
    }
}