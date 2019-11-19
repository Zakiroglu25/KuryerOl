package com.aris.kuryerol.activities.expandleList;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.drawermenu.StartWork;
import com.aris.kuryerol.activities.models.Header;

import java.util.HashMap;
import java.util.List;

public class ExpandleAdapter extends BaseExpandableListAdapter {
    private List<String> headers; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<Object>> hashMap;

    private final int ORDER = 1;
    private final int HEADER = 2;
    private final int FOOTER = 3;


    public ExpandleAdapter(List<String> listDataHeader,
                           HashMap<String, List<Object>> listChildData) {

        this.headers = listDataHeader;
        this.hashMap = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.hashMap.get(this.headers.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        int layId;
        Log.e(TAG, "getChildView: " );

        switch (getChildType(groupPosition, childPosition)) {

            case HEADER:

                layId = R.layout.lit_item_archive;
                break;

            case FOOTER:

                layId = R.layout.list_item_footer;

                break;


            case ORDER:
                layId = R.layout.list_item_order;


                break;
            default:
                throw new RuntimeException("WTF");
        }


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(layId, null);
        }

//        TextView txtListChild = (TextView) convertView
//                .findViewById(R.id.textView24);
//        TextView xtListChild = (TextView) convertView
//                .findViewById(R.id.txt_order_name);
//
//
//        txtListChild.setText(childText);
        return convertView;

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.hashMap.get(this.headers.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headers.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return headers.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    private static final String TAG = "ExpandleAdapter";
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.lsit_group_archive, null);
        }

        TextView lblListHeader = convertView
                .findViewById(R.id.order_number);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public int getChildType(int groupPosition, int childPosition) {
        Object object = getChild(groupPosition, childPosition);

        if (object instanceof String) {
            return HEADER;
        } else if (object instanceof Double) {
            return ORDER;
        } else if (object instanceof Float) {
            return FOOTER;
        }

        throw new RuntimeException("Object not supported");
    }

    @Override
    public int getChildTypeCount() {
        return 4;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}