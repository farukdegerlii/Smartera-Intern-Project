package com.farukdegerli.ItemService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MEMBER-SERVICE")
public interface MemberServiceClient {
    @GetMapping(value = "/member-service/permissionCheckForItem")
    Boolean isManager(@RequestParam Long id , @RequestParam String pass);
}
