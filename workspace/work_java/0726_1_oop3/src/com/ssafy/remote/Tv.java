package com.ssafy.remote;

public class Tv implements RemoteControl {

	private int volume; 
	private int cnt = 1;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 킵니다.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
	@Override
	public void upVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else {
			this.volume += cnt;
		}
		
	}
	@Override
	public void downVolume(int volume) {
		if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else {
			this.volume -= cnt;
		}
		
	}
	
	
}
