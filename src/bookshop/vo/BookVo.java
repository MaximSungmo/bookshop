package bookshop.vo;

public class BookVo {

	private Long no;
	private String title;
	private String status;
	
	private Long AuthorNo;	
	private String AuthorName;

	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getAuthorNo() {
		return AuthorNo;
	}
	public void setAuthorNo(Long authorNo) {
		AuthorNo = authorNo;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	
	
}
