package com.farukdegerli.ItemService.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface MemberClientService {
    Boolean isManager(Long id ,String pass);
}
