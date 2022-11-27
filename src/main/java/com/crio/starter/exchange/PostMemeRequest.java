package com.crio.starter.exchange;

import lombok.Data;

@Data
// @AllArgsConstructor
// @NoArgsConstructor
public class PostMemeRequest {
    
    private String id;

    private String name ;

    private String url ;

    private String caption ;
    
}

