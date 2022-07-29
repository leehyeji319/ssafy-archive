import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAODom implements WeatherDAO {

	@Override
	public List<Weather> getWeatherList(String url) {
		return connectWeather(url);
	}

	private List<Weather> connectWeather(String url) {
		List<Weather> list = new ArrayList<>();

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = f.newDocumentBuilder();
			// w4c import
			// event방식이 아니기 때문에 이벤트관련이 필요없다.
			Document dom = builder.parse(new URL(url).openConnection().getInputStream());

			Element root = dom.getDocumentElement();
			// dom에 관련된거는 wc3가 관리하는 것임
			NodeList nodeList = root.getElementsByTagName("data");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Weather w = new Weather();
				Node item = nodeList.item(i);

				NodeList kids = item.getChildNodes();

				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);

					String name = kid.getNodeName();
					if (name.equals("tmwf")) {
						// text노드의 값을 가져와라
//						w.setDate(kid.getFirstChild().getNodeValue());
						w.setDate(kid.getTextContent()); // 얘는 텍스트 노드
					} else if (name.equals("wf")) {
						w.setDate(kid.getFirstChild().getNodeValue());

					} else if (name.equals("tmn")) {
						w.setDate(kid.getFirstChild().getNodeValue());

					} else if (name.equals("tmx")) {
						w.setDate(kid.getFirstChild().getNodeValue());

					}

				}
				list.add(w);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
