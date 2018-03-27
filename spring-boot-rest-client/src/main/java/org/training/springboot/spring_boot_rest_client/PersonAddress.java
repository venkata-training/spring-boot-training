package org.training.springboot.spring_boot_rest_client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonAddress {

	protected String address;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
