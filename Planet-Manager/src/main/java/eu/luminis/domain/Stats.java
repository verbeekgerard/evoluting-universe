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
    private int totalDiedOfAge;
    private int totalWandered;
    private int totalCollisions;
    private int totalStarved;
    private double averageHealth;
    private double averageAge;
    private double averageDistance;
    private double averageBestFitness;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String url;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String planetName;

    @Field(type = FieldType.Date)
    private Date creationDate;
}
