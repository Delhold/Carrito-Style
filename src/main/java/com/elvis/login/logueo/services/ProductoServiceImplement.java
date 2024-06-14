package com.elvis.login.logueo.services;

import com.elvis.login.logueo.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImplement implements ProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1, "laptop", "computación", "Hp i7", 650.250),
                new Producto(2, "mouse", "computación", "logic", 15.52),
                new Producto(3, "televisión", "electrodomectico", "lg 56", 750.25));
    }

    @Override
    public Optional<Producto> porId(Integer id) {
        return listar().stream().filter(p->p.getIdProducto().equals(id)).findAny();
    }


}


