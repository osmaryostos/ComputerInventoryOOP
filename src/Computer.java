public class Computer {
    private String brand;
    private String model;
    private long SN; //Serial number
    private double  price;

    private static int createdComputer = 0;

    public Computer() {
        this.brand = "apple";
        this.model = "PRO";
        this.SN = 11111;
        this.price = 2000;
        createdComputer++;
    }

    public Computer(String brand, String model, long SN, double price) {
        this.brand = brand;
        this.model = model;
        this.SN = SN;
        this.price = price;
        createdComputer++;
    }

    public Computer(Computer comp) {
        this.brand = comp.getBrand();
        this.model = comp.getModel();
        this.SN = comp.getSN();
        this.price = comp.getPrice();
        createdComputer++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getSN() {
        return SN;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", SN=" + SN +
                ", price=" + price +
                '}';
    }

   public static void findNumberOfCreatedComputers(){
       System.out.println("Created Computers" + createdComputer);
    };

    public boolean equals(Computer comp){
        if(this.price == comp.getPrice() && this.brand == comp.getBrand() && this.model == comp.getModel()){
            System.out.println("Those are the same");
            return true;
        }
        System.out.println("Those are different");
        return false;
    }
}
