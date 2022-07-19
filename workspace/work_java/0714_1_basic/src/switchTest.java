
public class switchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2022;
		int month = 2;
		int lastDay = 0;
		
		//month월의 유효성 체크를 하여 1-12 월이 아닐 경우는 메소드의 실행을 끝낸다.
		// 그렇지 않으면 마지막 날짜를 구한다.
		
		if (month > 12 || month < 1) {
			System.out.println("월 정보가 유효하지 않습니다.");
			return;
		}
		
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				lastDay = 31;
				break;
			case 4: case 6: case 9: case 11:
				lastDay = 30;
				break;
			default:
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
					lastDay = 29;
				} else {				
					lastDay = 28;
				}
				break;
		}
		
		System.out.println(month+"월의 마지막 날짜는 " + lastDay + "일 입니다.");
	}

}
