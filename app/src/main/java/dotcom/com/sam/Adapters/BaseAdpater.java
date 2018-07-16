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
public  class BaseAdpater extends BaseExpandableListAdapter {

    private Context context;
    private  ArrayList<HashMap<String, String>> arrcontactList;
    private  ArrayList<ArrayList<HashMap<String, String>>> arrSubCateogry;



    public BaseAdpater(Context context)
    {
        this.context=context;
    }


    @Override
    public int getGroupCount() {
        return  Constants.shareInstace.arrSubCateogry.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return  Constants.shareInstace.arrSubCateogry.get(new Integer(String.valueOf(Constants.shareInstace.arrcontactList.get(groupPosition))))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Constants.shareInstace.arrSubCateogry.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return Constants.shareInstace.arrSubCateogry.get(new Integer(String.valueOf(Constants.shareInstace.arrcontactList.get(groupPosition)))).get(childPosititon);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.single_categeory, null);
        }
        TextView txtListChild = convertView.findViewById(R.id.text_subcat);






        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}