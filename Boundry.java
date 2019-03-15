
public class Boundry {

	double xMin;
	double xMax;
	double yMin;
	double yMax;
	
	Boundry(double xMin,double yMin,double xMax,double yMax){
		this.xMin=xMin;
		this.xMax=xMax;
		this.yMin=yMin;
		this.yMax=yMax;
	}
	
	public boolean inRange(double x, double y) {
		return (x > this.getxMin() && x <= this.getxMax()
				&& y > this.getyMin() && y <= this.getyMax());
	}
	
	public boolean contains(Point point){
		boolean cont=true;
		
		if(point.x<this.xMax && point.x>=this.xMin && point.y<this.yMax && point.y>=this.yMax){
			cont=false;
		}
		
		return cont;
	}
	
	public boolean intersects(Boundry bound1,Boundry bound2){
		
		boolean intersct = false;
		
		double leftX = Math.max(bound1.getxMin(),bound2.getxMin() );
		double rightX = Math.min(bound1.getxMax(),bound2.getxMax() );
		double bottomY = Math.max(bound1.getyMin(), bound2.getyMin());
		double topY = Math.min(bound1.getyMax(), bound2.getyMax());
		
		if(leftX<rightX && bottomY<topY){
			intersct = true;
		}
		
		return intersct;
	}
	
	
	public double getxMin() {
		return xMin;
	}

	public double getyMin() {
		return yMin;
	}

	public double getxMax() {
		return xMax;
	}

	public double getyMax() {
		return yMax;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
