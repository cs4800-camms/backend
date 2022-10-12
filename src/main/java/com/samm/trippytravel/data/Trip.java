package com.samm.trippytravel.data;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder
@Document("trip")
public class Trip {

    @Id
    private long id;

    private String name;
    private String destination;

}
