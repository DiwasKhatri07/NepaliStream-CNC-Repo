package com.phisher98;

import com.lagradost.cloudstream3.utils.Qualities;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/phisher98/Flaswish;", "Lcom/phisher98/Ridoo;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "defaulQuality", "", "getDefaulQuality", "()I", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Flaswish extends Ridoo {

    @NotNull
    private final String name = "Flaswish";

    @NotNull
    private String mainUrl = "https://flaswish.com";
    private final int defaulQuality = Qualities.Unknown.getValue();

    @Override // com.phisher98.Ridoo
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.phisher98.Ridoo
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.phisher98.Ridoo
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.phisher98.Ridoo
    public int getDefaulQuality() {
        return this.defaulQuality;
    }
}
