package dotcom.com.sam.extras;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.widget.FrameLayout;


@CoordinatorLayout.DefaultBehavior(FooterBarBehavior.class)
public class FooterBarLayout extends FrameLayout {
    public FooterBarLayout(Context context) {
        super(context);
    }

    public FooterBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FooterBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}