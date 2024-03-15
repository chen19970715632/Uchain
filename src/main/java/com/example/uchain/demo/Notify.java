package com.example.uchain.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notify {
    private String message;//通知信息
    private Integer Id;//通知id
    private Integer notifyPeople;//通知人
    private Integer notifiedPeople;//被通知人
    private LocalDateTime time; //创建时间
}
