package com.campteam.start.controller.dtos._shared;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class EntityIdDto<T> {
    public EntityIdDto(T id) {
        this.id = id;
    }

    public T id;
}
