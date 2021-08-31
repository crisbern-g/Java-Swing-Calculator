/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stop.watch;



public class systemTimer{
private int progMinutes, progSecond, progMillis;
private String progTime;

public systemTimer(){
progMinutes = 0;
progSecond = 0;
progMillis = 0;
progTime = "00:00:00";
}

void incrementTime(){
    progMillis += 10;
    if(progMillis == 100){
        progSecond+=1;
        progMillis = 0;
    }
    if(progSecond == 60){
        progMinutes+=1;
        progSecond=0;
    }
}

String displayTime(){
    progTime = "";
    if(progMinutes<10)
        progTime+="0";
    progTime += String.valueOf(progMinutes)+" : ";
    if(progSecond<10)
        progTime+="0";
    progTime += String.valueOf(progSecond)+" : ";
    if(progMillis<10)
        progTime+="0";
    progTime += String.valueOf(progMillis);
    
    
    return progTime;
}

void resetTime(){
progMillis=0;
progMinutes=0;
progSecond=0;
}



}
