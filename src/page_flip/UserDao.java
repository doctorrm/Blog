package page_flip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import page_flip.JDBCUtils;
public class UserDao {
/**
* 计算总的页数
* @return
*/
public int getPage(){
		int recordCount=0,t1=0,t2=0;//recordCount here represents the totel items;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		JDBCUtils jdbc=new JDBCUtils();
		Connection conn=jdbc.connect();
		String sql="select count(*) from blog";
		try {
			pstmt=conn.prepareStatement(sql);
			result=pstmt.executeQuery();
			result.next();
			recordCount=result.getInt(1);
			t1=recordCount%5;
			t2=recordCount/5;
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		jdbc.close(conn, pstmt, result);
		}
		if(t1 != 0){
		t2=t2+1;
		}
		return t2;
}
/**
* 查询指定页的数据
* @param pageNo参数为第几页
* @return
*/
public List<User> listUser(int pageNo){//listUser says:you give me the pageNo you want,the i will return the list you want.That's just simple like this.
		PreparedStatement pstmt=null;
		ResultSet result=null;
		List<User> list=new ArrayList<User>();//list 是最终要显示的
		int pageSize=5;//每一页应该显示的纪录
		int page=(pageNo-1)*5;//第pageNo页之前所有的纪录数，page+1就得到第pageNo页的第一个item在数据库中的对应纪录。
		JDBCUtils jdbc=new JDBCUtils();
		Connection conn=jdbc.connect();
		String sql="select * from blog order by id limit ?,?";
		try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, page);//locate or filter the particular item or id in database;
		pstmt.setInt(2, pageSize);// the wanted items are restricted as pageSize=5;
		//the previous 2 lines may let the pstmt hold or locate the determined page and its items.
		result=pstmt.executeQuery();
		while(result.next()){
		User user=new User();//这个不代表数据表！而是一个简单的对象。
		user.setId(result.getInt(1));
		user.setName(result.getString(2));//getString(2) 说明是得到数据库中对应的title（column 2），而不是name
		user.setNumber(result.getString(3));
		list.add(user);//把一个个存储了数据库纪录的对象都加入到list中
		}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally{
		jdbc.close(conn, pstmt, result);
		}
		return list;
		}
}
