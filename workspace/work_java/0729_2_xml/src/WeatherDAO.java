
//날씨 정보를 가져올 수 잇느 ㄴ애들은 이 인터페이스를 지켜주세요 .
import java.util.List;

public interface WeatherDAO {

	List<Weather> getWeatherList(String url);

}