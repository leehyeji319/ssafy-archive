package com.ssafy.live5.parse.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ssafy.live5.parse.BoxOffice;

public class BoxOfficeDomParser {
    private final File xml = new File("./src/com/ssafy/live5/parse/boxoffice.xml");
    private List<BoxOffice> list = new ArrayList<>();
    
    public List<BoxOffice> getBoxOffice() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 문서 로딩 완료 --> 원하는 요소들 골라내기
            Document doc = builder.parse(xml);
            // 최 상위 element
            Element root = doc.getDocumentElement();
            parse(root);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void parse(Element root) {
        // TODO: root에서 dailyBoxOffice를 추출한 후 BoxOffice를 생성해 list에 저장하시오.
    	NodeList list = root.getElementsByTagName("dailyBoxOffice");
    	for (int i=0; i<list.getLength(); i++) {
    		Node node = list.item(i); //node타입의 노드 반환을 해줌
    		//pasing하고 노드정보를 리스트에 넘겨주면 되지
    		this.list.add(getBoxOffice(node));
    	}
        // END:
    }

    private static BoxOffice getBoxOffice(Node node) {
        BoxOffice boxOffice = new BoxOffice();
        // TODO: node 정보를 이용해서 BoxOffice를 구성하고 반환하시오.
        
        NodeList list = node.getChildNodes();
        // END:
        for (int i=0; i<list.getLength(); i++) {
        	Node childNode = list.item(i);
        	String nodeName = childNode.getNodeName();
        	String textContent = childNode.getTextContent();
        	
        	if (nodeName.equals("rank")) {
        		boxOffice.setRank(Integer.valueOf(textContent));
        	} else if(nodeName.equals("movieNm")) {
        		boxOffice.setMovieNm(textContent);
        	} else if (nodeName.equals("openDt")) {
        		boxOffice.setOpenDt(boxOffice.toDate(textContent));
        	} else if (nodeName.endsWith("autiAcc")) {
        		boxOffice.setAudiAcc(Integer.valueOf(textContent));
        	}
        }
        return boxOffice;
    }
}
