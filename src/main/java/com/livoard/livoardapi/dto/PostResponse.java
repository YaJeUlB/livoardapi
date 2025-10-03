package com.livoard.livoardapi.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record PostResponse(
        UUID id,
        Long num,
        String title,
        String contents,
        OffsetDateTime createdAt
) {
}
