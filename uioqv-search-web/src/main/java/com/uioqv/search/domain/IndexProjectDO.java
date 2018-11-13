package com.uioqv.search.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author LiuGuoQing
 * @since 2018-11-13
 */
@Getter
@Setter
@Document
@CompoundIndexes({
        @CompoundIndex(name = "id_idx", def = "{'indexId': 1, 'projectId': 1}")
})
@AllArgsConstructor
public class IndexProjectDO {
    private String indexId;
    private String projectId;
}
