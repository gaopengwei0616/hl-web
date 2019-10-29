package com.yida.mapper;

import com.yida.entity.Attachment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rishun on 2019/7/4.
 */
@Repository
public interface AttachmentMapper {
    /**
     * 分页
     *
     * @return List<Attachment>
     */
    List<Attachment> selectAttachmentsBypaging();

    /**
     * @return 总页数
     */
    int AttachmentCount();

    /**
     * 根据aid修改状态
     *
     * @return
     */
    int updateByaId(@Param("aid") int aid, @Param("status") int status);

}
