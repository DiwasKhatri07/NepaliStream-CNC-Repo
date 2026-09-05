package com.phisher98;

import com.lagradost.cloudstream3.extractors.Filesim;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/phisher98/Mwish;", "Lcom/lagradost/cloudstream3/extractors/Filesim;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Mwish extends Filesim {

    @NotNull
    private final String name = "Mwish";

    @NotNull
    private String mainUrl = "https://mwish.pro";

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }
}
