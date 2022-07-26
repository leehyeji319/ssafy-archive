package com.jurib.remote;

public abstract class HomeAppliance implements Controllable {
	public int volume;
	public final int MAX_VOLUME;
	public static final int MIN_VOLUME = 0;
	public boolean powerOn;
	
	//왜 객체 생성할 때만 생성자를 초기화 할 수 있을까?
	//객체는 한번밖에 안불리잖아...메서드에 넣으면 계속 불려오니까..그건 상수가 애초에 아니지ㅋㅋ 
	public HomeAppliance(int maxVolume) {
		super();
		this.MAX_VOLUME = maxVolume;
	}
	
	
	
}
