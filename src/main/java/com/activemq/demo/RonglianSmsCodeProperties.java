package com.activemq.demo;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@ConfigurationProperties(prefix = "user.smsCode")

@ConditionalOnProperty(name = "user.smsService.component",havingValue = "ronglianService")
@PropertySource(value = "classpath:smscode.properties", encoding = "UTF-8")
@Configuration
public class RonglianSmsCodeProperties {

    private String accountSid;

    private String accountToken;

    private String appId;

    private String serverIp;

    private String serverPort;


    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    @Bean
    public CCPRestSmsSDK createPhoneClient() {
        CCPRestSmsSDK phoneClient = new CCPRestSmsSDK();
        phoneClient.setAccount(accountSid, accountToken);
        phoneClient.init(serverIp, serverPort);
        phoneClient.setAppId(appId);
        return phoneClient;
    }
}
