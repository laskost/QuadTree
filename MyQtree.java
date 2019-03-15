import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class MyQtree {

	Boundry boundry;
	final int capacity=50;
	List<Point> pointList ;
	
	MyQtree topLeft=null;
	MyQtree bottomLeft=null;
	MyQtree topRight=null;
	MyQtree bottomRight=null;
	boolean divided=false; 
	int level = 1;
	
	
	
	MyQtree(Boundry bound,int level){
		boundry=bound;
		this.level=level;
		pointList = new ArrayList<Point>();
	}
	
	public void insert(Point point){
		
		if(!this.boundry.inRange(point.x, point.y)){
			return ;
		}
		
		if(this.capacity>this.pointList.size()){
			this.pointList.add(point);
			//System.out.println("Level "+this.level+" Μπήκε το ("+point.x+","+point.y+" sto ("+
			//this.boundry.getxMin()+","+this.boundry.getyMin()+","+this.boundry.getxMax()+","+this.boundry.getyMax());
			return;}
			
			if(!divided){
			subdivide();
			}
			
			Boolean inserted=false;
			
			
			this.topLeft.insert(point);
			this.bottomLeft.insert(point);
			this.topRight.insert(point);
			this.bottomRight.insert(point);
		
		
	}
	
	
	
	
	
public List<Point> query(double x,double y,double range,List<Point> found ){
		
		Boundry rangeBoundry = new Boundry(x-range,y-range,x+range,y+range);
		
		
		
		if(!boundry.intersects(rangeBoundry, this.boundry)){
			return found;
		}else{
			
			for(Point p:this.pointList){
				if(p.distance(p, x, y)<=range){
					found.add(p);
					//System.out.println(p.distance(p, x, y));
				}
			}
			
			if(this.divided){
				//return childrens points
				if(!this.topLeft.pointList.isEmpty()){
					List<Point> found1 = new ArrayList<Point>(); 
				found.addAll(this.topLeft.query2(x, y, range, found1));}
				if(!this.topRight.pointList.isEmpty()){
					List<Point> found2 = new ArrayList<Point>(); 
				found.addAll(this.topRight.query2(x, y, range, found2));}
				if(!this.bottomLeft.pointList.isEmpty()){
					List<Point> found3 = new ArrayList<Point>(); 
				found.addAll(this.bottomLeft.query2(x, y, range, found3));}
				if(!this.bottomRight.pointList.isEmpty()){
					List<Point> found4 = new ArrayList<Point>(); 
				found.addAll(this.bottomRight.query2(x, y, range, found4));}
				
			}
			
			return found;
		}
		
		
	}
	
	
	public void subdivide(){
		
		divided=true;
		double xCentre = this.boundry.xMin+(this.boundry.xMax-this.boundry.xMin)/2;
		double yCentre = this.boundry.yMin+(this.boundry.yMax-this.boundry.yMin)/2;
		
		Boundry bbl = new Boundry(this.boundry.xMin,this.boundry.yMin,xCentre,yCentre);
		this.bottomLeft = new MyQtree(bbl,level+1);
		
		Boundry btl = new Boundry(this.boundry.xMin,yCentre,xCentre,this.boundry.yMax);
		this.topLeft = new MyQtree(btl,level+1);
		
		Boundry btr = new Boundry(xCentre,yCentre,this.boundry.xMax,this.boundry.yMax);
		this.topRight = new MyQtree(btr,level+1);
		
		Boundry bbr = new Boundry(xCentre,this.boundry.yMin,this.boundry.xMax,yCentre);
		this.bottomRight = new MyQtree(bbr,level+1);
		
	}
	
	public void printQtree(){
		
		System.out.println("LEVEL:"+this.level+" "+this.boundry.getxMin()+", "+this.boundry.getyMin()+", "+this.boundry.getxMax()
				+", "+this.boundry.getyMax());
		
		for(int i=0;i<this.pointList.size();i++){
			System.out.print("("+this.pointList.get(i).x+","+this.pointList.get(i).y+") ");
		}
		
		System.out.println();
		System.out.println();
		if(this.divided){
		
		if(!this.topLeft.pointList.isEmpty()){
		   this.topLeft.printQtree();}
		if(!this.bottomLeft.pointList.isEmpty()){
			this.bottomLeft.printQtree();}
		if(!this.topRight.pointList.isEmpty()){
			this.topRight.printQtree();}
		if(!this.bottomRight.pointList.isEmpty()){
			this.bottomRight.printQtree();}
		}
	}
	
	
	public static void main(String[] args) {
		
		MyQtree tree = new MyQtree(new Boundry(0,0,40,40),1);
		
		Random rand = new Random();
		
		for(int i=0;i<400;i++){
			
			double randx=40*rand.nextDouble();
			double randy=40*rand.nextDouble();
			Point p = new Point(randx, randy);
			//System.out.println("("+randx+","+randy+")");
			tree.insert(p);
			
		}
		
		//tree.printQtree();
		List<Point> found = new ArrayList<Point>(); 
		List<Point> foundq = new ArrayList<Point>();
		double AisPointX=40*rand.nextDouble();
		double AisPointY=40*rand.nextDouble();
		//double AisPointX=12.047154479877626;
		//double AisPointY=25.03347815992289;
		System.out.println("("+AisPointX+","+AisPointY+")");
		
		//------- QUERY1 ------------------------------//
		foundq = tree.query(AisPointX,AisPointY , 2,found);
		int length = foundq.size();
		System.out.println("Length: "+length);
		
		for(int j=0;j<foundq.size();j++){
			System.out.println("("+foundq.get(j).x+","+foundq.get(j).y+")");
			}
		
		System.out.println();
						
				
				
	}

}
