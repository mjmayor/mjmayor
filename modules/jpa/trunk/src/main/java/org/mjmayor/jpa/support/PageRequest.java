package org.mjmayor.jpa.support;

/**
 * Parametros para paginacion en las consultas de BBDD
 * 
 * @author Manuel Jose Mayor Perez
 * @date 24/07/2013
 */
public class PageRequest {

	private static final Integer DEFAULT_PAGE_SIZE = 20;

	private static final Integer MAX_PAGE_SIZE = 60;

	/**
	 * Numero de pagina
	 */
	private Integer page;

	/**
	 * Tamaño de la pagina
	 */
	private Integer size;

	public PageRequest() {
		this.size = DEFAULT_PAGE_SIZE;
		this.page = 0;
	}

	public PageRequest(Integer page, Integer size) {
		setPage(page);
		setSize(size);
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Integer page) {
		if ((page == null) || (page != null && page < 1)) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Integer size) {
		if (size == null) {
			this.size = DEFAULT_PAGE_SIZE;
		} else if (size.intValue() < 1) {
			throw new IllegalArgumentException("El tamaño de página debe ser mayor de uno");
		} else if (size.intValue() > MAX_PAGE_SIZE) {
			throw new IllegalArgumentException("El tamaño de página máximo permitido es de " + DEFAULT_PAGE_SIZE);
		} else {
			this.size = size;
		}
	}

	public int getFirstResult() {
		return (page - 1) * size;
	}
}
