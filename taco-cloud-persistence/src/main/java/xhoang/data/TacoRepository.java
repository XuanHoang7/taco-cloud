package xhoang.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import xhoang.tacos.Taco;


public interface TacoRepository 
         extends PagingAndSortingRepository<Taco, Long> {

}
