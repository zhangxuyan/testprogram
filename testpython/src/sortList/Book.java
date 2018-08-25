package sortList;

public class Book {

	private Long id;// �鱾���

	private String name;// �鱾����

	private double price;// �鱾�۸�

	private String author;// ����

	private Integer weight;// Ȩ��

	public Book(Long Id, String Name, double Price, String Author, Integer Weight) {

		this.id = Id;

		this.name = Name;

		this.price = Price;

		this.author = Author;

		this.weight = Weight;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public double getPrice() {

		return price;

	}

	public void setPrice(double price) {

		this.price = price;

	}

	public String getAuthor() {

		return author;

	}

	public void setAuthor(String author) {

		this.author = author;

	}

	public Integer getWeight() {

		return weight;

	}

	public void setWeight(Integer weight) {

		this.weight = weight;

	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", weight=" + weight
				+ "]";
	}

}