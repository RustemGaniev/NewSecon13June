package ru.netology;
import org.apache.commons.codec.Charsets;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;

import java.util.List;

public class Request {

    String path;
    List<NameValuePair> params;
    NameValuePair param;

    public Request(String path) {

        this.path = path;
    }

    List<NameValuePair> getQueryParams() {

        URI uri = URI.create(path);
        String query = uri.getQuery();
        List<NameValuePair> params = URLEncodedUtils.parse(query, Charsets.UTF_8);
        for (NameValuePair param : params) {
            String name = param.getName();
            System.out.println(name + "  " + param);
        }
        return params;
    }

        NameValuePair getQueryParam(String nameOfParam) {
            for (NameValuePair param : params) {
                String name = param.getName();
                if (nameOfParam.equals(name)) {
                    System.out.println(nameOfParam + "  " + param);
                    } else {
                    System.out.println("Не найдено параметра с таким именем!");
                }
            }return param;
        }
    }
