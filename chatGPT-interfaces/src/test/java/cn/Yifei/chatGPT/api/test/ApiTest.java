package cn.Yifei.chatGPT.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * @author Yifei
 * @description Unit Test
 * @date 2023/5/29
 */

public class ApiTest {
    /**
     * 爬取知识星球上未回答的问题内容
     */
    @Test
    public void query_unanswered_questions() throws IOException {
        // httpclient用于执行http request
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // url是我提的一个问题, 因为是爬取所以用get
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/412282841855418/info");
        get.addHeader("cookie", "zsxq_access_token=729B7F61-7B05-3AED-7DF4-D90412C61CF9_DF952A0F98F3AB6F; abtest_env=product; zsxqsessionid=732312f82d1c701c0d296f422cc66e66; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585241822114814%22%2C%22first_id%22%3A%221885b4bae71508-09e00b3cc0705f8-26031a51-3686400-1885b4bae7220e5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4NWI0YmFlNzE1MDgtMDllMDBiM2NjMDcwNWY4LTI2MDMxYTUxLTM2ODY0MDAtMTg4NWI0YmFlNzIyMGU1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNTg1MjQxODIyMTE0ODE0In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585241822114814%22%7D%2C%22%24device_id%22%3A%221885b4bae71508-09e00b3cc0705f8-26031a51-3686400-1885b4bae7220e5%22%7D");
        get.addHeader("Content-Type", "application/json;  text/plain");

        CloseableHttpResponse response = httpClient.execute(get);
        // 如果返回正常则执行以下
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println("response.getStatusLine().getStatusCode()");
        }
    }

    @Test
    public void answer() throws IOException {
        // httpclient用于执行http request
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // url是我提的一个问题的回复选项
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412282841855418/comments");
        post.addHeader("cookie", "zsxq_access_token=729B7F61-7B05-3AED-7DF4-D90412C61CF9_DF952A0F98F3AB6F; abtest_env=product; zsxqsessionid=732312f82d1c701c0d296f422cc66e66; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585241822114814%22%2C%22first_id%22%3A%221885b4bae71508-09e00b3cc0705f8-26031a51-3686400-1885b4bae7220e5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4NWI0YmFlNzE1MDgtMDllMDBiM2NjMDcwNWY4LTI2MDMxYTUxLTM2ODY0MDAtMTg4NWI0YmFlNzIyMGU1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNTg1MjQxODIyMTE0ODE0In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585241822114814%22%7D%2C%22%24device_id%22%3A%221885b4bae71508-09e00b3cc0705f8-26031a51-3686400-1885b4bae7220e5%22%7D");
        post.addHeader("Content-Type", "application/json;  text/plain");

        //
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"hardcode answer。\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        // 如果返回正常则执行以下
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println("response.getStatusLine().getStatusCode()");
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        // httpclient用于执行http request
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // url是chatGPT的API
        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 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");
        String paramJson = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"Give me a bucketsort in java.\"}],\"temperature\": 0.7}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        // 如果返回正常则执行以下
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println("response.getStatusLine().getStatusCode()");
        }
    }
}
