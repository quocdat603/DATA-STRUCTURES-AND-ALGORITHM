package assigment2;

public class MyQueue<Product> {
    Node<Product> headNode, tailNode;
    public MyQueue() {
        this.headNode = this.tailNode = null;
    }

    public boolean isEmpty() {
        return (this.headNode == null);
    }

    public Product peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return (Product) tailNode.info;
    }

    public void push(Product newProduct) {
        if (isEmpty()) {
            this.headNode = this.tailNode = new Node(newProduct);
        } else {
            tailNode.nextNode = new Node(newProduct);
            tailNode = tailNode.nextNode;
        }
    }

    public Product pop() throws Exception{
        if (isEmpty()) {
            System.out.println("Empty");;
            throw new Exception();
        }
        Product deleteProduct = (Product) headNode.info;
        if (headNode == tailNode) {
            headNode = tailNode = null;
            System.out.println("Queue is empty");
        } else {
            headNode = headNode.nextNode;
        }
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
