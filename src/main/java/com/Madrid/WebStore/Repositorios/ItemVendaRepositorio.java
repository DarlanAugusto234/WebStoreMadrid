package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepositorio extends JpaRepository<ItemVenda, Integer> {
}
