package thanhdnh.ueh.edu.article_app;

import android.app.Activity;
import android.content.Context;
import android.widget.GridView;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArticleData {
  public static UserList data;
  private Context context;
  private GridView gridview;
  private final ExecutorService executor = Executors.newSingleThreadExecutor();

  public ArticleData(Context context, GridView gridview) {
    this.context = context;
    this.gridview = gridview;
  }

  public static UserProfile getPhotoFromId(int id) {
    if (data == null || data.getUsers() == null) return null;
    for (int i = 0; i < data.getUsers().size(); i++) {
      if (data.getUsers().get(i).getId() == id)
        return data.getUsers().get(i);
    }
    return null;
  }

  public static ArrayList<UserProfile> getMockStudents() {
    ArrayList<UserProfile> list = new ArrayList<>();
    list.add(new UserProfile(1, "Nguyễn Văn A", "nguyenvana@gmail.com", "Học sinh lớp 12A1, hăng hái tham gia các hoạt động ngoại khóa và yêu thích công nghệ.", "https://i.pravatar.cc/300?img=11", "Đá bóng, Lập trình Android"));
    list.add(new UserProfile(2, "Trần Thị B", "tranthib@gmail.com", "Học sinh giỏi mỹ thuật, thích đọc sách văn học và tham gia câu lạc bộ âm nhạc.", "https://i.pravatar.cc/300?img=5", "Vẽ tranh, Nghe nhạc"));
    list.add(new UserProfile(3, "Lê Hoàng C", "lehoangc@gmail.com", "Thành viên đội tuyển cờ vua trường, tính cách hòa đồng, nhanh nhạy.", "https://i.pravatar.cc/300?img=12", "Chơi cờ vua, Bơi lội"));
    list.add(new UserProfile(4, "Phạm Minh D", "phamminhd@gmail.com", "Đam mê nhiếp ảnh nghệ thuật, thích khám phá các vùng đất mới.", "https://i.pravatar.cc/300?img=13", "Chụp ảnh, Du lịch"));
    list.add(new UserProfile(5, "Hoàng Anh E", "hoanganhe@gmail.com", "Thích sáng tạo các món ăn mới, quản lý lớp năng nổ và nhiệt tình.", "https://i.pravatar.cc/300?img=9", "Nấu ăn, Làm bánh"));
    list.add(new UserProfile(6, "Vũ Quốc F", "vuquocf@gmail.com", "Nhạc công nhóm nhạc trường, yêu thích thể thao và thích giao lưu bạn bè.", "https://i.pravatar.cc/300?img=14", "Chơi Guitar, Cầu lông"));
    list.add(new UserProfile(7, "Đặng Thu G", "dangthug@gmail.com", "Học sinh giỏi tiếng Anh, từng đạt giải thưởng cuộc thi múa cấp thành phố.", "https://i.pravatar.cc/300?img=10", "Múa, Học ngoại ngữ"));
    list.add(new UserProfile(8, "Bùi Tấn H", "buitanh@gmail.com", "Đội trưởng đội bóng rổ lớp, phong cách năng động và hòa đồng.", "https://i.pravatar.cc/300?img=15", "Chơi bóng rổ, Game online"));
    return list;
  }

  public void loadData(String url, Activity activity) {
    data = new UserList(getMockStudents());
    ArticleAdapter adapter = new ArticleAdapter(data.getUsers(), context);
    gridview.setAdapter(adapter);
  }

  public String readText(File file) {
    BufferedReader reader = null;
    try {
      InputStream stream = new FileInputStream(file);
      reader = new BufferedReader(new InputStreamReader(stream));
      StringBuffer buffer = new StringBuffer();
      String line = "";
      while ((line = reader.readLine()) != null) {
        buffer.append(line + "\n");
      }
      return buffer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }
}
