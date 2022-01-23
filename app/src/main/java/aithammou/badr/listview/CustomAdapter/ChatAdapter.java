package aithammou.badr.listview.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aithammou.badr.listview.R;
import aithammou.badr.listview.Model.User;

public class ChatAdapter extends BaseAdapter {

    private Context context;
    private List<User> list_user;

    public ChatAdapter(Context context, List<User> list_user) {
        this.context = context;
        this.list_user = list_user;
    }


    @Override
    public int getCount() {
        return list_user.size();
    }

    @Override
    public Object getItem(int position) {
        return list_user.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_chat_layout,parent,false);
        }

        User currentuser = (User) getItem(position);

        TextView textnom = (TextView)
                convertView.findViewById(R.id.user_name_chat);
        TextView textchat = (TextView)
                convertView.findViewById(R.id.chattext);
        ImageView imageuser = (ImageView)
                convertView.findViewById(R.id.image_chat_user);

        textnom.setText((currentuser.getNom()));
        textchat.setText((currentuser.getChattext()));
        imageuser.setImageResource(R.drawable.badr);


        return convertView;
    }
}
