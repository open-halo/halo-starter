package com.example.halo.core.model.base;

import java.time.LocalDateTime;

public interface IBaseModel {
    long getId();

    LocalDateTime getCreateTime();

    LocalDateTime getUpdateTime();
}
