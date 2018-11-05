package com.uioqv.search.repostory;

import com.uioqv.search.domain.IndexCreateDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
public interface IndexCreateRepository extends ReactiveCrudRepository<IndexCreateDO, String> {

}
