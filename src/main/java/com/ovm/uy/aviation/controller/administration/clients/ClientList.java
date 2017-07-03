package com.ovm.uy.aviation.controller.administration.clients;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;

import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Car;

@Named
@ViewScoped
public class ClientList implements Serializable {
	private static final long serialVersionUID = 5252481557506002442L;
	
	LazyDataModel<Car> cars;

    Filter<Car> filter = new Filter<>(new Car());

    List<Car> selectedCars; //cars selected in checkbox column

    List<Car> filteredValue;
}
