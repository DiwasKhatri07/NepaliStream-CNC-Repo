package com.animesuge.provider;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/AnimeSuge/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/animesuge/provider/Vidwish;", "Lcom/animesuge/provider/MegaPlay;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "AnimeSuge_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Vidwish extends MegaPlay {

    @NotNull
    private final String name = "Vidwish";

    @NotNull
    private final String mainUrl = "https://vidwish.live";

    @Override // com.animesuge.provider.MegaPlay
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.animesuge.provider.MegaPlay
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }
}
