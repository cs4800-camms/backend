package com.samm.trippytravel.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Activity {

    String name;
    String location;

}
