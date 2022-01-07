package assigment2;

public class MyStack<Product> {
    Node<Product> headNode;
    public MyStack() {
        this.headNode = null;
    }
    public boolean isEmpty() {
        return (this.headNode == null);
    }

    public Product peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!!!!!!!!!");
        }
        return (Product) headNode.info;
    }

    public void push(Product newProduct) {
        this.headNode = new Node(newProduct, headNode);
    }

    public Product push() throws Exception{
        if (isEmpty()) {
            System.out.println("Empty");;
            throw new Exception();
        }
        Product deleteProduct = (Product) this.headNode.info;
        headNode = headNode.nextNode;
        return deleteProduct;
    }
    public void showProductInfo() {
        Node<Product> eachProduct = this.headNode;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID", "|", "Product Name", "|", "Price", "|", "Quantity\n");
        System.out.println("--------------------------------------------------------------------------------------");
        while (eachProduct != null) {
            System.out.println(eachProduct.info);
            eachProduct = eachProduct.nextNode;
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
