package com.IStreamFlare;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/IStreamFlare/Exposeworld;", "Lcom/IStreamFlare/Istreamcdn;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "requiresReferer", "", "getRequiresReferer", "()Z", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Exposeworld extends Istreamcdn {

    @NotNull
    private final String mainUrl = "https://exposeworld.art";
    private final boolean requiresReferer;

    @Override // com.IStreamFlare.Istreamcdn
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.IStreamFlare.Istreamcdn
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }
}
