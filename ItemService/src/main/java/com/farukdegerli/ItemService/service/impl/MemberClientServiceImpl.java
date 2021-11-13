package com.farukdegerli.ItemService.service.impl;

import com.farukdegerli.ItemService.client.MemberServiceClient;
import com.farukdegerli.ItemService.service.MemberClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberClientServiceImpl implements MemberClientService {
    private final MemberServiceClient memberServiceClient;

    @Override
    public Boolean isManager(Long id, String pass) {
        return memberServiceClient.isManager(id,pass);
    }
}
