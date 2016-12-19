package com.f9g4.web.forms;

import java.util.Arrays;


public class DeleteCartItemsForm 
{
	private Integer[] select_item;

	public Integer[] getSelect_item() {
		return select_item;
	}

	public void setSelect_item(Integer[] select_item) {
		this.select_item = select_item;
	}

	@Override
	public String toString() {
		return "DeleteCartItemsForm [select_item="
				+ Arrays.toString(select_item) + "]";
	}
}
