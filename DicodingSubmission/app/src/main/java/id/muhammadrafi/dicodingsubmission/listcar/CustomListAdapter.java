package id.muhammadrafi.dicodingsubmission.listcar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.muhammadrafi.dicodingsubmission.R;

public class CustomListAdapter extends ArrayAdapter<Car> {
    Context context;

    public CustomListAdapter(Context context, int resourceID, List<Car> item) {
        super(context, resourceID, item);
        this.context = context;
    }

    private class ViewHolder {
        ImageView carPhotos;
        TextView carName, carDescribe;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Car carLists = getItem(position);

        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_row_car, null);
            holder = new ViewHolder();
            holder.carName = convertView.findViewById(R.id.item_name);
            holder.carDescribe = convertView.findViewById(R.id.item_describe);
            holder.carPhotos = convertView.findViewById(R.id.itemPhoto);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

            holder.carName.setText(carLists.getName());
            holder.carDescribe.setText(carLists.getDescribe());
            holder.carPhotos.setImageResource(carLists.getPhoto());

            return convertView;
    }
}
