package com.ssafy.remote;

public interface RemoteControl {
	
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	public void turnOn();
	public void turnOff();
	public void upVolume(int volume);
	public void downVolume(int volume);
}
