package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> products = new ArrayList<>();

        System.out.print("Digite o número de produtos: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("\nProduto *"+(i+1)+": ");
            System.out.print("1 - Comum\n2 - Usado\n3 - Importado\n");
            int tipo = sc.nextInt();
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preço: ");
            double price = sc.nextDouble();
            if(tipo==1){
                products.add(new Product(name, price));
            } else if(tipo==2){
                System.out.print("Data de frabricação (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, date));
            } else if(tipo==3){
                System.out.print("Taxa alfandegária: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("TAGS:");
        for (Product prod : products) {
            System.out.println(prod.tag());
        }

        sc.close();
    }
}
