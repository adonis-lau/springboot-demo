package bid.adonis.lau.repository;

import bid.adonis.lau.domain.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: adonis lau
 * @email: adonis.lau.dev@gmail.com
 * @date: Created in 2018/1/22 22:19
 */
@Repository
public interface CityRepository extends ElasticsearchRepository<City, Long> {

}
