package com.vuetutorial.service.impl;

import com.vuetutorial.entity.Document;
import com.vuetutorial.mapper.DocumentMapper;
import com.vuetutorial.service.DocumentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-15
 */
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements DocumentService {

}
