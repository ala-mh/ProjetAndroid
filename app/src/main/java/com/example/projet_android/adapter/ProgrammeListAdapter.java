package com.example.projet_android.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projet_android.R;
import com.example.projet_android.model.Programme;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeListAdapter  extends ArrayAdapter<Programme> {

    private static final String TAG = "PersonListAdapter";

     private  Context context;
     //private  List<Programme> programme_list;
     private int lastPosition = -1;
     private int resource;

    private static class ViewItem {
        TextView maladieView;
        TextView date_debutView;
        TextView dureeView;
    }

    public ProgrammeListAdapter(Context context, int resource, List<Programme> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    /*public ProgrammeListAdapter(List<Programme> programme_list, Context context)
    {
        this.programme_list = programme_list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return this.programme_list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.programme_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //create the view result for showing the animation
        //final View result;
        /*
        ViewItem viewItem = null;

        if (convertView == null) {

            viewItem = new ViewItem();

            LayoutInflater layoutInfiater = (LayoutInflater) this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInfiater.inflate(R.layout.row, null);

            viewItem.maladieView = (TextView) convertView.findViewById(R.id.MaladieView);

            viewItem.date_debutView = (TextView) convertView.findViewById(R.id.DataView);

            viewItem.dureeView = (TextView) convertView.findViewById(R.id.DureeView);

           // result = convertView;
            convertView.setTag(viewItem);

        } else {
            viewItem = (ViewItem) convertView.getTag();
           // result = convertView;

        }

        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewItem.maladieView.setText(programme_list.get(position).getMaladie());

        viewItem.date_debutView.setText(programme_list.get(position).getDate_debut());

        viewItem.dureeView.setText(programme_list.get(position).getDuree());

        return convertView;
        */


        //get the persons information
        String maladie = getItem(position).getMaladie();
        String date_debut = getItem(position).getDate_debut();
        String duree = getItem(position).getDuree();

        //Create the person object with the information
        Programme programme = new Programme(maladie,date_debut,duree);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewItem holder;

            if(convertView == null){
                    LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(this.context);
                    convertView = inflater.inflate(this.resource, parent, false);

                    holder= new ViewItem();
                    holder.maladieView = (TextView) convertView.findViewById(R.id.MaladieView);
                    holder.date_debutView = (TextView) convertView.findViewById(R.id.DataView);
                    holder.dureeView = (TextView) convertView.findViewById(R.id.DureeView);

                    result = convertView;

                    convertView.setTag(holder);
            }
            else{
                    holder = (ViewItem) convertView.getTag();
                    result = convertView;
            }


        Animation animation = AnimationUtils.loadAnimation(this.context,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;


        holder.maladieView.setText(programme.getMaladie());
        holder.date_debutView.setText("Date Début "+programme.getDate_debut());
        holder.dureeView.setText("Durée Maladie "+programme.getDuree());


        return convertView;
    }


}
