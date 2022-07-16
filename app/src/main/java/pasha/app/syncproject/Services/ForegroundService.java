package pasha.app.syncproject.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

import pasha.app.syncproject.R;
import pasha.app.syncproject.Repositories.External.EmployeeWorker;

public class ForegroundService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,
                getString(R.string.channel_id))
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_content))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_MAX);

        startForeground(1, notification.build());

        periodicFetch();

        return START_NOT_STICKY;
    }

    public void periodicFetch() {
        WorkManager mWorkManager = WorkManager.getInstance(this);

        // Create Network constraint
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        PeriodicWorkRequest periodicSyncDataWork =
                // MIN INTERVAL
                // CONSUME API EVERY 15 MIN
                new PeriodicWorkRequest.Builder(EmployeeWorker.class,
                        15, TimeUnit.MINUTES)
                        .setConstraints(constraints)
                        .build();

        mWorkManager.enqueue(periodicSyncDataWork);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
