package textinterface;

import java.util.ArrayList;
import model.Product;
import model.Shelf;
import repositories.ProductRepository;
import repositories.ShelfRepository;

public class TextInterface {
//	static Scanner scanner.sc = new Scanner(System.in);
	private ProductRepository dbp = ProductRepository.getInstance();
	private ShelfRepository dbs = ShelfRepository.getInstance();
	private ScannerUtils scanner = new ScannerUtils();

	private Product tempProd = null;

	public static void main(String[] args) {

		TextInterface app = new TextInterface();
		// app.test();
		app.ecraInicio();

	}

	public void ecraInicio() {

		System.out.println("*********************************************************");
		System.out.println("Por favor selecione uma das opcoes:");
		System.out.println(" (1)	Listar Productos");
		System.out.println(" (2)	Listar Prateleiras");
		System.out.println(" (3) 	Sair");
		System.out.println("*********************************************************");

		int option = ScannerUtils.getInt();

		switch (option) {
		case 1:
			ecraListarProds();
			break;
		case 2:
			ecraShelves();
			break;
		case 3:
			System.out.println("******************* Sessao Terminada ********************");
			System.exit(0);
		default:
			System.out.println("Opcao invalida");
			ecraInicio();
			break;
		}
	}

	public void ecraListarProds() {
		System.out.println("*********************************************************");
		System.out.println("Por favor selecione uma das opcoes:");
		System.out.println("(1)	Criar um novo Producto");
		System.out.println("(2)	Editar um producto existente");
		System.out.println("(3) 	Consultar detalhes de um producto");
		System.out.println("(4) 	Remover um producto");
		System.out.println("(5) 	Voltar ao ecra anterior");
		System.out.println("*********************************************************");
		if (ScannerUtils.sc.hasNextInt() == false) {
			System.out.println("Por favor insira uma opcao vÃ¡lida");
			ScannerUtils.getInt();
			ecraListarProds();
		} else {

			int option = ScannerUtils.getInt();
			switch (option) {
			case 1:
				ecraNovoProducto();
				break;
			case 2:
				ecraEditarProd();
				break;
			case 3:

				consultarProds();
				break;
			case 4:

				ecraRemoverProd();
				break;
			case 5:
				ecraInicio();
			default:
				ecraListarProds();
			}
		}

	}

	public void ecraShelves() {
		System.out.println("*********************************************************");
		System.out.println("Por favor selecione uma das opcoes:");
		System.out.println("(1)	Adicionar Prateleira");
		System.out.println("(2)	Editar uma prateleira existente");
		System.out.println("(3) 	Consultar detalhes de uma prateleira");
		System.out.println("(4) 	Remover uma prateleira");
		System.out.println("(5) 	Voltar ao ecra anterior");
		System.out.println("(6) 	Consultar todas as prateleiras");
		System.out.println("*********************************************************");
		if (ScannerUtils.sc.hasNextInt() == false) {
			System.out.println("Por favor insira uma opcao vÃ¡lida");
			ScannerUtils.getInt();
			ecraShelves();
		} else {

			int option = ScannerUtils.getInt();
			switch (option) {
			case 1:

				novaPrateleira();
				break;
			case 2:

				ecraEditarPrat();
				break;
			case 3:

				consultarPrat();
				break;
			case 4:

				ecraRemoverPrat();
				break;
			case 5:
				ecraInicio();
				break;
			case 6:
				allShelves();
				ecraShelves();
				break;
			default:
				ecraShelves();
			}
		}

	}

	public void allShelves() {

		System.out.println(dbs.getAllEntities());
	}

	public void novaPrateleira() {

		long capacity = 0;
		double price = 0;
		System.out.println("*********************************************************");
		System.out.println("Qual a capacidade da nova Prateleira?");
		if (ScannerUtils.sc.hasNextLong()) {
			capacity = ScannerUtils.getInt();
		} else {
			System.out.println("insira uma opcao valida");
			ScannerUtils.sc.nextLine();
			ScannerUtils.sc.nextLine();
			novaPrateleira();
		}

		System.out.println("preco de aluguer");
		if (ScannerUtils.sc.hasNextLong()) {
			price = ScannerUtils.getInt();
			;
		} else {
			System.out.println("insira uma opcao valida");
			ScannerUtils.sc.nextLine();
			ScannerUtils.sc.nextLine();
			novaPrateleira();
		}

		Shelf pt1 = new Shelf(capacity, price);

		System.out.println("*********************************************************");
		System.out.println("confirmar dados");
		System.out.println("capacidade= " + capacity);
		System.out.println("price= " + price);
		System.out.println("prosseguir? 1/2");
		System.out.println("*********************************************************");

		if (ScannerUtils.sc.hasNextInt() == false) {
			System.out.println("Por favor insira uma opcao vÃ¡lida");
			ScannerUtils.sc.nextLine();
			novaPrateleira();
		} else {

			int option = ScannerUtils.getInt();
			switch (option) {
			case 1:
				System.out.println("Prateleira Criada");
				dbs.createEntity(pt1);
				if (tempProd != null)
					createProd(dbs.getAvailableShelf(), tempProd);
				ecraInicio();
				break;
			case 2:
				novaPrateleira();
				break;

			}
		}

	}

	public void ecraNovoProducto() {
		String nome = " ";
		double desconto = 0;
		double valorIva = 0;
		double pvp = 0;

		int input;
		System.out.println("*********************************************************");
		System.out.println("Insira o nome do producto");
		nome = ScannerUtils.sc.next();

		System.out.println("Insira o desconto");
		if (ScannerUtils.sc.hasNextLong()) {
			desconto = ScannerUtils.getInt();
			;
		} else {
			System.out.println("insira uma opcao valida");
			ScannerUtils.sc.nextLine();
			ScannerUtils.sc.nextLine();
			ecraNovoProducto();
		}

		System.out.println("Insira o valor do IVA");
		if (ScannerUtils.sc.hasNextLong()) {
			valorIva = ScannerUtils.sc.nextLong();
		} else {
			System.out.println("insira uma opcao valida");
			ScannerUtils.sc.nextLine();
			ScannerUtils.sc.nextLine();
			ecraNovoProducto();
		}

		System.out.println("Preco do produto");
		if (ScannerUtils.sc.hasNextDouble()) {
			pvp = ScannerUtils.sc.nextDouble();
		} else {
			System.out.println("insira uma opcao valida");
			ScannerUtils.sc.nextLine();
			ScannerUtils.sc.nextLine();
			ecraNovoProducto();
		}

		Product p1 = new Product(nome, desconto, valorIva, pvp);

		System.out.println("*********************************************************");
		System.out.println("confirmar dados");
		System.out.println("nome= " + nome);
		System.out.println("desconto= " + desconto);
		System.out.println("valor do iva= " + valorIva);
		System.out.println("preco= " + pvp);
		System.out.println("prosseguir? 1/2");
		System.out.println("*********************************************************");

		if (!ScannerUtils.sc.hasNextInt()) {
			ecraInicio();
			ScannerUtils.sc.nextLine();
		} else {
			input = ScannerUtils.sc.nextInt();
			if (input == 1) {

				int availableShelf = dbs.getAvailableShelf();
				if (!dbs.getAllIds().isEmpty() && availableShelf > 0) {
					createProd(availableShelf, p1);

				} else {
					System.out.println("Não existem prateleiras disponíveis.");
					tempProd = p1;
					novaPrateleira();
				}
			} else if (input == 2) {
				ecraNovoProducto();
			} else {
				System.out.println("A opcao inserida nao e valida");
				ecraNovoProducto();

			}

		}

	}

	public void createProd(int availableShelf, Product p1) {
		System.out.println("in create");
		System.out.println("producto criado");
		p1.getListOfShelves().add(availableShelf);
		dbs.getEntity(availableShelf).setNumberOfProds(p1.getId());
		dbp.createEntity(p1);
		tempProd = null;
		ecraInicio();
	}

	public void ecraEditarProd() {

		System.out.println("*********************************************************");
		System.out.println("Deseja alterar um producto existente:");
		System.out.println("1) Consultar ID dos productos");
		System.out.println("2) Introduza o ID do producto a alterar:");
		System.out.println("3) Voltar ao inicio");

		if (ScannerUtils.sc.hasNextInt()) {
			int input = ScannerUtils.sc.nextInt();
			if (input == 1) {
				listarProds();
			}

			if (input == 2) {
				editProd();
			}
			if (input == 3) {
				ecraInicio();
			}
		}

	}

	public void ecraRemoverProd() {
		System.out.println("*********************************************************");
		System.out.println("Deseja remover um producto existente:");
		System.out.println("1) Consultar ID dos productos");
		System.out.println("2) Introduza o ID do producto a remover:");
		System.out.println("3) Voltar ao inicio");

		if (ScannerUtils.sc.hasNextInt()) {
			int input = ScannerUtils.sc.nextInt();
			if (input == 1) {
				listarProds();
			}
			;
			if (input == 2) {
				removerProd();
			}
			if (input == 3) {
				ecraInicio();
			}
		}
	}

//************************************* PRODUCTOS **************************************//
	public void listarProds() {

		System.out.println("*********************************************************");
		System.out.println(dbp.getAllEntities());
		ecraListarProds();

	}

	public void editProd() {

		int id = scanner.getInt("Pesquisar por ID");

		if (dbp.getAllIds().contains(id)) {
			Product edProd = dbp.getEntity(id);
			System.out.println("Novo nome do producto");
			String nome = ScannerUtils.sc.next();

			double desconto = scanner.getInt("Introduza o valor do desconto");
			double valorIva = scanner.getInt("Introduza o valor do IVA");
			double pvp = scanner.getInt("Introduza o preco");
			System.out.println("Confirmar dados:");
			System.out.println("Nome: " + nome);
			System.out.println("Valor desconto: " + desconto);
			System.out.println("Valor do Iva: " + valorIva);
			System.out.println("Preco do prod: " + pvp);

			edProd.setProdName(nome);
			edProd.setDesconto(desconto);
			edProd.setValorIva(valorIva);
			edProd.setPvp(pvp);
			dbp.editEntity(edProd);
			System.out.println(dbp.getAllEntities());
			ecraListarProds();

		} else {
			System.out.println("Produto nao existente");
			ecraInicio();
		}

	}

	public void consultarProds() {
		System.out.println("*********************************************************");
		int id = scanner.getInt("Introduza o ID do producto a pesquisar");
		if (dbp.getAllIds().contains(id)) {
			Product sProd = dbp.getEntity(id);
			System.out.println("Consultar:");
			System.out.println("1) Nome ");
			System.out.println("2) Desconto");
			System.out.println("3) Valor do Iva");
			System.out.println("4) Preco");
			System.out.println("5) Voltar ao Inicio");

			if (ScannerUtils.sc.hasNextInt() == false) {
				System.out.println("Por favor insira uma opcao válida");
				ScannerUtils.sc.nextLine();
				consultarProds();
			} else {

				int option = ScannerUtils.getInt();
				switch (option) {
				case 1:
					System.out.println(sProd.getProdName());
					consultarProds();
					break;
				case 2:
					System.out.println(sProd.getDesconto());
					consultarProds();
					break;
				case 3:
					System.out.println(sProd.getValorIva());
					consultarProds();
					break;
				case 4:
					System.out.println(sProd.getPvp());
					consultarProds();
					break;
				case 5:
					ecraListarProds();
					break;
				default:
					consultarProds();
				}
			}

		} else {
			System.out.println("Produto nao existente");
			ecraInicio();
		}

	}

	public void removerProd() {
		int id = scanner.getInt("Pesquisar por ID");

		if (dbp.getAllIds().contains(id)) {
			Product prod = dbp.getEntity(id);
			System.out.println("Vai remover o producto: " + prod);

			int input = scanner.getInt("Deseja continuar? 1/2");

			if (input == 1) {

				dbp.removeEntity(id);
				ArrayList<Integer> s = dbp.getEntity(id).getListOfShelves();
				for (Integer e : s) {
					dbs.getEntity(e).decreaseNbrOfProds();
				}
				;

				/*
				 * dbp.getEntity(id).getListOfShelves().forEach(shelfId -> {
				 * dbs.getEntity(shelfId).decreaseNbrOfProds();
				 * 
				 * });
				 */
				ecraRemoverProd();

			}

		} else {
			System.out.println("producto nao existente");
			ecraRemoverProd();
		}
	}

//********************************** PRATELEIRAS **************************************//

	public void ecraEditarPrat() {

		System.out.println("*********************************************************");
		System.out.println("Deseja alterar uma prateleira existente");
		System.out.println("1) Consultar ID das prateleiras");
		System.out.println("2) Introduza o ID da prateleira a alterar:");
		System.out.println("3) Voltar ao inicio");

		if (ScannerUtils.sc.hasNextInt()) {
			int input = ScannerUtils.sc.nextInt();
			if (input == 1) {
				listarPrats();
			}

			if (input == 2) {
				editPrat();
			}
			if (input == 3) {
				ecraInicio();
			}
		}

	}

	public void listarPrats() {

		System.out.println("*********************************************************");
		System.out.println(dbs.getAllEntities());
		ecraShelves();

	}

	public void editPrat() {

		int id = scanner.getInt("Pesquisar por ID");

		if (dbs.getAllIds().contains(id)) {
			Shelf edPrat = dbs.getEntity(id);
			int capacity = scanner.getInt("Introduza a Capacidade");
			int shelfId = scanner.getInt("Introduza o ID a pesquisar:");

			double price = scanner.getInt("Introduza o Preco");
			System.out.println("Confirmar dados:");
			System.out.println("Capacidade: " + capacity);
			System.out.println("Preco de aluguer: " + price);

			edPrat.setCapacity(capacity);
			edPrat.setPrice(price);

			dbs.editEntity(edPrat);
			System.out.println(dbs.getAllEntities());
			listarPrats();

		} else {
			System.out.println("Prateleira nao existente");
			ecraInicio();
		}

	}

	public void consultarPrat() {
		System.out.println("*********************************************************");
		int id = scanner.getInt("Introduza o ID da prateleira a pesquisar");
		if (dbs.getAllIds().contains(id)) {
			Shelf sPrat = dbs.getEntity(id);
			System.out.println("Consultar:");
			System.out.println("1) Capacidade ");
			System.out.println("2) Productos");
			System.out.println("3) Preco");
			System.out.println("4) Voltar ao inicio.");

			if (scanner.sc.hasNextInt() == false) {
				System.out.println("Por favor insira uma opcao vÃ¡lida");
				ScannerUtils.sc.nextLine();
				consultarPrat();
			} else {

				int option = ScannerUtils.sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Capacidade: " + sPrat.getCapacity());
					consultarPrat();
					break;
				case 2:
					System.out.println("Productos: " + dbp.getProductsInShlefID(sPrat.getId()));
					consultarPrat();
					break;
				case 3:
					System.out.println("Preco: " + sPrat.getPrice());
					consultarPrat();
					break;
				case 4:
					ecraShelves();
					break;
				default:
					consultarPrat();
				}
			}

		} else {
			System.out.println("Prateleira nao existente");
			ecraInicio();
		}

	}

	public void ecraRemoverPrat() {
		System.out.println("*********************************************************");
		System.out.println("Deseja remover uma prateleira existente:");
		System.out.println("1) Consultar ID das prateleiras");
		System.out.println("2) Introduza o ID da prateleira a remover:");
		System.out.println("3) Voltar ao inicio");

		if (ScannerUtils.sc.hasNextInt()) {
			int input = ScannerUtils.sc.nextInt();
			if (input == 1) {
				ecraShelves();
			}
			;
			if (input == 2) {
				removerPrat();
			}
			if (input == 3) {
				ecraInicio();
			}
		}
	}

	public void removerPrat() {
		int id = scanner.getInt("Pesquisar por ID");

		if (dbs.getAllIds().contains(id)) {
			Shelf prat = dbs.getEntity(id);
			System.out.println("Vai remover a prateleira: " + prat);

			int input = scanner.getInt("Deseja continuar? 1/2");

			if (input == 1) {

				dbs.removeEntity(id);
				ecraRemoverPrat();

			}

		} else {
			System.out.println("prateleira nao existente");
			ecraRemoverPrat();
		}
	}
}
