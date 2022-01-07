package assigment2;

public class Product {
    String idProduct, nameProduct;
    double priceProduct;
    int quantityProduct;

    public Product() { }

    public Product(String idProduct, String nameProduct, double priceProduct, int quantityProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-5s%-15s%-5s%-7.1f%-5s%s", idProduct, "|", nameProduct, "|", priceProduct, "|", quantityProduct);
    }
}
