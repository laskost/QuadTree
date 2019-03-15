
public class Point {

	double x;
	double y;
	String value;
	
	Point(double x,double y){
		this.x=x;
		this.y=y;
	}
	
	Point(double x,double y,String value){
		this.x=x;
		this.y=y;
		this.value=value;
	}
	
	public double distance(Point point1,Point point2){
		
		return Math.sqrt(Math.pow(point1.x-point2.x, 2)+Math.pow(point1.y-point2.y, 2));
		
	}
	
	public double distance(Point point1,double x,double y){
		
		return Math.sqrt(Math.pow(point1.x-x, 2)+Math.pow(point1.y-y, 2));
	}
	
	

}
