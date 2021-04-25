package com.docket.docketapi.controller;

import jdk.nashorn.internal.scripts.JO;
import org.aspectj.bridge.IMessage;
import org.springframework.ui.Model;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.docket.docketapi.model.Cartorio;
import com.docket.docketapi.repository.CartorioRepository;

import javax.swing.*;

@RestController
@RequestMapping("/cartorios")
public class CartorioController {
	
	@Autowired
	private CartorioRepository cartorioRepository;


	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 public ModelAndView listing() {
		ModelAndView modelFinal = new ModelAndView("listagem");
		 List<Cartorio> cartoriosList = cartorioRepository.findAll();
		 modelFinal.addObject("cartorios", cartoriosList);
		 return  modelFinal;
	 }

	@GetMapping("/insert")
	public ModelAndView showFormRegister(Model model) {
		ModelAndView finalModel = new ModelAndView("insert");
		model.addAttribute("cartorio", new Cartorio());
		return  finalModel;
	}
	@PostMapping("")
	public ModelAndView insert(@ModelAttribute Cartorio cartorio){
	 	cartorioRepository.save(cartorio);
		ModelAndView finalModel = new ModelAndView("resultInsert");
		return finalModel;
	}

	@GetMapping("/update/{id}")
	public ModelAndView showFormUpdate(@PathVariable Long id, Model model) {
		ModelAndView finalModel = new ModelAndView("update");
		Cartorio cartorio = cartorioRepository.findById(id).get();
		finalModel.addObject("cartorio", cartorio) ;
		return  finalModel;
	}
	@PostMapping("/update")
	public ModelAndView updateCartorio(@ModelAttribute Cartorio cartorio) {
	 	cartorioRepository.save(cartorio);
		 ModelAndView finalModel = new ModelAndView("resultUpdate");
		 return finalModel;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {

	 	ModelAndView finalModel = new ModelAndView("listagem");


			Cartorio cartorio = cartorioRepository.findById(id).get();
			cartorioRepository.delete(cartorio);

		return finalModel;
	}
}

