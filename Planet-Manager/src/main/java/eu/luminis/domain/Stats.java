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
    private String avgHealth;
    private String best;

    @Field(
            type = FieldType.Date,
            index = FieldIndex.not_analyzed,
            store = true,
            format = DateFormat.basic_date_time
    )
    Date date = new Date();
}
