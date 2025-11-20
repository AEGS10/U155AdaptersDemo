package ec.edu.ug.u155adaptersdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class MyAdapter extends BaseAdapter {
    Context context;
    String[] colorNames;
    int[] colorValues;
    LayoutInflater inflater;
    public MyAdapter(Context context, String[] names, int[] values) {
        this.context = context;
        this.colorNames = names;
        this.colorValues = values;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return colorNames.length;
    }
    @Override
    public Object getItem(int position) {
        return colorNames[position];
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
// Patrón ViewHolder para rendimiento y evitar warnings
static class ViewHolder {
    View viewColor;
    TextView tvColorName;
}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // Si la vista puede reciclarse, úsala; si no, infla y crea el holder
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_custom, parent, false);
            holder = new ViewHolder();
            holder.viewColor = convertView.findViewById(R.id.viewColor);
            holder.tvColorName = convertView.findViewById(R.id.tvColorName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.viewColor.setBackgroundColor(colorValues[position]);
        holder.tvColorName.setText(colorNames[position]);
        return convertView;
    }
}
