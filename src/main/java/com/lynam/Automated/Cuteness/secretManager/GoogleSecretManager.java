package com.lynam.Automated.Cuteness.secretManager;

import com.google.cloud.secretmanager.v1.*;
import com.google.protobuf.ByteString;

import java.io.IOException;

public class GoogleSecretManager {

    public void googleSecretManager() throws IOException {
        String projectId = "url-shortener-417915";
        String DB_NAME_ID = "DB_NAME";
        String DB_PASS_ID = "DB_PASS";
        String APP_PASS_ID = "APP_PASS";
        String USER_NAME_ID = "USER_NAME";
        getGoogleSecretManager(projectId,DB_NAME_ID,DB_PASS_ID,APP_PASS_ID,USER_NAME_ID);
    }


    public void getGoogleSecretManager(String projectId, String DB_NAME_ID, String DB_PASS_ID, String APP_PASS_ID, String USER_NAME_ID) throws IOException {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            ProjectName projectName = ProjectName.of(projectId);

            Secret secret = Secret.newBuilder().setReplication(Replication.newBuilder().setAutomatic(Replication.Automatic.newBuilder().build()).build()).build();

            Secret DB_Name_Secret = client.createSecret(projectName, DB_NAME_ID, secret);
            Secret DB_PASS_Secret = client.createSecret(projectName, DB_PASS_ID, secret);
            Secret APP_PASS_Secret = client.createSecret(projectName, APP_PASS_ID, secret);
            Secret USER_Name_Secret = client.createSecret(projectName, USER_NAME_ID, secret);

            // ADD A SECRET VERSION
            SecretPayload payload = SecretPayload.newBuilder().setData(ByteString.copyFromUtf8("automated-cuteness!")).build();
            SecretVersion DB_NAME_addedVersion = client.addSecretVersion(DB_Name_Secret.getName(), payload);
            SecretVersion DB_PASS_addedVersion = client.addSecretVersion(DB_PASS_Secret.getName(), payload);
            SecretVersion APP_PASS_addedVersion = client.addSecretVersion(APP_PASS_Secret.getName(), payload);
            SecretVersion USER_NAME_addedVersion = client.addSecretVersion(USER_Name_Secret.getName(), payload);


            // Access the secret version.
            AccessSecretVersionResponse DB_NAME_response = client.accessSecretVersion(DB_NAME_addedVersion.getName());
            AccessSecretVersionResponse DB_PASS_response = client.accessSecretVersion(DB_PASS_addedVersion.getName());
            AccessSecretVersionResponse APP_PASS_response = client.accessSecretVersion(APP_PASS_addedVersion.getName());
            AccessSecretVersionResponse USER_NAME_response = client.accessSecretVersion(USER_NAME_addedVersion.getName());


            // PRINT SECRET. REMOVE WHEN DONE
            String data1 = DB_NAME_response.getPayload().getData().toStringUtf8();
            String data2 = DB_PASS_response.getPayload().getData().toStringUtf8();
            String data3 = APP_PASS_response.getPayload().getData().toStringUtf8();
            String data4 = USER_NAME_response.getPayload().getData().toStringUtf8();
            System.out.printf("Plaintext: %s\n", data1,data2,data3,data4);
        }
    }
}
