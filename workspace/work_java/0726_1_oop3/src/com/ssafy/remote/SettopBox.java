package com.ssafy.remote;

public class SettopBox implements RemoteControl {

	private int volume; 
	private int cnt;
	
	@Override
	public void turnOn() {
		System.out.println("셋톱박스를 킵니다.");
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("셋톱박스를 끕니다.");
		
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
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume -= cnt;
		}
		
	}
}
