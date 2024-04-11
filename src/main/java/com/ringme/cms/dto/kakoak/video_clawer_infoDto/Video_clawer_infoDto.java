package com.ringme.cms.dto.kakoak.video_clawer_infoDto;

import lombok.Data;

import java.util.Date;

@Data
public class Video_clawer_infoDto {

    private Integer id_video_info;

    private String type;

    private String url;

    private Integer active;

    private Integer status;

    private String title;

    private Integer total_video;



    private Date created_at;

}

