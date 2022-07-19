
public class ifTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2022;
		int month = 3;
		int lastDay = 0;
		
		//month월의 유효성 체크를 하여 1-12 월이 아닐 경우는 메소드의 실행을 끝낸다.
		// 그렇지 않으면 마지막 날짜를 구한다.
		
		if (month > 12 || month < 1) {
			System.out.println("월 정보가 유효하지 않습니다.");
		}
		
		if (month ==1 || month==3 || month==7 || month==8 || month==10 || month == 12) {
			lastDay = 31;
		} else if (month == 4 || month ==6 || month == 9 || month == 11) {
			lastDay =30;
		} else {
			// 평년이면 28, 윤년이면 29
			if (year % 400 == 0 || (year % 3 == 0 && year % 100 != 0)) {
				lastDay = 29;
			} else {				
				lastDay = 28;
			}
		}
		
		System.out.println(month+"월의 마지막 날짜는 " + lastDay + "일 입니다.");
	}

}