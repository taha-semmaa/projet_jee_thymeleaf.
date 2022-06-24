package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Groupe;
import com.example.demo.repository.GroupeRepository;
import com.example.demo.services.groupeService;
@Service
public class groupeServiceImpl implements groupeService{

	private GroupeRepository groupeRepository;
	public groupeServiceImpl(GroupeRepository groupeRepository) {
		super();
		this.groupeRepository = groupeRepository;
	}

	@Override
	public List<Groupe> getAllgroupe() {
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}

	@Override
	public Groupe saveGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		return groupeRepository.save(groupe);
	}

	@Override
	public Groupe getGroupeById(Long id) {
		// TODO Auto-generated method stub
		return groupeRepository.findById(id).get();
	}

	@Override
	public Groupe updateGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		return groupeRepository.save(groupe);
	}

	@Override
	public void deleteGroupeById(Long id) {
		groupeRepository.deleteById(id);
		
	}

}
