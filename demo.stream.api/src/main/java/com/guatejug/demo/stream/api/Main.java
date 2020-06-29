package com.guatejug.demo.stream.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mario Batres
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        
        try (InputStream inputStream = Main.class.getResource("/data.json").openStream()) {
            
            List<DataWrapper> dataWrapperList = mapper.readValue(inputStream, new TypeReference<List<DataWrapper>>() {
            });

            //Antes de Java 8
            //for (int i = 0; i < dataWrapperList.size(); i++){
            //    System.out.println(dataWrapperList.get(i));
            //}
            //Después
            /*
            List<Region> regionList = dataWrapperList.stream()
                    .map(m -> new Region(m.getRegion()))
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(regionList);
             */
            
            
            
            dataWrapperList.stream()
                    .collect(Collectors.groupingBy(m -> m.getRegion()))
                    .entrySet()
                    .stream()
                    .map(entry -> {
                        
                        String regionNombre = entry.getKey();
                        
                        List<Departamento> departamentoList = entry.getValue().stream()
                                .map(r -> {
                                    
                                    Departamento departamento = new Departamento();
                                    departamento.setCodigo(r.getDepartamento_codigo());
                                    departamento.setNombre(r.getDepartamento());
                                    
                                    Long poblacion = entry.getValue().stream()
                                            .map(m -> m.getPoblacion())
                                            .reduce(0L, (l1, l2) -> l1 + l2);
                                    
                                    departamento.setPoblacion(poblacion);
                                    
                                    return departamento;
                                })
                                .distinct()
                                .collect(Collectors.toList());
                        
                        Region region = new Region();
                        region.setNombre(regionNombre);
                        region.setDepartamentoList(departamentoList);
                        
                        return region;
                    })
                    .filter(r -> r.getNombre().length() < 15)
                    .sorted((c1, c2) -> c1.getNombre().compareTo(c2.getNombre()))
                    .forEach(region -> {
                        System.out.println(region.getNombre());
                    });
            
        }
        
    }
}
