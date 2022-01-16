package com.vecinitas.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vecinitas.model.Vecinita;;

@Component
public class Convertidores  {		   
	        @Autowired
	        private ObjectMapper objectMapper;
    
	        public Vecinita convertToVecinita(String source) {
	        	Vecinita veci = null;
	            try {
	            	veci = objectMapper.readValue(source, Vecinita.class);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
	            return veci;
	        }
	    
	        
	public Convertidores() {}

}
