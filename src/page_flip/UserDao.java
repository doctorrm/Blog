package page_flip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import page_flip.JDBCUtils;
public class UserDao {
/**
* �����ܵ�ҳ��
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
* ��ѯָ��ҳ������
* @param pageNo����Ϊ�ڼ�ҳ
* @return
*/
public List<User> listUser(int pageNo){//listUser says:you give me the pageNo you want,the i will return the list you want.That's just simple like this.
		PreparedStatement pstmt=null;
		ResultSet result=null;
		List<User> list=new ArrayList<User>();//list ������Ҫ��ʾ��
		int pageSize=5;//ÿһҳӦ����ʾ�ļ�¼
		int page=(pageNo-1)*5;//��pageNoҳ֮ǰ���еļ�¼����page+1�͵õ���pageNoҳ�ĵ�һ��item�����ݿ��еĶ�Ӧ��¼��
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
		User user=new User();//������������ݱ�����һ���򵥵Ķ���
		user.setId(result.getInt(1));
		user.setName(result.getString(2));//getString(2) ˵���ǵõ����ݿ��ж�Ӧ��title��column 2����������name
		user.setNumber(result.getString(3));
		list.add(user);//��һ�����洢�����ݿ��¼�Ķ��󶼼��뵽list��
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
