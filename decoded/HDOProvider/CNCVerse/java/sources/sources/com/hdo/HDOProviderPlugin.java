package com.hdo;

import android.content.Context;
import android.util.Log;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HDOPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDOProvider/CNCVerse/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/hdo/HDOProviderPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HDOProviderPlugin extends Plugin {
    public void load(@NotNull Context context) {
        HDO.INSTANCE.setCont(context);
        Log.d("HDOPlugin", "Plugin load() called");
        registerMainAPI((MainAPI) new HDO());
        Log.d("HDOPlugin", "HDO provider registered");
    }
}
