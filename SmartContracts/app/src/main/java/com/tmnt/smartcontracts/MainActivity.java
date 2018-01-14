package com.tmnt.smartcontracts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.infura.InfuraHttpService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void setup() throws IOException {
        Web3j mWeb3j = Web3jFactory.build(new InfuraHttpService("https://ropsten.infura.io/vnHwsmZdVYoKbIVgwJnd"));
        Credentials credentials;

        File path = getApplicationContext().getExternalFilesDir(null);
        File walletFile = new File(path, "my.wallet");
        try (InputStream in = getResources().openRawResource(R.raw.user1);
             FileOutputStream out = new FileOutputStream(walletFile)) {
            int length;
            byte[] bytes = new byte[1024];
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            credentials = WalletUtils.loadCredentials("password", walletFile);
        } catch (IOException | CipherException e) {
            throw new IOException();
        }
    }

}
