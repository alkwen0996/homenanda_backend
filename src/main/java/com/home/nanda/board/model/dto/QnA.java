package com.home.nanda.board.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QnA {
    @ApiModelProperty(value = "글번호")
    private String qnaId;

    @ApiModelProperty(value = "작성자 아이디")
    private String userId;

    @ApiModelProperty(value = "글제목")
    private String subject;

    @ApiModelProperty(value = "글내용")
    private String content;

    @ApiModelProperty(value = "작성일")
    private String createdDate;

    @ApiModelProperty(value = "수정일")
    private String updatedDate;

    @ApiModelProperty(value = "조회수")
    private Long hit;
}
