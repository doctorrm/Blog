package page_flip;

public class User {//这个不代表数据表，而是简单的对象。用来储存从数据库中读取的数据。这个与hibernate就不一样了。
private int id;
private String name;
private String number;
  public int getId() {
	  return id;
  }
  public void setId(int id) {
	  this.id = id;
  }
  public String getName() {
	  return name;
  }
  public void setName(String name) {
	  this.name = name;
  }
  public String getNumber() {
	  return number;
  }
  public void setNumber(String number) {
	  this.number = number;
  }
}
