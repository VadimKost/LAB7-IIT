package com.example.telebot

import org.fluentd.logger.FluentLogger
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
class ResourceController {
    private val logger = FluentLogger.getLogger("app", "127.0.0.1", 24224)

    @GetMapping("/")
    fun home(): String = "reciver"

    @PostMapping("/")
    fun receiver(@RequestParam("text") text: String):String{
        logger.log(
            "msg-data",
            mapOf(
                "time" to System.currentTimeMillis(),
                "msg" to text
            )
        )
        return "reciver"
    }

}
