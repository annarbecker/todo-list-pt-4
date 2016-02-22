import java.util.List;
import org.sql2o.*;

public class Task {
  private int id;
  private String description;

  public String getDescription() {
    return description;
  }

  public int getId() {
    return id;
  }

  public Task(String description) {
    this.description = description;
  }

public static List<Task> all() {
  String sql = "SELECT id, description FROM Tasks";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Task.class);
  }
 }

 @Override
 public boolean equals(Object otherTask) {
   if (!(otherTask instanceof Task)) {
     return false;
   } else {
     Task newTask = (Task) otherTask;
     return this.getDescription().equals(newTask.getDescription());
   }
 }
}
