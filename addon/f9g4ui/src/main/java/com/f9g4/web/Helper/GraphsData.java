package com.f9g4.web.Helper;

import java.util.Date;
import java.util.List;

public class GraphsData {
	
	public GraphsData(List<Date> lstDate,List<Integer> lstHitCount)
	{
		this.date = lstDate;
		this.hitCount = lstHitCount;
	}
	
	List<Date> date;
	List<Integer> hitCount;
	
	public List<Date> getDate() {
		return date;
	}
	public void setDate(List<Date> date) {
		this.date = date;
	}
	public List<Integer> getHitCount() {
		return hitCount;
	}
	public void setHitCount(List<Integer> hitCount) {
		this.hitCount = hitCount;
	}
	public String getFormattedDate() {
		if(hitCount.size()==0)
		{
			return "[[[1,0]]]";
		}
		String data ="[[";
		for (int i = 0; i < hitCount.size(); i++) {
			if(hitCount.get(i)!=0)
				data	+=	"[" + (i+1) + "," + hitCount.get(i) + "]";
			else
				data	+=	"[" + (i+1) + "," + "0" + "]";
			if(i!=hitCount.size()-1)
			{
				data+=",";
			}
		}
		data += "]]";
		return data;
	}
	
	public String getFormattedPointLabels() {
		if(hitCount.size()==0)
		{
			return "[0]";
		}
		String pointLabels ="[";
		for (int i = 0; i < hitCount.size(); i++) {
			if(hitCount.get(i)!=0)
				pointLabels	+=	"[" + hitCount.get(i) + "]";
			else
				pointLabels	+=	"[" + "null" + "]";
			if(i!=hitCount.size()-1)
			{
				pointLabels+=",";
			}
		}
		pointLabels += "]";
		return pointLabels;
	}
	
	@SuppressWarnings("deprecation")
	public String getFormattedTicks() {
		String[] month={"NULL","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		String ticks ="[";
		for (int i = 0; i < date.size(); i++) {
			ticks 	+= 	"[\""+month[date.get(i).getMonth()]+"/"+date.get(i).getDate()+"\"]";
			if(i!=date.size()-1)
			{
				ticks+=",";
			}
		}
		ticks +="]";
		return ticks;
	}
	
	@SuppressWarnings("deprecation")
	public String getFormattedTicks(int interVal) {
		String[] month={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		String ticks ="";
		
		if(date.size()==0)
			return "[[\"\"]]";
		if(date.size()==1){
			return "[" + "[\""+month[date.get(0).getMonth()]+"/"+date.get(0).getDate()+"\"]" + "]";
		}
		else{
			int noofDays = date.size();
			int marker = (int)Math.ceil((double)noofDays/interVal);
			int markerCounter = 1;
			ticks ="[" + "[\""+month[date.get(0).getMonth()]+"/"+date.get(0).getDate()+"\"]" + ",";
			for (int i = 1; i < date.size()-1; i++) {
				
				if(marker*markerCounter==i){
					ticks 	+= 	"[\""+month[date.get(i).getMonth()]+"/"+date.get(i).getDate()+"\"]";
					markerCounter++;
				}
				else{
					ticks 	+= 	"[\"\"]";
				}
					ticks+=",";
			}
			ticks += "[\""+month[date.get(noofDays-1).getMonth()]+"/"+date.get(noofDays-1).getDate()+"\"]" + "]";
		}
		return ticks;
	}

}
