package assigment2;

public class MyList<Product> {
    public Product info;
    Node<Product> headNode, tailNode;

    public MyList() {
        this.headNode = this.tailNode = null;
    }

    public MyList(Node<Product> headNode, Node<Product> tailNode) {
        this.headNode = headNode;
        this.tailNode = tailNode;
    }

    public boolean isEmpty() {
        return (this.headNode == null);
    }

    public void insertToHead(Product x) {
        Node<Product> newProduct = new Node<>(x);
        if (isEmpty()) {
            this.headNode = this.tailNode = newProduct;
        } else {
            newProduct.nextNode = this.headNode;
            this.headNode = newProduct;
        }
    }

    public void insertToTail(Product x) {
        Node<Product> newProduct = new Node<>(x);
        if (isEmpty()) {
            this.headNode = this.tailNode = newProduct;
        } else {
            Node<Product> lastNode = headNode;
            while (lastNode.nextNode != null) {
                lastNode = lastNode.nextNode;
            }
            lastNode.nextNode = newProduct;
        }
    }

    public void insertAfterPosition(int position, Product x) {
        Node<Product> newProduct = new Node<>(x);
        if (isEmpty()) {
            insertToHead(x);
        } else if(position > this.length()) {
            System.out.println("No position");
        } else if (position == this.length()) {
            insertToTail(x);
        } else {
            Node<Product> currentNode = this.headNode;
            for (int i = 0; i < position -1 ; i++){
                currentNode = currentNode.nextNode;
            }
            newProduct.nextNode = currentNode.nextNode;
            currentNode.nextNode = newProduct;
            //break;
        }
    }

    public void deleteAtTail() {
        if (headNode == null) return;
        Node<Product> lastNode = headNode;
        Node<Product> previousNode = null;
        while (lastNode.nextNode != null) {
            previousNode = lastNode;
            lastNode = lastNode.nextNode;
        }
        if (previousNode == null) {
            return;
        } else {
            previousNode.nextNode = lastNode.nextNode;
        }
    }

    public void deleteElement(Product x) {
        if (isEmpty()) {
            System.out.println("Empty!!!!!!!!!!!!!!!!!");
        }
        Node<Product> currentNode = this.headNode;
        if (this.headNode.info.equals(x)) {
            this.headNode = headNode.nextNode;
        } else {
            while (currentNode.nextNode != null) {
                if (currentNode.nextNode.info.equals(x)) {
                    Node<Product> temptNode = currentNode.nextNode;
                    currentNode.nextNode = temptNode.nextNode;
                } else {
                    currentNode = currentNode.nextNode;
                }
            }
        }
    }

    public void addMany(Product[] productArray) {
        for (Product product : productArray) {
            insertToTail(product);
        }
    }

    public int length() {
        int count = 0;
        Node<Product> currentNode = this.headNode;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.nextNode;
        }
        return count;
    }

    public void swap(Node<Product> firstNode, Node<Product> secondNode) {
        Product temp;
        temp = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = temp;
    }

    public void clear() {
        this.headNode = this.tailNode = null;
    }

    public void showProductInfo() {
        Node eachProduct = this.headNode;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID", "|", "Product Name", "|", "Price", "|", "Quantity\n");
        System.out.println("--------------------------------------------------------------------------------------");
        while (eachProduct != null) {
            System.out.println(eachProduct.info);
            eachProduct = eachProduct.nextNode;
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
