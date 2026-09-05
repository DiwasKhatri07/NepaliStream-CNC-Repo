package com.phisher98;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/phisher98/Rapid;", "Lcom/phisher98/MegaPlay;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Rapid extends MegaPlay {

    @NotNull
    private final String name = "Rapid";

    @NotNull
    private final String mainUrl = "https://rapid-cloud.co";
    private final boolean requiresReferer = true;

    @Override // com.phisher98.MegaPlay
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.phisher98.MegaPlay
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.phisher98.MegaPlay
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }
}
