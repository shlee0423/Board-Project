package com.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Integer no;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime writeDateTime;
    private Integer viewCount;
    private Boolean isOpened;
    private Boolean isAnswered;
    private Integer password;
}
