package aithammou.badr.listview.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aithammou.badr.listview.Model.Post;
import aithammou.badr.listview.R;

public class PostAdapter extends BaseAdapter {

    private Context context;
    private List<Post> list_post;



    public PostAdapter(Context context, List<Post> list_post) {
        this.context = context;
        this.list_post = list_post;
    }

    @Override
    public int getCount() {
        return list_post.size();
    }

    @Override
    public Object getItem(int position) {
        return list_post.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_item_home,parent,false);
        }

        Post currentPost = (Post)  getItem(position);

        TextView texttitre = (TextView)
                convertView.findViewById(R.id.titre);
        TextView textdesc = (TextView)
                convertView.findViewById(R.id.desc);
        TextView textduree = (TextView)
                convertView.findViewById(R.id.dur);
        ImageView image = (ImageView)
                convertView.findViewById(R.id.imageview);
        TextView texteva = (TextView)
                convertView.findViewById(R.id.eva);

        texttitre.setText(currentPost.getTitre());
        textdesc.setText(currentPost.getDesc());
        textduree.setText(currentPost.getDuree());

        image.setImageResource(R.drawable.f1);

        return convertView;


    }
}
