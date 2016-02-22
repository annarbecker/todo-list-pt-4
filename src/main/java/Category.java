import java.util.ArrayList;

public class Category {

  private static ArrayList<Category> instances = new ArrayList<Category>();
  private String mName;
  private ArrayList<Task> mTasks;
  private int mId;

  public Category(String name) {
    mName = name;
    mTasks = new ArrayList<Task>();
    instances.add(this);
    mId = instances.size();
  }
  public String getName() {
    return mName;
  }
  public ArrayList<Task> getTasks() {
    return mTasks;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Category> all() {
    return instances;
  }
  public static void clear() {
    instances.clear();
  }

  public static Category find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public void addTask (Task task) {
    mTasks.add(task);
  }
}
