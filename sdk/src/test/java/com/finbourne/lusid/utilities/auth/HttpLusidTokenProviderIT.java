package com.finbourne.lusid.utilities.auth;

import com.finbourne.lusid.utilities.ApiConfiguration;
import com.finbourne.lusid.utilities.ApiConfigurationBuilder;
import com.finbourne.lusid.utilities.CredentialsSource;
import com.finbourne.lusid.utilities.HttpClientBuilder;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class HttpLusidTokenProviderIT {

    private HttpLusidTokenProvider httpLusidTokenProvider;

    @Before
    public void setUp() throws IOException {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        OkHttpClient httpClient = new HttpClientBuilder().build(apiConfiguration);
        httpLusidTokenProvider = new HttpLusidTokenProvider(apiConfiguration, httpClient);
    }

    @Test
    public void get_OnRequestingAnInitialToken_ShouldReturnNewToken(){
        LusidToken lusidToken = httpLusidTokenProvider.get(Optional.empty());

        assertThat(lusidToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getExpiresAt(), not(nullValue()));
    }

    @Test
    public void get_OnRequestingANewTokenWithRefreshing_ShouldReturnNewRefreshedToken(){
        LusidToken initialToken = httpLusidTokenProvider.get(Optional.empty());
        LusidToken refreshedToken = httpLusidTokenProvider.get(Optional.of(initialToken.getRefreshToken()));

        assertThat(refreshedToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(refreshedToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(refreshedToken.getExpiresAt(), not(nullValue()));
        assertThat(refreshedToken, not(equalTo(initialToken)));
    }

    @Test
    public void get_OnRequestingANewTokenWithoutRefreshing_ShouldReturnNewToken(){
        LusidToken initialToken = httpLusidTokenProvider.get(Optional.empty());
        LusidToken refreshedToken = httpLusidTokenProvider.get(Optional.empty());

        assertThat(refreshedToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(refreshedToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(refreshedToken.getExpiresAt(), not(nullValue()));
        assertThat(refreshedToken, not(equalTo(initialToken)));
    }

    // Error cases
    @Test(expected = IllegalArgumentException.class)
    public void getToken_OnBadTokenUrl() throws IOException {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        OkHttpClient httpClient = new HttpClientBuilder().build(apiConfiguration);
        apiConfiguration.setTokenUrl("invalidTokenUrl");

        HttpLusidTokenProvider httpLusidTokenProvider = new HttpLusidTokenProvider(apiConfiguration, httpClient);
        LusidToken lusidToken = httpLusidTokenProvider.get(Optional.empty());
    }
}