package myaspectj;
import ecspride.Button1;
//import android.os.Bundle;
import android.util.Log;
import java.io.*;
import java.lang.*;
//import android.view.View;
//import android.view.ViewStub;
public aspect ooo {

	pointcut Button1PointCut1() : execution(* ecspride.Button1.onCreate(..));
	pointcut Button1cfow1():cflow(Button1Pointcut1);
	pointcut Button1PointCut2() : execution(* ecspride.Button1.sendMessage(..));
	pointcut Button1cfow2():cflow(Button1Pointcut2);
	
   before() : Button1PointCut1(){
	   before():Button1cfow1()
	   {
		  
		   try{
				      pointcut publicCall(): call(public Object *(..));
				      after() returning (Object o): publicCall() {
					  Log.e("no exception " ,"Entering:"+ o.getSourceLocation());
				      }
				      after(): publicCall(){
					  System.out.println("Returned or threw an Exception");
				      }
		   }
		   catch(Exception e){
			   Log.e("exception occurred","Entering : " + ?thisJoinPoint.getSourceLocation());
		   }
		   finally{
			   return true;
		   }
	   }
	   
	   //System.out.println("Entering : " + thisJoinPoint.getSourceLocation());
	  //Log.e("qy","Entering : " + thisJoinPoint.getSourceLocation());
	  
	}
   after():Button1PointCut2(){
	   before():Button1cfow2(){
		   if(e!=NUll)
		   {
			   Log.e("exception occurred","Entering : " + ?thisJoinPoint.getSourceLocation());
		   }
		   else
		   {
			   Log.e("no exception " ,"Entering:"+ o.getSourceLocation());
		   }
	   }
   }
}