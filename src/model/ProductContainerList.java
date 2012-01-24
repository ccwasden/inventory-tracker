package model;

import common.Result;
import java.util.*;

/**
* Manages a list of Product containers for the Product class. Makes sure that Products are
* controlled correctly within StorageContainers and ProductGroups.
*/
public class ProductContainerList {
	private SortedSet<ProductContainer> _containers;
	private Product _product;

	//////////////////////CONSTRUCTORS////////////////////////////////

	/**
	* Creates a new empty ProductContainerList
	*/
	public ProductContainerList() {
		
	}

	/**
	* Creates a new ProductContainerList from a SortedSet of ProductContainers
	*/
	public ProductContainerList(SortedSet<ProductContainer> containers) {
		
	}

	//////////////////////INSTANCE METHODS////////////////////////////

	/**
	* Adds a product container to the ProductContainerList
	* @param container The ProductContainer to add
	* @return A Result indicating success or failure and reason.
	*/
	public Result addProductContainer(ProductContainer container) {
		return null;
	}

	/**
	* Removes a ProductContainer.
	* @param container The ProductContainer to be removed.
	* @return A Result indicating success or failure and reason.
	*/
	public Result removeProductContainer(ProductContainer container) {
		return null;
	}

	/**
	* Determines if the ProductContainer is in this list.
	* @param container The ProductContainer in question.
	* @return True if container is found, else false.
	*/
	public boolean hasProductContainer(ProductContainer container) {
		return false;
	}
}
