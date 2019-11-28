package model;

import java.util.ArrayList;

public class Product extends Entity {
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> listOfShelves = new ArrayList<Integer>();
	private String nome;
	private double desconto;
	private double valorIva;
	private double pvp;

	public Product() {
	};

	public Product(String nome, double desconto, double valorIva, double pvp) {
		super();

		this.nome = nome;
		this.desconto = desconto;
		this.valorIva = valorIva;
		this.pvp = pvp;
	}

	public String getProdName() {
		return nome;
	}

	public void setProdName(String nome) {
		this.nome = nome;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValorIva() {
		return valorIva;
	}

	public void setValorIva(double valorIva) {
		this.valorIva = valorIva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	public ArrayList<Integer> getListOfShelves() {
		return listOfShelves;
	}

	public void setListOfShelves(ArrayList<Integer> listOfShelves) {
		this.listOfShelves = listOfShelves;
	}

	@Override
	public String toString() {
		return "Product [" + nome.toUpperCase() + ", " + getId() + ", desconto=" + desconto + ", valorIva=" + valorIva
				+ ", pvp=" + pvp + "]";
	}

}