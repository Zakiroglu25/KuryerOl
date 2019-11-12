package com.aris.kuryerol.activities.expandleList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aris.kuryerol.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandleAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listTitulo;
    private HashMap<String, Models> expandableListDetalles;

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


        return null;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Models models= (Models) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.lit_item_archive, null);

        }



        LinearLayout layoutLlamar = convertView.findViewById(R.id.lemar);
//        LinearLayout layoutVideollamada = convertView.findViewById(R.id.lVideoLlamada);
//        LinearLayout layoutMensaje = convertView.findViewById(R.id.lMensaje);
//        LinearLayout layoutInfo = convertView.findViewById(R.id.lInfo);

        layoutLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Llamamos a: "
                        + models.getOrderNo(), Toast.LENGTH_SHORT).show();
            }
        });

//        layoutMensaje.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "Mensaje para: "
//                        + contacto.getCorreo(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        layoutVideollamada.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "Videollamada a: "
//                        + contacto.getNumero(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        layoutInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                List<String> index = new ArrayList<>(expandableListDetalles.keySet());
//
//                Toast.makeText(v.getContext(), "Info de: "
//                        + index.get(groupPosition) + " Direccion: "
//                        + contacto.getDireccion(), Toast.LENGTH_SHORT).show();
//            }
//        });


        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        convertView.startAnimation(animation);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
