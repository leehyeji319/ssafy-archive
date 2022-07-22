import java.util.Arrays;

public class BookManager {

	private static final int MAX_SIZE = 100;

	private Book[] books = new Book[MAX_SIZE];

	private int size; // 현재 책의 갯수. 기본으로 0 초기화

	public void add(Book book) {
		if (size < MAX_SIZE) {
			books[size++] = book;
		} else
			System.out.println("책장이 가득 찻습니다.");
	}

	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			// 지우려고하는 책을 맨뒤에서 뽑아서 매꿔주기, size - 1
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[size - 1];
				books[size - 1] = null; // 마지막 책 자리에 레퍼런스 살아있으니까 명시적으로 참조를 끊어준것
				--size;
				break;
			}
		}
	}

	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size); // 실제 배열의 사이즈만큼
		// return books; //그냥 보내면 안정적이지 않다.
	}

	public Book searchByIsbn(String isbn) {

		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn))
				return books[i];
		}
		return null; // 다돌아도 못찾는다면 null리턴
	}
}
