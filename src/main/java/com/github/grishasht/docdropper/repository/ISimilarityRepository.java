package com.github.grishasht.docdropper.repository;

import com.github.grishasht.docdropper.model.impl.Similarity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ISimilarityRepository extends CrudRepository<Similarity, Long>
{
}
