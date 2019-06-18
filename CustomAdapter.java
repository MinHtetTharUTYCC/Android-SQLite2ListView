package test1.com.sqlite2listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ModelItem> modelArrayList;

    public CustomAdapter(Context context, ArrayList<ModelItem> modelArrayList) {

        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null, true);

        holder.col1 = (TextView) convertView.findViewById(R.id.col1);
        holder.col2 = (TextView) convertView.findViewById(R.id.col2);
        holder.col3 = (TextView) convertView.findViewById(R.id.col3);
        holder.col4 = (TextView) convertView.findViewById(R.id.col4);

        convertView.setTag(holder);
    }else {
        // the getTag returns the viewHolder object set as a tag to the view
        holder = (ViewHolder)convertView.getTag();
    }
        holder.col1.setText(modelArrayList.get(position).getCol1());
        holder.col2.setText(modelArrayList.get(position).getCol2());
        holder.col3.setText(modelArrayList.get(position).getCol3());
        holder.col4.setText(modelArrayList.get(position).getCol4());

        return convertView;
    }

    private class ViewHolder {

        protected TextView col1, col2, col3, col4;

    }
}

