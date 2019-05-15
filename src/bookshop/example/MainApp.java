package bookshop.example;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class MainApp {

	public static void main(String[] args) {
//		Book[] books = new Book[10];
//		
//		books[0] = new Book( 1, "트와일라잇", "스테파니메이어" );
//		books[1] = new Book( 2,"뉴문", "스테파니메이어" );
//		books[2] = new Book( 3,"이클립스","스테파니메이어");
//		books[3] = new Book( 4,"브레이킹던","스테파니메이어");
//		books[4] = new Book( 5,"아리랑","조정래");
//		books[5] = new Book( 6,"젊은그들","김동인");
//		books[6] = new Book( 7,"아프니깐 청춘이다","김난도");
//		books[7] = new Book( 8,"귀천","천상병");
//		books[8] = new Book( 9,"태백산맥","조정래");
//		books[9] = new Book( 10,"풀하우스","원수연");

		
		displayBookInfo();
		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		Long no = scanner.nextLong();
		scanner.close();
		
		rent(no);
		displayBookInfo();

		
	}
	
	private static void rent(Long bookNo) {
		new BookDao().updateStatus(bookNo, "대여중");
	}
	
	private static void displayBookInfo() {
		System.out.println("*****도서 정보 출력하기******");
		List<BookVo> list = new BookDao().getList();
		for (BookVo vo : list) {
			System.out.println("책제목 : "+ vo.getTitle() + ", 작가 : " + vo.getAuthorName() + ", 대여 유무 : " + vo.getStatus());
		}
	}	
}