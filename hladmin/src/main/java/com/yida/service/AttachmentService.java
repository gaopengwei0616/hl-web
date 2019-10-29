package com.yida.service;

import com.yida.entity.Attachment;

import java.util.List;

/**
 * Created by rishun on 2019/7/4.
 */
public interface AttachmentService {
    /**
     *  分页附件信息
     *    1：数据显示
     *    0:已删除数据页面不展示数据
     * @return
     */
    List<Attachment> seleAttachmentBypaging();

    /***
     *   查询状态等于1 总记录数
     * @return
     */
    int AttachmentCount();

    /***
     *  根据aid修改状态
     *     1：数据显示
     *     0:已删除数据
     * @param aid
     * @return
     */
    int  updateByaId(int aid, int status);
}
