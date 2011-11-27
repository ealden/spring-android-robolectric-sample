package net.ealden.android.web;

import com.google.sitebricks.At;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;

@At("/")
@Service
public class WebService {

    @Get
    Reply<String> helloWorld() {
        return Reply.with("Hello, world!").as(Json.class);
    }
}
