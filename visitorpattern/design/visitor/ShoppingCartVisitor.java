package com.bridgelabz.visitorpattern.design.visitor;

public interface ShoppingCartVisitor 
{
	int visit(Book book);
	int visit(Fruit fruit);
}
