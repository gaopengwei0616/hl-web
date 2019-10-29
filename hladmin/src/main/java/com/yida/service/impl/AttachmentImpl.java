package com.yida.service.impl;

import com.yida.entity.Attachment;
import com.yida.mapper.AttachmentMapper;
import com.yida.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentImpl implements AttachmentService {

    @Autowired
    AttachmentMapper attachmentMapper;

    @Override
    public List<Attachment> seleAttachmentBypaging() {
        return attachmentMapper.selectAttachmentsBypaging();
    }

    @Override
    public int AttachmentCount() {
        return attachmentMapper.AttachmentCount();
    }

    @Override
    public int updateByaId(int aid,int status) { return attachmentMapper.updateByaId(aid,status); }
}
