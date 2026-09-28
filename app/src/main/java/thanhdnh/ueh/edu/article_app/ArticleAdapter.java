package thanhdnh.ueh.edu.article_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticleAdapter extends BaseAdapter {
  private final ArrayList<UserProfile> user_list;
  private final Context context;

  public ArticleAdapter(ArrayList<UserProfile> user_list, Context context) {
    this.user_list = user_list;
    this.context = context;
  }

  @Override
  public int getCount() {
    return user_list.size();
  }

  @Override
  public UserProfile getItem(int position) {
    return user_list.get(position);
  }

  @Override
  public long getItemId(int position) {
    return user_list.get(position).getId();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    final MyView dataitem;
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (convertView == null) {
      dataitem = new MyView();
      convertView = inflater.inflate(R.layout.article_disp_tpl, parent, false);
      dataitem.iv_photo = convertView.findViewById(R.id.imv_photo);
      dataitem.tv_caption = convertView.findViewById(R.id.tv_title);
      convertView.setTag(dataitem);
    } else {
      dataitem = (MyView) convertView.getTag();
    }

    UserProfile user = user_list.get(position);
    if (user.getAvatar_url() != null && !user.getAvatar_url().isEmpty()) {
      Picasso.get().load(user.getAvatar_url()).resize(300, 300).centerCrop().placeholder(R.mipmap.ic_launcher).into(dataitem.iv_photo);
    } else {
      dataitem.iv_photo.setImageResource(R.mipmap.ic_launcher);
    }
    dataitem.tv_caption.setText(user.getUsername());
    return convertView;
  }

  private static class MyView {
    ImageView iv_photo;
    TextView tv_caption;
  }
}
