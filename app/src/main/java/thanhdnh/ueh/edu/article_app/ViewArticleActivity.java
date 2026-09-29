package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ViewArticleActivity extends AppCompatActivity {
  private ImageView iv_detail;
  private TextView tv_detail_title;
  private TextView tv_detail_id;
  private TextView tv_detail_email;
  private TextView tv_detail_hobby;
  private TextView tv_detail_description;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_article);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }

    iv_detail = findViewById(R.id.iv_detail);
    tv_detail_title = findViewById(R.id.tv_detail_title);
    tv_detail_id = findViewById(R.id.tv_detail_id);
    tv_detail_email = findViewById(R.id.tv_detail_email);
    tv_detail_hobby = findViewById(R.id.tv_detail_hobby);
    tv_detail_description = findViewById(R.id.tv_detail_description);

    int id = (int) getIntent().getLongExtra("id", 0);
    UserProfile user = ArticleData.getPhotoFromId(id);

    if (user != null) {
      if (user.getAvatar_url() != null && !user.getAvatar_url().isEmpty()) {
        Picasso.get().load(user.getAvatar_url()).resize(400, 400).centerCrop().placeholder(R.mipmap.ic_launcher).into(iv_detail);
      } else {
        iv_detail.setImageResource(R.mipmap.ic_launcher);
      }
      tv_detail_title.setText(user.getUsername());
      tv_detail_id.setText("Mã học sinh: " + user.getId());
      tv_detail_email.setText("Email: " + user.getEmail());
      tv_detail_hobby.setText("Sở thích: " + user.getHobby());
      tv_detail_description.setText("Mô tả: " + user.getDesc());
    }
  }
}
