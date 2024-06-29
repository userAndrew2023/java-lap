import java.util.*;
import java.util.stream.Collectors;

class Brand {
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum OS {
    WINDOWS, LINUX, MAC
}


class Laptop {

    private String name;
    private Brand brand;
    private Integer ram;
    private Integer hardDiskMemory;
    private OS os;
    private String color;
    private Integer price;

    public Laptop(String name, Brand brand, Integer ram, Integer hardDiskMemory, OS os, String color, Integer price) {
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.hardDiskMemory = hardDiskMemory;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getHardDiskMemory() {
        return hardDiskMemory;
    }

    public OS getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\nНазвание: " + this.name + "\n" +
                "Бренд: " + this.brand.getName() + "\n" +
                "ОЗУ: " + this.ram + " ГБ" + "\n" +
                "Жесткий диск : " + this.hardDiskMemory + " ГБ" + "\n" +
                "ОС: " + this.os.toString() + "\n" +
                "Цвет: " + this.color + "\n" +
                "Цена: " + this.price + " руб." + "\n-----------------------------";

    }
}

public class Store {
    public static void main(String[] args) {
        var laptops = init();
        System.out.println("Ноутбуки: ");
        System.out.println(laptops);
        System.out.println("Введите цифру для фильтра");
        System.out.println("""
                1. ОЗУ
                2. Памяти на диске
                3. Операционная система
                4. Цена""");
        Scanner scanner = new Scanner(System.in);
        int filter = Integer.parseInt(scanner.nextLine());
        switch (filter) {
            case 1 -> {
                System.out.println("Введите минимальное количество ОЗУ");
                var input = scanner.nextLine();
                var filteredRam = laptops.stream()
                        .filter(laptop -> laptop.getRam() >= Integer.parseInt(input))
                        .toList();
                System.out.println(filteredRam);
            }
            case 2 -> {
                System.out.println("Введите минимальное количество памяти на диске");
                var input = scanner.nextLine();
                var filteredHard = laptops.stream()
                        .filter(laptop -> laptop.getHardDiskMemory() >= Integer.parseInt(input))
                        .toList();
                System.out.println(filteredHard);
            }
            case 3 -> {
                System.out.println("Выберите операционную систему: WINDOWS, MAC, LINUX");
                var input = scanner.nextLine();
                var filteredOs = laptops.stream()
                        .filter(laptop -> laptop.getOs().toString().equals(input))
                        .toList();
                System.out.println(filteredOs);
            }
            case 4 -> {
                System.out.println("Введите минимальную цену");
                var input = scanner.nextLine();
                var filteredPrice = laptops.stream()
                        .filter(laptop -> laptop.getPrice() >= Integer.parseInt(input))
                        .toList();
                System.out.println(filteredPrice);
            }
        }
    }

    private static List<Laptop> init() {
        Brand apple = new Brand("Apple");
        Brand asus = new Brand("Asus");
        Brand acer = new Brand("Acer");

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop(
                "MacBook 2023",
                apple,
                16,
                1000,
                OS.MAC,
                "white",
                100000
        ));
        laptops.add(new Laptop(
                "ASUS Vivobook 15",
                asus,
                8,
                256,
                OS.WINDOWS,
                "black",
                40000
        ));
        laptops.add(new Laptop(
                "Acer Aspire 3",
                acer,
                12,
                500,
                OS.WINDOWS,
                "red",
                26000
        ));
        laptops.add(new Laptop(
                "Acer Nitro",
                acer,
                32,
                2000,
                OS.WINDOWS,
                "black",
                120000
        ));
        laptops.add(new Laptop(
                "MacBook 2020",
                apple,
                8,
                256,
                OS.MAC,
                "black",
                50000
        ));
        laptops.add(new Laptop(
                "ASUS 2020",
                asus,
                8,
                256,
                OS.LINUX,
                "white",
                20000
        ));

        return laptops;
    }
}