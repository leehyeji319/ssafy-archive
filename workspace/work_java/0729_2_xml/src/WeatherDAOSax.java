import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAOSax implements WeatherDAO {

	private static List<Weather> list;
	
	
	@Override
	public List<Weather> getWeatherList(String url) {
		connetWeather(url);
		return list;
	}
	
	private void connetWeather(String url) {
		//saxparser가 여러개 있는데 하나를 박아넣으면 다른거 못쓰니까 그거 다생각해서 하는거임
		//팩토리를 쓰는애들은 어떤 객체를 사용하는지 팩토리쪽으로 다 숨겨놓는거야..
		
		SAXParserFactory f = SAXParserFactory.newInstance();
		
		try {
			SAXParser parser = f.newSAXParser();
			parser.parse(new URL(url).openConnection().getInputStream(), new SAXHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//약속된 메서드를 써야함. sax쓰면서 크게 네개정도있는데 그거를 모아놓은게 DefaultHandler
	private static class SAXHandler	extends DefaultHandler {

		Weather w;
		//종료처리 .??????????
		StringBuilder sb; //characters에서 나오는거 저장할거야
		
		@Override
		public void startDocument() throws SAXException {
			//여기서 지역변수하면 사라지잖어 박에 해야겟지?
			list = new ArrayList<Weather>(); //문서가 시작될 때 딱 한번만 만드러
			sb = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if((qName.equals("data"))) {
				w = new Weather();
				list.add(w);
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(w != null) {
				if(qName.equals("tmEf")) {
					w.setDate(sb.toString());
				}
				else if(qName.equals("wf")) {
					w.setWf(sb.toString());
				}
				else if(qName.equals("tmn")) {
					w.setTmn(sb.toString());
				}
				else if(qName.equals("tmx")) {
					w.setTmx(sb.toString());
				}
			}
			sb.setLength(0); //다하고 나면 비워줘야하니까
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(ch, start,length);
		} 
		
	}

}
