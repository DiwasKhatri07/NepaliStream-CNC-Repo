package com.Cinemacity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

/* JADX INFO: compiled from: CinemacitySettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinemacity/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"restartApp", "", "context", "Landroid/content/Context;", "Cinemacity"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class CinemacitySettingsFragmentKt {
    public static final /* synthetic */ void access$restartApp(Context context) {
        restartApp(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restartApp(Context context) {
        ComponentName it;
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent != null && (it = intent.getComponent()) != null) {
            context.startActivity(Intent.makeRestartActivityTask(it));
            Runtime.getRuntime().exit(0);
        }
    }
}
