package lab3;

public class Product 
{
    private int id;
    private String name;
    private float price;
    private String category;
    public Product(int id, String name, String category, float price)
    {
        this.id=id;
        this.name=name;
        this.category=category;
        this.price=price;
    }
    public int getID() { return id; }
    public String getName() { return name; }
    public float getPrice() { return price; }
    public String getCategory() { return category; }
    public void setID(int id) { this.id=id; }
    public void setName(String name) { this.name=name; }
    public void setPrice(float price) { this.price=price; }
    public void getCategory(String category) { this.category=category; }
    @Override
    public String toString()
    {
        return id + " " + name + " " + category + " " + price;
    }
}
