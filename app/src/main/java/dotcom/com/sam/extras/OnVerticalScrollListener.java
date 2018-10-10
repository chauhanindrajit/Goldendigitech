package dotcom.com.sam.extras;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class OnVerticalScrollListener extends RecyclerView.OnScrollListener {

    CardView layout;

    public OnVerticalScrollListener(CardView linearLayout) {
        layout = linearLayout;
    }

    @Override
    public final void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (!recyclerView.canScrollVertically(-1)) {
            onScrolledToTop();
        } else if (!recyclerView.canScrollVertically(1)) {
            onScrolledToBottom();
        }
        if (dy < 0) {
            onScrolledUp(dy);
        } else if (dy > 0) {
            onScrolledDown(dy);
        }
    }

    public void onScrolledUp(int dy) {
        onScrolledUp();
    }

    public void onScrolledDown(int dy) {
        onScrolledDown();
    }

    public void onScrolledUp() {
        Log.d("hhh", "Scrolled up");
        if (layout.getVisibility() == View.GONE) {
            Log.d("hhh", "Scrolled up vv");
            layout.setVisibility(View.VISIBLE);
        }

    }

    public void onScrolledDown() {
        Log.d("hhh", "Scrolled down");
        if (layout.getVisibility() != View.GONE) {
            Log.d("hhh", "Scrolled down vv");
            layout.setVisibility(View.GONE);
        }
    }

    public void onScrolledToTop() {
    }

    public void onScrolledToBottom() {
    }
}