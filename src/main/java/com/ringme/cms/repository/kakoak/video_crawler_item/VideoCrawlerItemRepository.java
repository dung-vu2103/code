package com.ringme.cms.repository.kakoak.video_crawler_item;

import com.ringme.cms.model.kakoak.videoclawerinfo.VideoClawerInfo;
import com.ringme.cms.model.kakoak.videocrawleritem.VideoCrawerItem;
import com.ringme.cms.model.kakoakcms.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoCrawlerItemRepository extends JpaRepository<VideoCrawerItem,Integer> {
    @Query(value = """
            select * from video_crawler_item where (:video_crawler_info_id is null or video_crawler_info_id=:video_crawler_info_id)
            """,
            countQuery= """
                    SELECT COUNT(*) FROM video_crawler_item where (:video_crawler_info_id is null or video_crawler_info_id=:video_crawler_info_id)
                    """,
            nativeQuery = true)
    Page<VideoCrawerItem> get(@Param("video_crawler_info_id") Integer video_crawler_info_id, Pageable pageable);
    @Query(value = """
            select id_string from video_crawler_item 
            """, nativeQuery = true)
    List<String> getAll();
    @Query(value = """
            select url_video_item from video_crawler_item 
            """, nativeQuery = true)
    List<String> getUrl();
}
