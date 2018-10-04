package hu.desnull.baltazar.kfgapp;

import android.accounts.AccountManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class KFGAuthenticatorService extends Service {
    KFGAuthenticator mKFGAuthenticator;

    @Override
    public void onCreate() {
        super.onCreate();
        mKFGAuthenticator = new KFGAuthenticator(getApplicationContext());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (AccountManager.ACTION_AUTHENTICATOR_INTENT.equals(intent.getAction())) {
            return mKFGAuthenticator.getIBinder();
        }
        return null;
    }
}