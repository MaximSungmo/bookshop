package bookshop.test;

import java.util.List;

import bookshop.dao.AuthorDao;
import bookshop.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
	
		//insert test
		insertTest("김동인");
		insertTest("김난도");
		insertTest("천상병");
		insertTest("조정래");
		insertTest("원수연");

		//getList test
		getListTest();
		
		
	}
	
	public static void getListTest() {
		AuthorDao dao = new AuthorDao();
		List<AuthorVo> list = dao.getList();
		
		for(AuthorVo vo:list) {
			System.out.println(vo);
		}
	}
	
	public static void insertTest(String name) {
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		
		new AuthorDao().insert(vo);
		
	}

}
