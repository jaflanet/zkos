package com.fif;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel {

	private int count;
	private String var;

	@Init
	public void init() {
		count = 100;
		var="";
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}

	@Command
	@NotifyChange("var")
	public void name(){
		var = "test";
	}
	public String getVar(){return var;}


}

