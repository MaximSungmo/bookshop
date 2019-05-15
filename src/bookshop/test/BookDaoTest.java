package bookshop.test;

import java.util.List;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insert("아리랑", 2L);
		insert("젊은그들", 3L);
		insert("아프니깐 청춘이다", 4L);
		insert("귀천", 5L);
		insert("태백산맥", 6L);
		insert("풀하우스", 7L);

		
		//getList test
		getListTest();
		
	}
	
	public static void insert(String title, Long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthorNo(authorNo);
		
		new BookDao().insert(vo);
	}
	
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}

}
