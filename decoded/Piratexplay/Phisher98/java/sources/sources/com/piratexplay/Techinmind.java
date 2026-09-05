package com.piratexplay;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Piratexplay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/piratexplay/Techinmind;", "Lcom/piratexplay/GDMirrorbot;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "Piratexplay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Techinmind extends GDMirrorbot {

    @NotNull
    private String name = "Techinmind";

    @NotNull
    private String mainUrl = "https://dlx.techinmind.space";
    private final boolean requiresReferer = true;

    @Override // com.piratexplay.GDMirrorbot
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.piratexplay.GDMirrorbot
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.piratexplay.GDMirrorbot
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.piratexplay.GDMirrorbot
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.piratexplay.GDMirrorbot
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }
}
