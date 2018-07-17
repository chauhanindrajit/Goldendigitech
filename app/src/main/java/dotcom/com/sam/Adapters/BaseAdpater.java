package dotcom.com.sam.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import dotcom.com.sam.R;
import dotcom.com.sam.extras.Constants;

/**
 * Created by sanjay on 3/9/2018.
 */
public  class BaseAdpater  {

    private Context context;
    private  ArrayList<HashMap<String, String>> arrcontactList;
    private  ArrayList<ArrayList<HashMap<String, String>>> arrSubCateogry;



    public BaseAdpater(Context context)
    {
        this.context=context;
    }



}