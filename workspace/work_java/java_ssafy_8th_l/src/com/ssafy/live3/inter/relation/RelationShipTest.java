package com.ssafy.live3.inter.relation;

//상속은 한번밖에,인터페이스는 언제든지!@! 

public class RelationShipTest {
    public static void main(String[] args) {
        Object [] objs = {new HandPhone(), new Camera(), new Phone(), new DigitalCamera()};
        
        // TODO: 충전 가능한 객체들을 충전하시오.
        
        for (Object obj : objs) {
			if (obj instanceof Chargeable) {
				Chargeable c = (Chargeable)obj;
				c.charge();
			}
		}
        // END:
    }

}
