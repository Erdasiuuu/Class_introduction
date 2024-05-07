import java.util.List;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
   
	}
	
	public static class Product {
	    private double unitWeight;
	    private int count;
	    private String name;
	    private String category;
	    
	    public Product() {
	        
	    }
	    
	    public Product(String name, int count, double unitWeight, String category) {
	        this.name = name;
	        this.count = count;
	        this.unitWeight = unitWeight;
	        this.category = category;
	    }
	    
	 
	    
	    public double getUnitWeight() {
	        return unitWeight;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void setCount(int count) {
	        this.count = count;
	    }
	    
	    public void setUnitWeight(double unitWeight) {
	        this.unitWeight = unitWeight;
	    }
	    
	    public void setCategory(String category) {
	        this.category = category;
	    }
	    
	    @Override
	    public String toString() {
	        return "Product{ \n"
	    }
	}
}
