package eu.luminis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "stats", type = "thisApplicationName")
public class Stats {

    @Id
    private Long  id;

    private int totalStarved;
    private int totalCollisions;
    private int totalWandered;
    private int totalDiedOfAge;
    private double avgHealth;
    private double best;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String planetName;

    @Field(type = FieldType.Date)
    Date creationDate;
}
