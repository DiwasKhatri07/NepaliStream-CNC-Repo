package com.phisher98;

import com.lagradost.cloudstream3.plugins.BasePlugin;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import kotlin.Metadata;

/* JADX INFO: compiled from: QuickIPTVPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/QuickIPTV/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\u0007¨\u0006\u0006"}, d2 = {"Lcom/phisher98/QuickIPTVPlugin;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "QuickIPTV", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class QuickIPTVPlugin extends BasePlugin {
    public void load() {
        registerMainAPI(new SportsIPTV());
        registerMainAPI(new PirateIPTV());
        registerMainAPI(new SonyIPTV());
        registerMainAPI(new JapanIPTV());
    }
}
