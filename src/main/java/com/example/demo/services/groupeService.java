package com.example.demo.services;
import java.util.List;

import com.example.demo.entity.*;
public interface groupeService {
	List<Groupe> getAllgroupe();
	Groupe saveGroupe(Groupe groupe);
	Groupe getGroupeById(Long id);
	Groupe updateGroupe(Groupe groupe);
	void deleteGroupeById(Long id);

}
