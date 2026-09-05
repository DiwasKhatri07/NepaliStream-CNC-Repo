package com.Animekhor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animekhor/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/Animekhor/PlayerDonghuaworld;", "Lcom/Animekhor/Rumble;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "requiresReferer", "", "getRequiresReferer", "()Z", "Animekhor"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PlayerDonghuaworld extends Rumble {

    @NotNull
    private String mainUrl = "https://player.donghuaworld.in";
    private final boolean requiresReferer = true;

    @Override // com.Animekhor.Rumble
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.Animekhor.Rumble
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.Animekhor.Rumble
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }
}
